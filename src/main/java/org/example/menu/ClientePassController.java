package org.example.menu;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;
import org.example.proyectoAle.usuarios.Administrador;
import org.example.proyectoAle.usuarios.Cliente;

import java.util.Scanner;

public class ClientePassController
{
    Sucursal sucursal;
    Banco bancoA;

    public ClientePassController(Banco bancoA, Sucursal sucursal) {
        this.bancoA = bancoA;
        this.sucursal = sucursal;
    }

    Scanner teclado = new Scanner(System.in);
    int idCliente;
    String usuario;
    String pass;
    boolean passCorrecta;
    Cliente cliente;

    public void iniciarGestionPassCliente()
    {
        do
        {
            System.out.println("INGRESE EL ID DEL CLIENTE");
            idCliente = teclado.nextInt();

            teclado.nextLine();

            cliente = sucursal.buscarCliente(idCliente);

            if (cliente == null)
            {
                System.out.println("USUARIO INEXISTENTE INTENTE NUEVAMENTE");
            }
        } while (sucursal == null);

        boolean usuarioValido = false;

        while (!usuarioValido)
        {
            System.out.println("INGRESE SU USUARIO");
            usuario = teclado.nextLine();

            if (sucursal.existeUsuario(usuario))
            {
                usuarioValido = true;
            }
            else
            {
                System.out.println("LO SENTIMOS, EL USUARIO '" + usuario + "' NO EXISTE, INTENTE NUEVAMENTE.");
            }
        }

        System.out.println("INGRESE CONTRASEÑA: ");
        pass = teclado.nextLine();

        passCorrecta = cliente.autenticar(usuario, pass);

        if (passCorrecta)
        {
            System.out.println("BANCO: " + bancoA.getNombre() + ", SUCURSAL: " + sucursal.getIdSucursal());
            System.out.println("CLIENTE: " + cliente.getNombre());

            ClienteController clienteController = new ClienteController(bancoA, sucursal, cliente);
            clienteController.iniciarMenuCliente();
        }
        else
        {
            System.out.println("CONTRASEÑA INCORRECTA, VOLVIENDO AL MENU ANTERIOR");
        }
    }
}
