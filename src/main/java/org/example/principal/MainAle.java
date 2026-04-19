package org.example.principal;

import org.example.menu.BancoController;
import org.example.proyectoAle.entidades.Sucursal;
import org.example.proyectoLautaro.Entity.CuentaBanco;
import org.example.proyectoLautaro.Entity.Enum.Rol;
import org.example.proyectoLautaro.Entity.Enum.TipoCuenta;
import org.example.proyectoLautaro.Entity.Usuarios.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainAle
{
    public static void main(String[] args)
    {
        System.out.println("SELECIONAR BANCO");
        System.out.println("1. BANCO FINANCIER");
        System.out.println("2. BANCO GALICIA");
        System.out.println("0. SALIR");

        System.out.println("NOMBRE DEL BANCO");
        System.out.println("ELEGIR UNA OPCION");
        System.out.println("1. ELEGIR SUCURSAL");
        System.out.println("2. VOLVER A SELECCION DE BANCO");
        System.out.println("0. SALIR");

        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("ELEGIR UNA OPCION");
        System.out.println("1. SOY ADMINISTRADOR");
        System.out.println("2. SOY CLIENTE");
        System.out.println("3. QUIERO SER CLIENTE");
        System.out.println("4. VOLVER A SELECCION DE SUCURSAL");
        System.out.println("0. SALIR");

        //INICIAR SESION
        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("CLIENTE O ADMINISTRADOR INICIO DE SESION");
        System.out.println("INGRESE SU USUARIO"); // EL USUARIO TENDRIA QUE SER UNICO?
        System.out.println("INGRESE SU CONTRASEÑA");

        //ADMISTRADOR
        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("ADMINISTRADOR");
        System.out.println("1 SOLICITAR BALANCE GENERAL INTERNO");
        System.out.println("2. SOLICITAR BALANCE GENERAL EXTERNO");
        System.out.println("3. REVISAR SOLICITUDES");
        System.out.println("4. CERRAR SESION");
        System.out.println("0. SALIR");

        //SOLICITAR BALANCE TANTO INTERNO COMO EXTERNO ENVIARIA EL VALOR DEL BALANCE
        //CREO QUE ESO SERIA
        //AL MENOS QUE SE NOS OCURRA OTRA COSA

        //REVISAR SOLICITUDES
        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("ADMINISTRADOR");
        System.out.println("REVISAR SOLICITUDES");
        System.out.println("1. VER SOLICITUDES PENDIENTES");
        System.out.println("2. RESOLVER SOLICITUD PENDIENTE");
        System.out.println("3. VOLVER A SELECCION ANTERIOR");
        System.out.println("0. SALIR");

        //CLIENTE
        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("CLIENTE + NOMBRE DEL CLIENTE?");
        System.out.println("1. SOLICITAR CUENTA");
        System.out.println("2. RETIRAR DINERO");
        System.out.println("3. DEPOSITAR");
        System.out.println("4. HACER HACER TRANSFERENCIA");
        System.out.println("5. CERRAR SESION");
        System.out.println("0. SALIR");

        // CLIENTE - SOLICITUD CUENTA
        System.out.println("ENVIANDO SOLICITUD DE CUENTA...");
        System.out.println("SOLICITUD DE CUENTA ENVIARA");
        System.out.println("SE LE ENVIARÁ UN MENSAJE CUANDO SE ACEPTE SU SOLICITUD");

        //SI NO TIENE CUENTA EL CLIENTE NO PUEDE ACCEDER A LAS OPCIONES 2,3,4

        //CLIENTE - RETIRAR DINERO
        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("CLIENTE + NOMBRE DEL CLIENTE?");
        System.out.println("RETIRAR DINERO");
        System.out.println("INGRESE EL MONTO QUE DESEA RETIRAR");

        //CLIENTE - RETIRAR DINERO - RESPUESTA POSITIVA
        System.out.println("EL SALDO EN SU CUENTA ACTUALMENTE ES DE: . . .");
        System.out.println("VOLVIENDO AL MENU CLIENTE");

        //CLIENTE - RETIRAR DINERO - RESPUESTA NEGATIVA
        System.out.println("EL MONTO A RETIRAR EXCEDE SU SALDO ACTUAL");
        System.out.println("VOLVIENDO AL MENU CLIENTE");

        //CLIENTE - DEPOSITAR
        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("CLIENTE + NOMBRE DEL CLIENTE?");
        System.out.println("DEPOSITAR");
        System.out.println("EL SALDO EN SU CUENTA ACTUALMENTE ES DE: . . .");
        System.out.println("VOLVIENDO AL MENU CLIENTE");

        //CLIENTE - TRANSFERENCIA INTERNA
        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("CLIENTE + NOMBRE DEL CLIENTE?");
        System.out.println("TRANSFERIR");
        System.out.println("INGRESE EL MONTO A TRANSFERIR");
        System.out.println("INGRESE EL ID DE LA PERSONA A QUIEN DESEA TRANSFERIR");
        // ACA ESTARIA REALIZANDO LAS DIFERENTES VALIDACIONES

        //CLIENTE - TRANSFERENCIA EXTERNA
        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("CLIENTE + NOMBRE DEL CLIENTE?");
        System.out.println("TRANSFERIR");
        System.out.println("INGRESE EL MONTO A TRANSFERIR");
        System.out.println("INGRESE EL NUMERO DE SUCURSAL A TRANSFERIR");//SE SUPONE QUE EL BANCO YA ESTARIA PRESELECCIONADO
        System.out.println("INGRESE EL ID DE LA PERSONA A QUIEN DESEA TRANSFERIR");
        // ACA ESTARIA REALIZANDO LAS DIFERENTES VALIDACIONES

        //QUIERO SER CLIENTE
        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("ELEGIR UNA OPCION");
        System.out.println("QUIERO SER CLIENTE");
        System.out.println("LE DAMOS LA BIENVENIDA A NUESTRO BANCO");
        System.out.println("POR FAVOR INGRESE SU NOMBRE Y APELLIDO");
        //VA A HABER UN SCANNER
        System.out.println("POR FAVOR INGRESE SU NOMBRE DE USUARIO");
        //VA A HABER UN SCANNER
        System.out.println("POR FAVOR INGRESE SU CONTRASEÑA NUEVA");
        //VA A HABER UN SCANNER
        System.out.println("INICIE SESION PARA ENVIAR LA SOLICITUD DE CREACIÓN DE CUENTA");
        System.out.println("VOLVIENDO AL MENÚ ANTERIOR"); //MENU OPCIONES
        //EN ESTA SECCION PODRIAMOS REALIZAR ALGUNAS VALIDACIONES PERO ESO
        //VA A DEPENDER DEL TIEMPO EN EL QUE HAGAMOS EL RESTO DEL CODIGO
        //EN MI CODIGO ESTO INVOCARIA A UNA FUNCION EN SUCURSAL QUE CREARIA
        //UN CLIENTE
        //SE ENVIARIA LA SOLICITUD AL ADMINISTRADOR DE LA SUCURSAL PARA ACEPTARLO O RECHARZARLO

        Scanner teclado = new Scanner(System.in); //int
        Scanner teclado2 = new Scanner(System.in);//String

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

        BancoController controladorMenu = new BancoController(financier, galicia);

    }
    }
}
