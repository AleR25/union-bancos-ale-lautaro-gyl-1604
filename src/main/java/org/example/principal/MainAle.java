package org.example.principal;

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
        System.out.println("VUELVA A INTENTAR UN MONTO MENOR O PRESIONE 0 PARA SALIR");

        //CLIENTE - DEPOSITAR
        System.out.println("NOMBRE DEL BANCO + SUCURSAL");
        System.out.println("CLIENTE + NOMBRE DEL CLIENTE?");
        System.out.println("DEPOSITAR");

        //CLIENTE - TRANSFERENCIA

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
    }
}
