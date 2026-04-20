package org.example.menu;
import org.example.proyectoAle.entidades.Banco;

import java.util.Scanner;

public class BancoController
{
    org.example.proyectoAle.entidades.Banco bancoA;
    org.example.proyectoLautaro.Entity.Banco bancoB;
    SucursalControler sucursal;

    public BancoController(org.example.proyectoAle.entidades.Banco bancoA, org.example.proyectoLautaro.Entity.Banco bancoB) {
        this.bancoA = bancoA;
        this.bancoB = bancoB;
        this.sucursal = new SucursalControler();
    }

    Scanner teclado =new Scanner(System.in);
    int opcion;

    public void iniciar() {

        do {
            System.out.println("SELECIONAR BANCO");
            System.out.println("1. BANCO FINANCIER");
            System.out.println("2. BANCO GALICIA");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();

            switch (opcion)
            {
                case 1:
                    System.out.println("BANCO " + bancoA.getNombre());
                    sucursal.iniciarMenuASucursal(bancoA);
                    break;
                case 2:
                    System.out.println("BANCO " + bancoB.getNombreBanco());
                    SistemaLautaro sistemaLautaro = new SistemaLautaro(bancoB,bancoA);
                    sistemaLautaro.iniciar();
                    break;
                case 0:
                    System.out.println("QUE TENGA BUEN DIA, VUELVA PRONTO");
                    break;
                default:
                    System.out.println("OPCION EQUIVOCADA");
            }

        } while (opcion != 0);
    }
}
