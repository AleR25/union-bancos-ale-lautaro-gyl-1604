package org.example.proyectoAle.entidades;

import org.example.proyectoAle.interf.ComponenteFinanciero;
import org.example.proyectoAle.usuarios.Administrador;
import org.example.proyectoAle.usuarios.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Sucursal implements ComponenteFinanciero
{
    private int idSucursal;
    private String direccion;
    private Administrador administrador;
    private List<Cuenta> cuentas;
    private List<Cliente> clientes;

    private static int contador = 1;

    public Sucursal(String direccion, Administrador administrador) {
        this.idSucursal = contador++;
        this.direccion = direccion;
        this.administrador = administrador;
        this.cuentas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void crearCliente(String nombre, String usuario, String pass)
    {
        clientes.add(new Cliente(nombre, false, usuario, pass));
    }

    public void crearCuenta(Cuenta cuenta) //posible tipo cuenta
    {
        cuentas.add(cuenta);
        System.out.println("Cuenta creada correctamente"); //ejecutar un if
    }

    public void solicitudCrearCuenta(int idCliente)
    {
        Solicitud solicitud = new Solicitud(buscarCliente(idCliente));
        administrador.agregarSolicitud(solicitud);
    }

    public Cuenta buscarCuenta(int idCuenta)
    {
        return cuentas.stream()
                .filter(c -> c.getIdCuenta() == idCuenta)
                .findFirst()
                .orElse(null);
    }

    //metodo para buscar cliente en List, no funciona fuera de Sucursal
    private Cliente buscarCliente(int idCliente)
    {
        return clientes.stream()
                .filter(c -> c.getIdUsuario() == idCliente)
                .findFirst()
                .orElse(null);
    }

    //
    public Cliente login(String username, String password) {
        return clientes.stream()
                .filter(u -> u.autenticar(username, password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public double getSaldo() {
        return cuentas.stream().mapToDouble(ComponenteFinanciero::getSaldo).sum();
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "idSucursal=" + idSucursal +
                ", direccion='" + direccion + '\'' +
                ", administrador=" + administrador +
                ", cuentas=" + cuentas +
                ", clientes=" + clientes +
                '}';
    }
}
