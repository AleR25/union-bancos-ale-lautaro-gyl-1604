package org.example.proyectoAle.usuarios;

import org.example.proyectoAle.entidades.Usuario;

public class Cliente extends Usuario {
    private static int contador = 1;

    public Cliente(String nombre, boolean asignado, String username, String password) {
        super(contador++, 101, nombre, asignado, username, password);
    }

    @Override
    public String toString() {
        return "Cliente: " + super.toString();
    }
}
