package org.example.menu;
import org.example.proyectoAle.entidades.Banco;

import java.util.Scanner;

public class BancoController
{
    org.example.proyectoAle.entidades.Banco bancoA;
    org.example.proyectoLautaro.Entity.Banco bancoB;
    SucursalControler sucursal;

    public BancoController(Banco bancoA, org.example.proyectoLautaro.Entity.Banco bancoB) {
        this.bancoA = bancoA;
        this.bancoB = bancoB;
        this.sucursal = new SucursalControler();
    }

    Scanner teclado;
    int opcion;

    public void iniciar(int eleccionBanco) {

        do {
            System.out.println("SELECIONAR BANCO");
            System.out.println("1. BANCO FINANCIER");
            System.out.println("2. BANCO GALICIA");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();

            switch (opcion)
            {
                case 1:
                    System.out.println("BANCO " + bancoA.);
                    sucursal.iniciarMenuASucursal(opcion);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("OPCION EQUIVOCADA");
            }

        } while (opcion != 0);
    }
}
