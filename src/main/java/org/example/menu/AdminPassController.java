package org.example.menu;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;
import org.example.proyectoAle.usuarios.Administrador;

import java.util.Scanner;

public class AdminPassController
{
    Sucursal sucursal;
    Banco bancoA;
    Scanner teclado = new Scanner(System.in);
    String usuario;
    String pass;
    boolean passCorrecta;

    public AdminPassController(Banco bancoA, Sucursal sucursal) {
        this.bancoA = bancoA;
        this.sucursal = sucursal;
    }

    public void iniciarGestionPassAdmin(Administrador administrador) {

        System.out.println("INGRESE USUARIO: ");
        usuario = teclado.nextLine();

        System.out.println("INGRESE CONTRASEÑA: ");
        pass = teclado.nextLine();

        passCorrecta = administrador.autenticar(usuario, pass);

        if (passCorrecta)
        {
            System.out.println("BANCO FINANCIER");
            System.out.println("ADMINISTRADOR: " + administrador.getNombre());

            AdministradorController administradorController = new AdministradorController(bancoA, sucursal);
            administradorController.iniciarMenuAdmin();
        }
        else
        {
            System.out.println("CONTRASEÑA INCORRECTA, VOLVIENDO AL MENU ANTERIOR");
        }
    }
}
