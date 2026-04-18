package org.example.proyectoAle.usuarios;

import org.example.proyectoAle.entidades.Usuario;

public class Administrador extends Usuario {
    private static int contador = 1;

    public Administrador(String nombre, boolean asignado, String username, String password)
    {
        super(contador++, 102, nombre, asignado, username, password);
    }



    @Override
    public String toString() {
        return "Administrador{" +
                '}';
    }
}
