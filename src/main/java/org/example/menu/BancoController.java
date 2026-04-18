package org.example.menu;

import java.util.Scanner;

public class BancoController
{

    public void iniciar(Scanner teclado) {
        int opcion;

        do {
            System.out.println("SELECIONAR BANCO");
            System.out.println("1. BANCO FINANCIER");
            System.out.println("2. BANCO GALICIA");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();

            switch (opcion)
            {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("OPCION EQUIVOCADA");
            }

        } while (opcion != 0);
    }
}
