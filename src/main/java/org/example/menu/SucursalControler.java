package org.example.menu;

public class SucursalControler
{
    org.example.proyectoAle.entidades.Banco bancoA;
    org.example.proyectoLautaro.Entity.Banco bancoB;

    public void iniciarMenuASucursal(int teclado) {
        int opcion;

        do {
            System.out.println("NOMBRE DEL BANCO");
            System.out.println("ELEGIR UNA OPCION");
            System.out.println("1. ELEGIR SUCURSAL");
            System.out.println("2. VOLVER A SELECCION DE BANCO");
            System.out.println("0. SALIR");

            opcion = teclado.nextInt();

            switch (opcion)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("OPCION EQUIVOCADA");
            }

        } while (opcion != 0);
    }
}
