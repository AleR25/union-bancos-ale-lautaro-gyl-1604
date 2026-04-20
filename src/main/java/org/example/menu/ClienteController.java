package org.example.menu;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Cuenta;
import org.example.proyectoAle.entidades.Sucursal;
import org.example.proyectoAle.usuarios.Cliente;
import org.example.proyectoLautaro.Entity.CuentaBanco;
import org.example.structural.adapter.transferencias.CuentaAdapterA;
import org.example.structural.adapter.transferencias.CuentaAdapterB;
import org.example.structural.adapter.transferencias.ServicioDeTransferencia;

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
    Cuenta cuenta;
    Double monto;
    CuentaBanco cuentaB;

    public void iniciarMenuCliente()
    {
        do
        {
            System.out.println("1. SOLICITAR CUENTA");
            System.out.println("2. RETIRAR DINERO");
            System.out.println("3. DEPOSITAR");
            System.out.println("4. HACER TRANSFERENCIA LOCAL");
            System.out.println("5. HACER TRANSFERENCIA EXTERNA");
            System.out.println("6. CERRAR SESION");
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
                    cuenta = sucursal.buscarCuentaPorCliente(cliente);
                    teclado.nextDouble();

                    monto = teclado.nextDouble();

                    if (cuenta == null)
                    {
                        System.out.println("EL CLIENTE NO TIENE CUENTA");
                    }
                    else
                    {
                        cuenta.retirar(monto);
                    }
                    break;
                case 3:
                    System.out.println("BANCO: " + bancoA.getNombre() + ", SUCURSAL: " + sucursal.getIdSucursal());
                    cuenta = sucursal.buscarCuentaPorCliente(cliente);
                    teclado.nextDouble();

                    monto = teclado.nextDouble();
                    cuenta.depositar(monto);
                    break;
                case 4:
                    System.out.println("BANCO: " + bancoA.getNombre() + ", SUCURSAL: " + sucursal.getIdSucursal());
                    cuenta = sucursal.buscarCuentaPorCliente(cliente);
                    teclado.nextDouble();

                    monto = teclado.nextDouble();
                    teclado.nextInt();

                    opcion = teclado.nextInt();
                    cuenta.realizarTransferencia(monto, sucursal.buscarCuenta(opcion));
                    break;
                case 5:
                    System.out.println("BANCO: " + bancoA.getNombre() + ", SUCURSAL: " + sucursal.getIdSucursal());
                    cuenta = sucursal.buscarCuentaPorCliente(cliente);
                    CuentaAdapterA cuentaAdapterA = new CuentaAdapterA(cuenta);

                    SistemaLautaro sistemaLautaro = new SistemaLautaro();
                    sistemaLautaro.inicializarVariables();

                    System.out.println("INGRESE EL IDENTIFICADOR DE LA CUENTA EXTERNA");
                    opcion= teclado.nextInt();
                    teclado.nextDouble();

                    cuentaB = sistemaLautaro.buscarCuentaPorId(opcion);
                    CuentaAdapterB cuentaAdapterB = new CuentaAdapterB(cuentaB);

                    System.out.println("INGRESE EL MONTO A TRANSFERIR");
                    monto = teclado.nextDouble();
                    ServicioDeTransferencia.transferir(cuentaAdapterA, cuentaAdapterB, monto);
                    break;
                case 6:
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
