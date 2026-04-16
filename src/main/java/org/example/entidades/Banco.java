package org.example.entidades;

import org.example.usuarios.Administrador;
import org.example.usuarios.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco
{
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

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    //una vez el administrador pase a administrar una sucursal asignado cambia a true
    public void contratarAdministrador(String nombre, String usuario, String pass)
    {
        administradores.add(new Administrador(nombre,false, usuario, pass));
    }

    public void crearSucursal(String direccion, Administrador administrador)
    {
        if(administrador.isAsignado() == false)
        {
            sucursales.add(new Sucursal(direccion, administrador));
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

    public Optional<Sucursal> seleccionarSucursal(int idBuscado) {
        return sucursales.stream()
                .filter(s -> s.getIdSucursal() == idBuscado)
                .findFirst();
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
}
