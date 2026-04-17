package org.example.proyectoAle.menu;

import org.example.proyectoAle.entidades.Sucursal;

import java.util.Scanner;

public class AdminController
{
    private Sucursal sucursal;

    public AdminController(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public void iniciar(Scanner teclado) {
        int opcion;

        do {
            System.out.println("\n--- PANEL ADMIN ---");
            System.out.println("1. Gestionar solicitudes");
            System.out.println("2. Buscar cliente");
            System.out.println("0. Salir");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    mostrarSolicitudesPendientes();
                    break;
                case 2:
                    buscarCliente();
                    break;
            }

        } while (opcion != 0);
    }

    public void mostrarSolicitudesPendientes() {
        System.out.println("--- LISTA DE SOLICITUDES PENDIENTES ---");
        for (int i = 0; i < sucursal.getSolicitudes().size(); i++) {
            System.out.println(sucursal.getSolicitudes().get(i));
        }

        //MODIFICAR
        System.out.println("NO HAY MAS SOLICITUDES");
    }

    private void buscarCliente() {
        System.out.println("Lógica para buscar cliente...");
    }
}
