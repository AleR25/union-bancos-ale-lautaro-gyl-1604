package org.example.proyectoAle.entidades;

import org.example.proyectoAle.usuarios.Cliente;

public class Solicitud {
    private int idSolicitud;
    private boolean solicitudAprobada;
    private Cliente cliente;

    private static int contador = 1;

    public Solicitud(Cliente cliente) {
        this.idSolicitud = contador++;
        this.solicitudAprobada = false;
        this.cliente = cliente;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
