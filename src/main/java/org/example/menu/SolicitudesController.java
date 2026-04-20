package org.example.menu;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SolicitudesController
{
    Banco bancoA;
    Sucursal sucursal;

    public SolicitudesController(Banco bancoA, Sucursal sucursal) {
        this.bancoA = bancoA;
        this.sucursal = sucursal;
    }

    Scanner teclado = new Scanner(System.in);
    int opcion;

    public void iniciarMenuSolicitudes()
    {
        do
        {
            System.out.println("BANCO: " + bancoA.getNombre() + ", SUCURSAL: " + sucursal.getIdSucursal());
            System.out.println("ADMINISTRADOR");
            System.out.println("1 MOSTRAR SOLICITUDES PENDIENTES");
            System.out.println("2. ACEPTAR SOLICITUD");
            System.out.println("3. RECHAZAR SOLICITUD");
            System.out.println("4. CERRAR SESION");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();

            switch (opcion)
            {
                case 1:
                    System.out.println("SOLICITUDES PENDIENTES");
                    sucursal.getAdministrador().mostrarSolicitudesPendientes();
                    break;
                case 2:
                    System.out.println("ACEPTAR SOLICITUD");
                    //sucursal.getAdministrador().
                    break;
                case 3:
                    System.out.println("INGRENSANDO AL MENU DE GESTION DE SOLICITUDES");
                    //GESTION DE SOLICITUDES
                    break;
                case 4:
                    System.out.println("CERRANDO SESION");
                    break;
                case 0:
                    System.out.println("QUE TENGA BUEN DIA, VUELVA PRONTO");
                    System.exit(0);
                default:
                    System.out.println("OPCION EQUIVOCADA");
            }

        } while (opcion != 0);
    }
}
