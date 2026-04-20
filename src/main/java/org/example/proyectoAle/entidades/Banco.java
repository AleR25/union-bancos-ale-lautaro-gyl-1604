package org.example.proyectoAle.entidades;

import org.example.proyectoAle.interf.ComponenteFinanciero;
import org.example.proyectoAle.usuarios.Administrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco implements ComponenteFinanciero
{
    /*SE APLICO EL PATRON DE DISEÑO COMPOSITE PARA PODER HACER EL
    BALANCE GENERAL DEL DINERO QUE CIRCULA EN EL BANCO, PASANDO DESDE
    SUCURSALES HASTA LAS CUENTAS.
    * */
    private int idBanco;
    private String nombre;
    private List<Sucursal> sucursales;
    private List<Administrador> administradores;

    private static int contador = 1;

    public Banco(String nombre) {
        this.idBanco = contador++;
        this.nombre = nombre;
        this.sucursales = new ArrayList<>();
        this.administradores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void contratarAdministrador(String nombre, String usuario, String pass)
    {
        administradores.add(new Administrador(nombre,false, usuario, pass));
    }

    public void crearSucursal(String direccion, Administrador administrador)
    {
        if(!administrador.isAsignado())
        {
            sucursales.add(new Sucursal(direccion, administrador));
            administrador.setAsignado(true);
        }
        else
        {
            System.out.println("El Administrador ya se encuentra como encargado de una sucursal");
        }

    }

    public void eliminarSucursal(int idSucursal)
    {
        sucursales.removeIf(c -> c.getIdSucursal() == idSucursal);
    }

    /*public Optional<Sucursal> seleccionarSucursal(int idBuscado) {
        return sucursales.stream()
                .filter(s -> s.getIdSucursal() == idBuscado)
                .findFirst();
    }*/

    public Sucursal buscarSucursalPorId(int idBuscado) {
        return this.sucursales.stream()
                .filter(s -> s.getIdSucursal() == (idBuscado))
                .findFirst()
                .orElse(null); // Retorna null si no la encuentra
    }

    @Override
    public String toString() {
        return "Banco{" +
                "idBanco=" + idBanco +
                ", nombre='" + nombre + '\'' +
                ", sucursales=" + sucursales +
                ", administradores=" + administradores +
                '}';
    }

    @Override
    public double getSaldo() {
        return sucursales.stream().mapToDouble(ComponenteFinanciero::getSaldo).sum();
    }
}
