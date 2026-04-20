package org.example.menu;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;

import java.util.Scanner;

public class SucursalControler
{
    Sucursal sucursal;
    Scanner teclado = new Scanner(System.in);
    int opcion;
    org.example.proyectoLautaro.Entity.Banco bancoB;

    public SucursalControler(org.example.proyectoLautaro.Entity.Banco bancoB) {
        this.bancoB = bancoB;
    }

    public void iniciarMenuASucursal(org.example.proyectoAle.entidades.Banco bancoA)
    {
        do {
            System.out.println("INGRESE EL NUMERO DE SUCURSAL");
            opcion = teclado.nextInt();

            sucursal = bancoA.buscarSucursalPorId(opcion);

            if (sucursal == null)
            {
                System.out.println("SUCURSAL INEXISTENTE INTENTE NUEVAMENTE O INGRESE 0 PARA SALIR");
            }
            else
            {
                System.out.println("BANCO FINANCIER, SUCURSAL " + sucursal.getIdSucursal());
                UsuarioController usuarioController = new UsuarioController(bancoA, bancoB, sucursal);
                usuarioController.iniciarMenuUsuario();
            }

        } while (sucursal == null && opcion != 0);
    }
}
