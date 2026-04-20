package org.example.menu;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;
import org.example.structural.adapter.balance.BalanceAdapterB;
import org.example.structural.adapter.balance.ServicioDeBalance;

import java.util.Scanner;

public class AdministradorController
{
    Banco bancoA;
    Sucursal sucursal;
    org.example.proyectoLautaro.Entity.Banco bancoB;

    public AdministradorController(Banco bancoA, org.example.proyectoLautaro.Entity.Banco bancoB, Sucursal sucursal) {
        this.bancoA = bancoA;
        this.bancoB = bancoB;
        this.sucursal = sucursal;
    }

    Scanner teclado =new Scanner(System.in);
    int opcion;

    public void iniciarMenuAdmin()
    {
        do
        {
            System.out.println("ADMINISTRADOR");
            System.out.println("1 SOLICITAR BALANCE GENERAL INTERNO");
            System.out.println("2. SOLICITAR BALANCE GENERAL EXTERNO");
            System.out.println("3. GESTION DE SOLICITUDES");
            System.out.println("4. CERRAR SESION");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();

            switch (opcion)
            {
                case 1:
                    System.out.println("EL BALANCE GENERAL INTERNO ES: " + bancoA.getSaldo());
                    break;
                case 2:
                    BalanceAdapterB balanceAdapterB = new BalanceAdapterB(bancoB);
                    System.out.println("EL BALANCE GENERAL EXTERNO ES: " + ServicioDeBalance.balanceDelB(balanceAdapterB));

                    break;
                case 3:
                    System.out.println("INGRENSANDO AL MENU DE GESTION DE SOLICITUDES");
                    SolicitudesController solicitudesController = new SolicitudesController(bancoA, sucursal);
                    solicitudesController.iniciarMenuSolicitudes();
                    break;
                case 4:
                    System.out.println("CERRANDO SESION");
                    opcion = 0;
                    break;
                case 0:
                    System.out.println("QUE TENGA BUEN DIA, VUELVA PRONTO");
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPCION EQUIVOCADA");
            }
        } while (opcion != 0);
    }
}
