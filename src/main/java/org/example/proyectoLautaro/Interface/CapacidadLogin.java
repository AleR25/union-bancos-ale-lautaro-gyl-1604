package org.example.proyectoLautaro.Interface;

import org.example.proyectoLautaro.Entity.Usuarios.Usuarios;

import java.util.ArrayList;

public interface CapacidadLogin {
    Usuarios iniciarSesion(ArrayList<Usuarios>listaUsers,String username,String password);
    void cerrarSesion();
}
