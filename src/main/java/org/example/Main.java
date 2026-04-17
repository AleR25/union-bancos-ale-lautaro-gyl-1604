package org.example;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Sucursal sucursalSeleccionada = null;

        Banco financier = new Banco("Financier");
        Banco galitcia = new Banco("Galitcia");

        financier.contratarAdministrador("Juan", "juan123", "Holamundo123");
        financier.contratarAdministrador("Pedro", "pedro123", "HolaMundo123");

        financier.crearSucursal("Av cordoba", financier.getAdministradores().get(0));
        financier.crearSucursal("Av corrientes", financier.getAdministradores().get(1));


        System.out.println(financier);
    }
}