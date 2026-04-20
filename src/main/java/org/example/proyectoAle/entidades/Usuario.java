package org.example.proyectoAle.entidades;

public class Usuario {
    private int idUsuario;
    private int codRol;
    private String nombre;
    private boolean asignado;
    private String username;
    private String password;

    public Usuario(int idUsuario, int codRol, String nombre, boolean asignado, String username, String password) {
        this.idUsuario = idUsuario;
        this.codRol = codRol;
        this.nombre = nombre;
        this.asignado = asignado;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public boolean autenticar(String username, String password)
    {
        return
                this.username.equalsIgnoreCase(username)
                        && this.password.equalsIgnoreCase(password);
    }

    @Override
    public String toString() {
        return  "idUsuario=" + idUsuario +
                ", codRol=" + codRol +
                ", nombre='" + nombre +
                ", asignado=" + asignado +
                ", username='" + username +
                ", password='" + password;
    }
}
