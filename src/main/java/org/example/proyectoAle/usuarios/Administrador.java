package org.example.proyectoAle.usuarios;

import org.example.proyectoAle.entidades.Solicitud;
import org.example.proyectoAle.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario {
    private List<Solicitud> solicitudes= new ArrayList<>();

    private static int contador = 1;

    public Administrador(String nombre, boolean asignado, String username, String password)
    {
        super(contador++, 102, nombre, asignado, username, password);
    }

    public void mostrarSolicitudesPendientes()
    {
        System.out.println("--- LISTA DE SOLICITUDES PENDIENTES ---");
        for (int i = 0; i < solicitudes.size(); i++) {
            System.out.println(solicitudes.get(i));
        }
        System.out.println("NO HAY MAS SOLICITUDES");
    }

    public Cliente aceptarSolicitud(int idSolicitud)
    {
        Solicitud solicitud = buscarSolicitud(idSolicitud);
        Cliente cliente = null;

        if ( solicitud != null)
        {
            cliente = solicitud.getCliente();
            eliminarSolicitudPorId(solicitud.getIdSolicitud());
        }
        return cliente;
    }

    public void rechazarSolicitud(int idSolicitud)
    {
        Solicitud solicitud = buscarSolicitud(idSolicitud);
        Cliente cliente = null;
        if ( solicitud == null)
        {
            System.out.println("EL ID SOLICITUD NO COINCIDE CON NINGUNA");
        }
        else
        {
            eliminarSolicitudPorId(solicitud.getIdSolicitud());
        }
    }

    public Solicitud buscarSolicitud(int idSolicitud)
    {
        return solicitudes.stream()
                .filter(s -> s.getIdSolicitud() == idSolicitud)
                .findFirst()
                .orElse(null);
    }

    public void eliminarSolicitudPorId(int idSolicitud)
    {
        solicitudes.removeIf(s -> s.getIdSolicitud() == idSolicitud);
    }

    public void agregarSolicitud(Solicitud solicitud)
    {
        this.solicitudes.add(solicitud);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "solicitudes=" + solicitudes +
                '}';
    }
}
