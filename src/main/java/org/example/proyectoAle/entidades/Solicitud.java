package org.example.proyectoAle.entidades;

import org.example.proyectoAle.usuarios.Cliente;

//agregar nombre titular y tipo de cuenta
public class Solicitud {
    private int idSolicitud;
    private boolean solicitudAprobada;
    private Cliente cliente;
    private TipoCuenta tipoCuenta;

    private static int contador = 1;

    public Solicitud(Cliente cliente, TipoCuenta tipoCuenta) {
        this.idSolicitud = contador++;
        this.solicitudAprobada = false;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public boolean isSolicitudAprobada() {
        return solicitudAprobada;
    }

    public void setSolicitudAprobada(boolean solicitudAprobada) {
        this.solicitudAprobada = solicitudAprobada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
