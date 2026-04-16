package org.example.entidades;

import org.example.usuarios.Administrador;
import org.example.usuarios.Cliente;

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

}
