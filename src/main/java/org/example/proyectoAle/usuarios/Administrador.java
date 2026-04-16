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

    public void resolverSolicitud()
    {

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
