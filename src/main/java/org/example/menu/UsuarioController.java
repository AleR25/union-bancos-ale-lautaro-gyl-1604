package org.example.menu;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;
import org.example.proyectoAle.usuarios.Administrador;

import java.util.Scanner;

public class UsuarioController
{
    Banco bancoA;
    Sucursal sucursal;

    public UsuarioController(Banco bancoA, Sucursal sucursal) {
        this.bancoA = bancoA;
        this.sucursal = sucursal;
    }

    Scanner teclado =new Scanner(System.in);
    int opcion;

    public void iniciarMenuUsuario() {

        do {
            System.out.println("ELEGIR UNA OPCION");
            System.out.println("1. SOY ADMINISTRADOR");
            System.out.println("2. SOY CLIENTE");
            System.out.println("3. QUIERO SER CLIENTE");
            System.out.println("4. VOLVER A SELECCION DE SUCURSAL");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();

            switch (opcion)
            {
                case 1:
                    System.out.println("BANCO FINANCIER " + sucursal.getIdSucursal());
                    System.out.println("ADMINISTRADOR");

                    AdminPassController adminPassController = new AdminPassController(bancoA, sucursal);
                    adminPassController.iniciarGestionPassAdmin(sucursal.getAdministrador());
                    break;
                case 2:
                    System.out.println("BANCO FINANCIER " + sucursal.getIdSucursal());
                    System.out.println("CLIENTE");

                    ClientePassController clientePassController = new ClientePassController(bancoA, sucursal);
                    clientePassController.iniciarGestionPassCliente();

                    break;
                case 3:
                    System.out.println("BANCO " + bancoA.getNombre() + ", SUCURSAL " + sucursal.getIdSucursal());
                    System.out.println("QUIERO SER CLIENTE");

                    QuieroSerClienteController quieroSerClienteController = new QuieroSerClienteController(bancoA, sucursal);
                    quieroSerClienteController.crearUsuario();
                    break;
                case 4:
                    System.out.println("VOLVIENDO A SELECCION DE BANCO");
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
