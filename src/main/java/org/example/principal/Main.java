package org.example.principal;

import org.example.menu.BancoController;
import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); //int
        Scanner teclado2 = new Scanner(System.in);//String

        Sucursal sucursalSeleccionada = null;

        org.example.proyectoAle.entidades.Banco financier = new org.example.proyectoAle.entidades.Banco("Financier");
        org.example.proyectoLautaro.Entity.Banco galicia = new org.example.proyectoLautaro.Entity.Banco(1, "galicia", "corrientes123", );

        financier.contratarAdministrador("Juan", "juan123", "Holamundo123");
        financier.contratarAdministrador("Pedro", "pedro123", "HolaMundo123");

        financier.crearSucursal("Av cordoba", financier.getAdministradores().get(0));
        financier.crearSucursal("Av corrientes", financier.getAdministradores().get(0));

        System.out.println(financier);

        BancoController controladorMenu = new BancoController(financier, galicia);



    }
}