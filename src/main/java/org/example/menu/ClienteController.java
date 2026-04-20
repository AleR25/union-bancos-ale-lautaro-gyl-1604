package org.example.menu;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;
import org.example.proyectoAle.usuarios.Cliente;

import java.util.Scanner;

public class ClienteController
{
    Banco bancoA;
    Sucursal sucursal;
    Cliente cliente;

    public ClienteController(Banco banco, Sucursal sucursal, Cliente cliente)
    {
        this.bancoA = banco;
        this.sucursal = sucursal;
        this.cliente = cliente;
    }

    Scanner teclado = new Scanner(System.in);
    int opcion;

    public void iniciarMenuCliente()
    {
        do
        {
            System.out.println("1. SOLICITAR CUENTA");
            System.out.println("2. RETIRAR DINERO");
            System.out.println("3. DEPOSITAR");
            System.out.println("4. HACER HACER TRANSFERENCIA");
            System.out.println("5. CERRAR SESION");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();

            switch (opcion)
            {
                case 1:
                    System.out.println("BANCO: " + bancoA.getNombre() + ", SUCURSAL: " + sucursal.getIdSucursal());
                    sucursal.solicitudCrearCuenta(cliente.getIdUsuario());
                    System.out.println("SOLICITUD ENVIADA A REVISION");
                    break;
                case 2:
                    System.out.println("BANCO: " + bancoA.getNombre() + ", SUCURSAL: " + sucursal.getIdSucursal());
                    break;
                case 3:
                    System.out.println("BANCO: " + bancoA.getNombre() + ", SUCURSAL: " + sucursal.getIdSucursal());
                    break;
                case 4:
                    System.out.println("BANCO: " + bancoA.getNombre() + ", SUCURSAL: " + sucursal.getIdSucursal());
                    break;
                case 5:

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
