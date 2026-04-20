package org.example.menu;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;

import java.util.Scanner;

public class QuieroSerClienteController
{
    Banco banco;
    Sucursal sucursal;

    public QuieroSerClienteController(Banco banco, Sucursal sucursal) {
        this.banco = banco;
        this.sucursal = sucursal;
    }

    Scanner teclado = new Scanner(System.in);
    String nombre;
    String usuario;
    String pass;

    public void crearUsuario()
    {
        System.out.println("LE DAMOS LA BIENVENIDA A NUESTRO BANCO");
        System.out.println("POR FAVOR INGRESE SU NOMBRE Y APELLIDO");
        nombre = teclado.nextLine();

        boolean usuarioValido = false;

        while (!usuarioValido)
        {
            System.out.println("POR FAVOR INGRESE SU NOMBRE DE USUARIO");
            usuario = teclado.nextLine();

            if (!sucursal.existeUsuario(usuario))
            {
                usuarioValido = true;
            }
            else
            {
                System.out.println("LO SENTIMOS, EL USUARIO INGRESADO YA EXISTE");
            }
        }

        System.out.println("POR FAVOR INGRESE SU CONTRASEÑA NUEVA");
        pass = teclado.nextLine();

        sucursal.crearCliente(nombre, usuario, pass);

        System.out.println("INICIE SESION PARA ENVIAR LA SOLICITUD DE CREACIÓN DE CUENTA");
        System.out.println("VOLVIENDO AL MENÚ ANTERIOR");
    }
}
