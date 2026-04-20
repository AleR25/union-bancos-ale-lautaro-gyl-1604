package org.example.principal;

import org.example.menu.BancoController;
import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.entidades.Sucursal;
import org.example.proyectoLautaro.Entity.CuentaBanco;
import org.example.proyectoLautaro.Entity.Enum.Rol;
import org.example.proyectoLautaro.Entity.Enum.TipoCuenta;
import org.example.proyectoLautaro.Entity.Usuarios.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        Sucursal sucursalSeleccionada = null;

        org.example.proyectoAle.entidades.Banco financier = new org.example.proyectoAle.entidades.Banco("Financier");

        financier.contratarAdministrador("Juan", "juan123", "Holamundo123");
        financier.contratarAdministrador("Pedro", "pedro123", "HolaMundo123");

        financier.crearSucursal("Av cordoba", financier.getAdministradores().get(0));
        financier.crearSucursal("Av corrientes", financier.getAdministradores().get(0));

        System.out.println(financier);

        ArrayList<Usuarios> usuarios = new ArrayList<>();

        ArrayList<org.example.proyectoLautaro.Entity.Sucursal> sucursalesIcbc = new ArrayList<>();
        ArrayList<org.example.proyectoLautaro.Entity.Sucursal> sucursalesGalicia = new ArrayList<>();

        org.example.proyectoLautaro.Entity.Banco bancoGalicia = new org.example.proyectoLautaro.Entity.Banco(1, "Galicia", "Direccion 123", sucursalesGalicia);
        org.example.proyectoLautaro.Entity.Banco bancoIcbc = new org.example.proyectoLautaro.Entity.Banco(2, "ICBC", "Direccion 234", sucursalesIcbc);

        org.example.proyectoLautaro.Entity.Sucursal sucursal1 = new org.example.proyectoLautaro.Entity.Sucursal("Sucursal Urquiza", 1, "Larralde 231", bancoGalicia, usuarios);
        sucursalesGalicia.add(sucursal1);

        CuentaBanco cuentaBanco1 = new CuentaBanco(1, "CBU1", TipoCuenta.SUELDO, 0, bancoGalicia,false);
        CuentaBanco cuentaBanco2 = new CuentaBanco(2, "CBU2", TipoCuenta.SUELDO, 0, bancoGalicia,false);
        CuentaBanco cuentaBanco3 = new CuentaBanco(3, "CBU3", TipoCuenta.SUELDO, 0, bancoGalicia,false);
        CuentaBanco cuentaBanco4 = new CuentaBanco(4, "CBU4", TipoCuenta.SUELDO, 0, bancoGalicia,false);
        CuentaBanco cuentaBanco5 = new CuentaBanco(5, "CBU5", TipoCuenta.SUELDO, 0, bancoGalicia,false);
        CuentaBanco cuentaBanco6 = new CuentaBanco(6, "CBU6", TipoCuenta.SUELDO, 0, bancoGalicia,false);

        Admin admin1 = new Admin(1, "Enzo", "Fernandez", 4522233, "Larralde 3421", Rol.ADMIN, "admin1", "pass3", bancoGalicia, sucursal1, cuentaBanco2);
        AdminBancario adminGalicia = new AdminBancario(2, "Lautaro ", "Fernandez", 45236660, "Valdenegro 3430", Rol.ADMIN_BANCARIO, "adminG", "passG", bancoGalicia, sucursal1, cuentaBanco4);
        Cliente cliente1 = new Cliente(3, "Nicolas", "Jardel", 235552, "San bernardo 123", Rol.CLIENTE, "Cuser", "Cpass", bancoGalicia, sucursal1, cuentaBanco1);
        GestorClientes gestorClientes = new GestorClientes(4, "Ezequiel", "Villareal", 12344, "Direccion generica 123", Rol.G_CLIENTES, "GCuser", "GCpass", bancoGalicia, sucursal1, cuentaBanco3);
        GestorBalances gestorBalances=new GestorBalances(5,"Juan pablo","Conti",2334112,"Direccio generica 462", Rol.G_BALANCES,"GBuser","GBpass",bancoGalicia,sucursal1,cuentaBanco5);
        GestorCuentasBancarias gestorCuentasBancarias=new GestorCuentasBancarias(6,"Dariel","Castillo",72157,"Triunvirato 582",Rol.G_CUENTAS,"GCBuser","GCBpass",bancoGalicia,sucursal1,cuentaBanco6);

        usuarios.add(cliente1);
        usuarios.add(gestorClientes);
        usuarios.add(admin1);
        usuarios.add(adminGalicia);
        usuarios.add(cliente1);
        usuarios.add(gestorBalances);
        usuarios.add(gestorCuentasBancarias);

        adminGalicia.realizarApertura(1);
        adminGalicia.realizarApertura(2);
        adminGalicia.realizarApertura(3);
        adminGalicia.realizarApertura(4);
        adminGalicia.realizarApertura(5);
        adminGalicia.realizarApertura(6);

        adminGalicia.depositarSueldo(1,1);
        adminGalicia.depositarSueldo(2,1);
        adminGalicia.depositarSueldo(3,1);
        adminGalicia.depositarSueldo(4,1);
        adminGalicia.depositarSueldo(5,1);
        adminGalicia.depositarSueldo(6,10);

        bancoGalicia.hacerBalancesSucursal(1);

        adminGalicia.verUsuarios();

        bancoGalicia.hacerBalanceCuentas();

        BancoController bancoController = new BancoController(financier, bancoGalicia);
        bancoController.iniciar();


    }
}