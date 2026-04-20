package org.example.menu;

import org.example.proyectoAle.entidades.Cuenta;
import org.example.proyectoLautaro.Entity.Banco;
import org.example.proyectoLautaro.Entity.CuentaBanco;
import org.example.proyectoLautaro.Entity.Enum.Rol;
import org.example.proyectoLautaro.Entity.Enum.TipoCuenta;
import org.example.proyectoLautaro.Entity.Sucursal;
import org.example.proyectoLautaro.Entity.Usuarios.*;
import org.example.structural.adapter.balance.BalanceAdapterA;
import org.example.structural.adapter.balance.IComponenteFinanciero;
import org.example.structural.adapter.balance.ServicioDeBalance;
import org.example.structural.adapter.transferencias.CuentaAdapterA;
import org.example.structural.adapter.transferencias.CuentaAdapterB;
import org.example.structural.adapter.transferencias.ServicioDeTransferencia;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaLautaro
{
    private ArrayList<Usuarios> usuarios = new ArrayList<>();
    private ArrayList<CuentaBanco> cuentas = new ArrayList<>();
    private ArrayList<Sucursal> sucursalesGalicia = new ArrayList<>();
    private Banco bancoGalicia;
    private org.example.proyectoAle.entidades.Banco bancoAle;


    public SistemaLautaro(Banco bancoB, org.example.proyectoAle.entidades.Banco bancoAle) {
        this.bancoGalicia = bancoB;
        this.bancoAle=bancoAle;
                //new Banco(1, "Galicia", "Direccion 123", sucursalesGalicia);
    }

    public SistemaLautaro()
    {

    }

    public CuentaBanco buscarCuentaPorId(int id) {
        return cuentas.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    Sucursal sucursal1;

    public void inicializarVariables()
    {
        sucursal1 = new Sucursal("Sucursal Urquiza", 1, "Larralde 231", bancoGalicia, usuarios);
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

        sucursal1.getClientesSucursal().add(admin1);
        sucursal1.getClientesSucursal().add(adminGalicia);
        sucursal1.getClientesSucursal().add(cliente1);
        sucursal1.getClientesSucursal().add(gestorClientes);
        sucursal1.getClientesSucursal().add(gestorBalances);
        sucursal1.getClientesSucursal().add(gestorCuentasBancarias);

        usuarios.add(cliente1);
        usuarios.add(gestorClientes);
        usuarios.add(admin1);
        usuarios.add(adminGalicia);
        usuarios.add(gestorBalances);
        usuarios.add(gestorCuentasBancarias);

        adminGalicia.realizarApertura(1);
        adminGalicia.realizarApertura(2);
        adminGalicia.realizarApertura(3);
        adminGalicia.realizarApertura(4);
        adminGalicia.realizarApertura(5);
        adminGalicia.realizarApertura(6);

        adminGalicia.depositarSueldo(1,1000);
        adminGalicia.depositarSueldo(2,1000);
        adminGalicia.depositarSueldo(3,1000);
        adminGalicia.depositarSueldo(4,1000);
        adminGalicia.depositarSueldo(5,1000);
        adminGalicia.depositarSueldo(6,1000);

        cuentas.add(cuentaBanco1);
        cuentas.add(cuentaBanco2);
        cuentas.add(cuentaBanco3);
        cuentas.add(cuentaBanco4);
        cuentas.add(cuentaBanco5);
        cuentas.add(cuentaBanco6);
    }

    public void iniciar()
    {
        inicializarVariables();

        Scanner sc = new Scanner(System.in);
        Usuarios userLogueado = null;
        boolean ejecutarPrograma = true;

        while (ejecutarPrograma) {

            // --- NIVEL 0: BIENVENIDA Y LOGIN ---
            if (userLogueado == null) {
                System.out.println("\n[NOMBRE DEL BANCO + SUCURSAL]");
                System.out.println("1. Iniciar Sesion");
                System.out.println("2. Quiero ser cliente");
                System.out.println("0. Salir de la aplicacion");
                int opcionIni = sc.nextInt(); sc.nextLine();

                switch (opcionIni) {
                    case 1:
                        System.out.println("--Seccion de iniciar Sesion--");
                        System.out.println("Ingrese su username: ");
                        String username=sc.nextLine();
                        System.out.println("Ingrese su contrasenia: ");
                        String password=sc.nextLine();
                        //this.getSucursal().getClientesSucursal()
                        for (Usuarios user: sucursal1.getClientesSucursal()){
                            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                                System.out.println("Usuario encontrado: "+user.toString());
                                userLogueado=user;
                                break;
                            }
                        }
                        if (userLogueado==null){
                            System.out.println("Credenciales incorrectas. Intente de nuevo");
                        }
                        break;
                    case 2:
                        System.out.println("--Quiero ser Cliente--");

                        System.out.println("Ingrese su nombre: ");
                        String nombre=sc.nextLine();
                        System.out.println("Ingrese su apellido: ");
                        String apellido=sc.nextLine();
                        System.out.println("Ingrese su dni:");
                        int dni=sc.nextInt();
                        System.out.println("Ingrese su direccion:");
                        String direccion=sc.nextLine();
                        System.out.println("Ingrese su username: ");
                        String newUsername=sc.nextLine();
                        System.out.println("Ingrese su password: ");
                        String newPassword=sc.nextLine();

                        CuentaBanco nuevaCuenta=new CuentaBanco();

                        System.out.println("Que tipo de rol tiene?:(1)Cliente 2)Admin 3)G-Balance 4)G-CB 5)G-Cli ) ");
                        int rolSele=sc.nextInt();
                        switch (rolSele){
                            case 1:
                                //int id, String nombre, String apellido, int dni, String direccion, Rol rol, String username, String password, Banco banco, Sucursal sucursal, CuentaBanco cuentaBanco
                                userLogueado=new Cliente(usuarios.toArray().length+1,nombre,apellido,dni,direccion,Rol.CLIENTE,newUsername,newPassword,bancoGalicia,sucursal1 ,nuevaCuenta);
                                break;
                            case 2:
                                userLogueado=new Admin(usuarios.toArray().length+1,nombre,apellido,dni,direccion,Rol.ADMIN,newUsername,newPassword,bancoGalicia,sucursal1,nuevaCuenta);
                                break;
                            case 3:
                                userLogueado=new GestorBalances(usuarios.toArray().length+1,nombre,apellido,dni,direccion,Rol.G_BALANCES,newUsername,newPassword,bancoGalicia,sucursal1,nuevaCuenta);
                                break;
                            case 4:
                                userLogueado=new GestorCuentasBancarias(usuarios.toArray().length+1,nombre,apellido,dni,direccion,Rol.G_CUENTAS,newUsername,newPassword,bancoGalicia,sucursal1,nuevaCuenta);
                                break;
                            case 5:
                                userLogueado=new GestorClientes(usuarios.toArray().length+1,nombre,apellido,dni,direccion,Rol.G_CLIENTES,newUsername,newPassword,bancoGalicia,sucursal1,nuevaCuenta);
                                break;
                        }
                        break;
                    case 0:
                        ejecutarPrograma = false;
                        break;
                }
            }
            // --- NIVEL 1: USUARIO LOGUEADO ---
            else {
                boolean enSesion = true;
                while (enSesion) {
                    System.out.println("\n" + userLogueado.getBanco().getNombreBanco() + " - " + userLogueado.getSucursal().getNombreSucursal());

                    if (userLogueado instanceof Admin) {
                        System.out.println("-- MENU ADMINISTRADOR --");
                        System.out.println("1. Ver mis datos");
                        System.out.println("2. Balance Interno(Sucursal)");
                        System.out.println("3. Crear Gestor Balances");
                        System.out.println("4. Crear Gestor Cliente");
                        System.out.println("5. Crear Gestor Cuenta banco");
                        System.out.println("6. Crear CLiente");
                        System.out.println("7. Ver usuarios");
                        System.out.println("8. Buscar user por id");
                        System.out.println("9. Depositar Sueldos");
                        System.out.println("10. Dar alta cuenta bancaria");
                        System.out.println("11. Dar baja cuenta Bancaria");
                        System.out.println("12. Crear Cuenta bancaria");
                        System.out.println("13. Asignar Cuenta");
                        System.out.println("14. Ver Cuentas");
                        System.out.println("15. Cerrar Sesion");
                        System.out.println("0. Salir Total");
                        System.out.print("Opcion: ");

                        int opAdmin = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer

                        switch (opAdmin) {
                            case 1:
                                userLogueado.verMisDatos();
                                break;
                            case 2:
                                ((Admin) userLogueado).hacerBalancesSucursal();//Hacer meodo balance interno
                                break;
                            case 3:
                                ((Admin) userLogueado).crearGBalances();
                                break;
                            case 4:
                                ((Admin) userLogueado).crearCliente();
                                break;
                            case 5:
                                ((Admin) userLogueado).crearGCuentaBancaria();
                                break;
                            case 6:
                                ((Admin) userLogueado).crearCliente();
                                break;
                            case 7:
                                ((Admin) userLogueado).verClientes();
                                break;
                            case 8:
                                System.out.println("Ingrese el id del user a buscar: ");
                                int userBusca=sc.nextInt();
                                Usuarios userEncontrado=((Admin) userLogueado).buscarClientePorId(userBusca); //Ver metodo
                                System.out.println(userEncontrado.toString());
                                break;
                            case 9:
                                System.out.println("Ingrese el id del user a buscar: ");
                                int userDepo=sc.nextInt();
                                System.out.println("Ingrese el sueldo a depositar: ");
                                float sueldoDepo=sc.nextFloat();
                                ((Admin) userLogueado).depositarSueldo(userDepo,sueldoDepo);
                                break;
                            case 10:
                                System.out.println("Ingrese el id de la cuenta a dar alta: ");
                                int alta=sc.nextInt();
                                ((Admin) userLogueado).realizarApertura(alta);
                                //Hacer metodo
                                break;
                            case 11:
                                System.out.println("Ingrese el id de la cuenta a dar baja: ");
                                int baja=sc.nextInt();
                                ((Admin) userLogueado).darDeBajaCuenta(baja);
                                //Hacer metodo
                                break;
                            case 12:
                                CuentaBanco nuevaCuenta=((Admin) userLogueado).crearCuenta();
                                cuentas.add(nuevaCuenta);
                                break;
                            case 13:
                                System.out.println("Ingrese el id de la cuenta a asignar: ");
                                int asigCuenta=sc.nextInt();
                                System.out.println("Ingrese el id del user a asignar cuenta: ");
                                int asigUser=sc.nextInt();
                                ((Admin) userLogueado).asignarCuenta(asigUser,asigCuenta,cuentas);
                                break;
                            case 14:
                                ((Admin) userLogueado).verCuentas(cuentas);

                                break;
                            case 15:
                                System.out.println("Cerrando sesion...");
                                enSesion = false; // Corta este bucle y vuelve al login
                                userLogueado = null; // Limpia el usuario
                                break;
                            case 0:
                                System.exit(0); // Cierra todo el programa
                                break;
                        }
                    }
                    else if (userLogueado instanceof Cliente) {
                        System.out.println("-- MENU Cliente --");
                        System.out.println("1. Ver mis datos");
                        System.out.println("2. Transferir (Local)");
                        System.out.println("3. Transferir (Otro banco)");
                        System.out.println("4. Depositar");
                        System.out.println("5. Extraer");
                        System.out.println("6. Cerrar Sesion");
                        System.out.println("0. Salir");
                        System.out.print("Opcion: ");

                        int opAdmin = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer

                        switch (opAdmin) {
                            case 1:
                                userLogueado.verMisDatos();
                                break;
                            case 2:
                                System.out.println("Ingrese el cbu del user a transferir");
                                String cbuUser=sc.nextLine();
                                System.out.println("Ingrese el monto a transferir: ");
                                float monto=sc.nextFloat();
                                userLogueado.transferir(monto,cbuUser);
                                break;
                            case 3:

                                System.out.println("INGRESE EL IDENTIFICADOR DE LA SUCURSAL EXTERNA");
                                int opcionSucu= sc.nextInt();
//                                sc.nextDouble();
                                org.example.proyectoAle.entidades.Sucursal SucursalAle= bancoAle.buscarSucursalPorId(opcionSucu);
                                System.out.println("INGRESE EL IDENTIFICADOR DE LA CUENTA: ");
                                opcionSucu=sc.nextInt();
                                Cuenta cuentaBancoAle=SucursalAle.buscarCuenta(opcionSucu);

                                CuentaAdapterA cuentaAdapterA=new CuentaAdapterA(cuentaBancoAle);
                                CuentaAdapterB cuentaAdapterB=new CuentaAdapterB(userLogueado.getCuentaBanco());

                                System.out.println("INGRESE EL MONTO A TRANSFERIR");
                                float montoCuenta = sc.nextFloat();

                                ServicioDeTransferencia.transferir(cuentaAdapterB,cuentaAdapterA,montoCuenta);

                                break;
                            case 4:
                                System.out.println("Ingrese el monto a depositar: ");
                                float montoDepo=sc.nextFloat();
                                userLogueado.depositar(montoDepo);
                                break;
                            case 5:
                                System.out.println("Ingrese el monto a extraer: ");
                                float montoExtra=sc.nextFloat();
                                userLogueado.extraer(montoExtra);
                                break;
                            case 6:
                                System.out.println("Cerrando sesion...");
                                enSesion = false; // Corta este bucle y vuelve al login
                                userLogueado = null; // Limpia el usuario
                                break;
                            case 0:
                                System.exit(0); // Cierra todo el programa
                                break;
                        }
                    }
                    else if (userLogueado instanceof GestorBalances) {
                        System.out.println("-- MENU Gestor Balances --");
                        System.out.println("1. Ver mis datos");
                        System.out.println("2. Balance Interno");
                        System.out.println("3. Balance Externo");
                        System.out.println("4. Cerrar Sesion");
                        System.out.println("0. Salir Total");
                        System.out.print("Opcion: ");

                        int opAdmin = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer

                        switch (opAdmin) {
                            case 1:
                                userLogueado.verMisDatos();
                                break;
                            case 2:
                                ((GestorBalances) userLogueado).hacerBalanceCuentas();
                                break;
                            case 3:
                                ((GestorBalances) userLogueado).hacerBalancesSucursal();
                                break;
                            case 4:
                                System.out.println("Cerrando sesion...");
                                enSesion = false; // Corta este bucle y vuelve al login
                                userLogueado = null; // Limpia el usuario
                                break;
                            case 0:
                                System.exit(0); // Cierra todo el programa
                                break;
                        }
                    }
                    else if (userLogueado instanceof GestorClientes) {
                        System.out.println("-- MENU Gestor CLientes --");
                        System.out.println("1. Balance Interno");
                        System.out.println("2. Balance Externo");
                        System.out.println("3. Cerrar Sesion");
                        System.out.println("0. Salir Total");
                        System.out.print("Opcion: ");

                        int opAdmin = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer

                        switch (opAdmin) {
                            case 1:
                                // llamar a tu metodo de balance
                                break;
                            case 3:
                                System.out.println("Cerrando sesion...");
                                enSesion = false; // Corta este bucle y vuelve al login
                                userLogueado = null; // Limpia el usuario
                                break;
                            case 0:
                                System.exit(0); // Cierra todo el programa
                                break;
                        }
                    }
                    else if (userLogueado instanceof GestorCuentasBancarias) {
                        System.out.println("-- MENU Gestor Cuentas Bancarias --");
                        System.out.println("1. Ver mis datos");
                        System.out.println("2. Dar alta Cuenta Bancaria");
                        System.out.println("3. Dar Baja Cuenta Bancaria");
                        System.out.println("4. Asignar Cuenta a user");
                        System.out.println("5. Crear Cuenta");
                        System.out.println("6. Cerrar Sesion");
                        System.out.println("0. Salir Total");
                        System.out.print("Opcion: ");

                        int opAdmin = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer

                        switch (opAdmin) {
                            case 1:
                                userLogueado.verMisDatos();
                                break;
                            case 2:
                                System.out.println("Ingrese el id de la cuenta a dar de alta:");
                                int alta=sc.nextInt();
                                ((GestorCuentasBancarias) userLogueado).realizarApertura(alta);
                                break;
                            case 3:
                                System.out.println("Ingrese el id de la cuenta a da de baja:");
                                int baja=sc.nextInt();
                                ((GestorCuentasBancarias) userLogueado).darDeBajaCuenta(baja);
                                break;
                            case 4:
                                System.out.println("Ingrese el id del user.");
                                int userAsig=sc.nextInt();
                                System.out.println("Ingrese el id de la cuenta.");
                                int cuentaAsig=sc.nextInt();
                                ((GestorCuentasBancarias) userLogueado).asignarCuenta(userAsig,cuentaAsig,cuentas); //Ver metodo y completar
                                break;
                            case 5:
                                CuentaBanco nuevaCuenta=((GestorCuentasBancarias) userLogueado).crearCuenta(); //Ver metodo y completar
                                cuentas.add(nuevaCuenta);
                                break;
                            case 6:
                                System.out.println("Cerrando sesion...");
                                enSesion = false; // Corta este bucle y vuelve al login
                                userLogueado = null; // Limpia el usuario
                                break;
                            case 0:
                                System.exit(0); // Cierra todo el programa
                                break;
                        }
                    }

                    else if (userLogueado instanceof AdminBancario){
                        System.out.println("-- MENU ADMINISTRADOR BANCARIO --");
                        System.out.println("1. Ver mis datos");
                        System.out.println("2. Balance Interno(Sucursal)");
                        System.out.println("3. Balance Interno(Banco interno)");
                        System.out.println("4. Balance Externo(Banco externo)");
                        System.out.println("5. Transferir");
                        System.out.println("6. Depositar");
                        System.out.println("7. Extraer");
                        System.out.println("8. Crear Sucursales");
                        System.out.println("9. Crear Admin");
                        System.out.println("10. Crear Gestor Balances");
                        System.out.println("11. Crear Gestor Cliente");
                        System.out.println("12. Crear Gestor Cuenta banco");
                        System.out.println("13. Ver usuarios");
                        System.out.println("14. Buscar user por id");
                        System.out.println("15. Crear cuenta bancaria");
                        System.out.println("16. Dar alta cuenta bancaria");
                        System.out.println("17. Dar baja cuenta bancaria");
                        System.out.println("18. Depositar Sueldo");
                        System.out.println("19. Cerrar Sesion");
                        System.out.println("0. Salir Total");
                        System.out.print("Opcion: ");

                        int opAdmin = sc.nextInt();
//                        sc.nextLine();

                        switch (opAdmin) {
                            case 1:
                                userLogueado.verMisDatos();
                                break;
                            case 2:
                                float balanceSucursal=((AdminBancario) userLogueado).hacerBalancesSucursal();
                                System.out.println("El balance de la sucursal es de: "+balanceSucursal);

                                break;
                            case 3:
                                float balanceBanco=((AdminBancario) userLogueado).hacerBalanceCuentas();
                                System.out.println("El balance de tu banco es: "+balanceBanco);
                                break;
                            case 4:
                                BalanceAdapterA cuentaBalance=new BalanceAdapterA(bancoAle);
                                System.out.println("El balance del banco externo es: "+cuentaBalance.getSaldo());
                                break;
                            case 5:
                                System.out.println("Ingrese el cbu a transferir");
                                String cbuTrasferir=sc.nextLine();
                                System.out.println("Ingrese el monto a transferir");
                                float montoTrasferir=sc.nextFloat();
                                userLogueado.transferir(montoTrasferir,cbuTrasferir);
                                break;
                            case 6:
                                System.out.println("Ingrese el monto a depositar:");
                                float depo=sc.nextFloat();
                                userLogueado.depositar(depo);
                                break;
                            case 7:
                                System.out.println("Ingrese el monto a extraer:");
                                float extraer=sc.nextFloat();
                                userLogueado.extraer(extraer);
                                break;
                            case 8:
                                Sucursal sucu=((AdminBancario) userLogueado).crearSucursal();
                                sucursalesGalicia.add(sucu);
                                break;
                            case 9:
                                ((AdminBancario) userLogueado).crearCliente();
                                //crear metodo
                                break;
                            case 10:
                                ((AdminBancario) userLogueado).crearGBalances();
                                break;
                            case 11:
                                ((AdminBancario) userLogueado).crearGClientes();
                                break;
                            case 12:
                                ((AdminBancario) userLogueado).crearGCuentaBancaria();
                                break;
                            case 13:
                                ((AdminBancario) userLogueado).verUsuarios();
                                break;
                            case 14:
                                System.out.println("Ingrese el id del user a buscar: ");
                                int idBusca=sc.nextInt();
                                Usuarios userFind=((AdminBancario) userLogueado).buscarClientePorId(idBusca);
                                System.out.println(userFind.toString());
                                break;
                            case 15:
                                CuentaBanco nuevaCuenta=((AdminBancario) userLogueado).crearCuenta();
                                cuentas.add(nuevaCuenta);
                                break;
                            case 16:
                                System.out.println("Ingrese el id de la cuenta a dar de alta: ");
                                int alta=sc.nextInt();
                                ((AdminBancario) userLogueado).realizarApertura(alta);
                                break;
                            case 17:
                                System.out.println("Ingrese el id del user a buscar: ");
                                int baja=sc.nextInt();
                                ((AdminBancario) userLogueado).darDeBajaCuenta(baja);
                                break;
                            case 18:
                                System.out.println("Ingrese el id del user a depositar sueldo: ");
                                int userSueldo=sc.nextInt();
                                System.out.println("Ingresa el monto a depositar: ");
                                float montoDepo=sc.nextFloat();
                                ((AdminBancario) userLogueado).depositarSueldo(userSueldo,montoDepo);
                                break;

                            case 19:
                                System.out.println("Cerrando sesion...");
                                enSesion = false; // Corta este bucle y vuelve al login
                                userLogueado = null; // Limpia el usuario
                                break;
                            case 0:
                                System.exit(0); // Cierra todo el programa
                                break;
                        }
                    }
                }
            }
        }
    }
}

