package org.example.proyectoAle.menu;

import org.example.proyectoAle.entidades.Cuenta;
import org.example.proyectoAle.entidades.Solicitud;
import org.example.proyectoAle.entidades.Sucursal;

import java.util.List;

public class SolicitudService {
    private Sucursal sucursal;

    public SolicitudService(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public void gestionarSolicitudes() {
        List<Solicitud> solicitudes = sucursal.getSolicitudes();

        for (Solicitud s : solicitudes) {
            System.out.println(s);
        }

        // elegir solicitud
        // aprobar o rechazar
    }

    public void aprobarSolicitud(Solicitud solicitud) {
        // crear cuenta
        Cuenta cuenta = new Cuenta(solicitud.getCliente().getNombre(),
                solicitud.getCliente(),
                solicitud.getTipoCuenta());

        sucursal.agregarCuenta(cuenta);

        eliminarSolicitud(solicitud);
    }

    public void rechazarSolicitud(Solicitud solicitud) {
        eliminarSolicitud(solicitud);
    }

    private void eliminarSolicitud(Solicitud solicitud) {
        sucursal.getSolicitudes().remove(solicitud);
    }
}
