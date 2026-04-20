package org.example.proyectoLautaro.Entity.Usuarios;

import org.example.proyectoLautaro.Entity.Banco;
import org.example.proyectoLautaro.Entity.CuentaBanco;
import org.example.proyectoLautaro.Entity.Enum.Rol;
import org.example.proyectoLautaro.Entity.Enum.TipoCuenta;
import org.example.proyectoLautaro.Entity.Sucursal;
import org.example.proyectoLautaro.Interface.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin  extends Usuarios implements CapacidadUserAdmin,CapacidadLogin, CapacidadUserCliente, CapacidadUserCuentasBancarias, CapacidadUserBalances {


    public Admin(int id, String nombre, String apellido, int dni, String direccion, Rol rol, String username, String password, Banco banco, Sucursal sucursal, CuentaBanco cuentaBanco) {
        super(id, nombre, apellido, dni, direccion, rol, username, password, banco, sucursal, cuentaBanco);
    }
    public Admin(Usuarios u) {
        super(u.getId(), u.getNombre(), u.getApellido(), u.getDni(), u.getDireccion(),
                u.getRol(), u.getUsername(), u.getPassword(), u.getBanco(),
                u.getSucursal(), u.getCuentaBanco());
    }


    @Override
    public void darDeBajaCuenta(int idCuenta) {
        for (Usuarios cli : this.getSucursal().getClientesSucursal()) {
            if (cli.getCuentaBanco().getId() == idCuenta) {
                if (cli.getCuentaBanco().getEstado()) { // Si está abierta (true)
                    cli.getCuentaBanco().setEstado(false);
                    System.out.println("Cuenta dada de baja con éxito.");
                } else {
                    System.out.println("La cuenta ya se encuentra dada de baja.");
                }
                return;
            }
        }
        System.out.println("No se encontró la cuenta.");
    }

    @Override
    public CuentaBanco crearCuenta() {
        Scanner escaner = new Scanner(System.in);
        System.out.println("\n--- Creación de Nueva Cuenta Bancaria ---");

        System.out.print("Ingrese el ID numérico para la cuenta: ");
        int id = escaner.nextInt();
        escaner.nextLine(); // Limpiar el buffer de entrada

        System.out.print("Ingrese el CBU: ");
        String cbu = escaner.nextLine();

        System.out.println("Seleccione el Tipo de Cuenta:");
        System.out.println("1) SUELDO");
        System.out.println("2) CORRIENTE");
        System.out.println("3) AHORRO");
        int opc = escaner.nextInt();

        TipoCuenta tipo = switch (opc) {
            case 2 -> TipoCuenta.CORRIENTE;
            case 3 -> TipoCuenta.AHORRO;
            default -> TipoCuenta.SUELDO;
        };
        CuentaBanco nuevaCuenta = new CuentaBanco(id, cbu, tipo, 0, this.getBanco(), false);


        System.out.println("Cuenta creada correctamente (Estado: Pendiente de Apertura).");
        return nuevaCuenta;
    }

    @Override
    public void realizarApertura(int idCuenta) {
        boolean encontrado = false;
        // Recorremos los clientes de la sucursal donde trabaja este gestor
        for (Usuarios cli : this.getSucursal().getClientesSucursal()) {
            if (cli.getCuentaBanco().getId() == idCuenta) {
                // Verificamos si ya está abierta
                if (!cli.getCuentaBanco().getEstado()) {
                    cli.getCuentaBanco().setEstado(true); // Cambiamos false a true
                    System.out.println("Éxito: La cuenta con ID " + idCuenta + " ahora está ACTIVA.");
                } else {
                    System.out.println("Aviso: La cuenta ya se encontraba abierta.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Error: No se encontró ninguna cuenta con el ID " + idCuenta + " en esta sucursal.");
        }
    }

    @Override
    public void asignarCuenta(int idUser, int idCuenta, ArrayList<CuentaBanco> cuentas) {
        Usuarios clienteEncontrado = null;
        CuentaBanco cuentaEncontrada=null;

        // 1. Buscamos al cliente en la sucursal por su ID
        for (Usuarios cli : this.getSucursal().getClientesSucursal()) {
            if (cli.getId() == idUser) {
                clienteEncontrado = cli;
                break;
            }
        }
        for (CuentaBanco cuen: cuentas) {
            if (cuen.getId()==idCuenta){
                cuentaEncontrada=cuen;
                break;
            }
        }

        if (clienteEncontrado != null && cuentaEncontrada!=null) {
            clienteEncontrado.setCuentaBanco(cuentaEncontrada);
            System.out.println("Cuenta asignada exitosamente.");
        } else {
            System.out.println("Error: No se encontró el cliente con ID " + idUser);
        }
    }

    @Override
    public void verCuentas(ArrayList<CuentaBanco> cuentas) {
        System.out.println("Mostrando Cuentas de banco: \n");
        if (cuentas.isEmpty()) {
            System.out.println("La lista de cuentas está vacía.");
        } else {
            for (CuentaBanco cuen: cuentas){
                System.out.println(cuen.toString()); // AHORA SÍ SE IMPRIME
            }
        }
    }

    //Creador y asignacion de cuentas
    @Override
    public void asignarCuenta(int idUser, int idCuenta) {

    }

    @Override
    public Usuarios buscarClientePorCbu(String cbu) {

        for (Usuarios cli: this.getSucursal().getClientesSucursal()){
            if (cli.getCuentaBanco()!=null && cli.getCuentaBanco().getCbu().equals(cbu)){
                System.out.println("User encontrado");
                return cli;
            }
        }
        return null;
    }

    @Override
    public void verClientes() {
        System.out.println("\n========= LISTADO GENERAL DE USUARIOS =========");

        for (Usuarios user : this.getSucursal().getClientesSucursal()) {
            // 1. Imprimimos los datos básicos que SIEMPRE existen
            System.out.print("ID: " + user.getId() + " | " + user.getNombre() + " " + user.getApellido());
            System.out.println(" | Rol: " + user.getRol());

            // 2. EL FILTRO DE SEGURIDAD: Solo mostramos cuenta si NO es nula
            if (user.getCuentaBanco() != null) {
                System.out.println("   -> Cuenta: " + user.getCuentaBanco().getCbu() +
                        " | Saldo: $" + user.getCuentaBanco().getSaldo());
            } else {
                // Si es null, mostramos un mensaje amigable en lugar de romper el programa
                System.out.println("   -> [PENDIENTE]: El usuario aún no tiene cuenta asignada.");
            }
            System.out.println("-----------------------------------------------");
        }
    }

    @Override
    public void depositarSueldo(int idUser, float monto) {
        Usuarios cliente = buscarClientePorId(idUser);

        if (cliente == null) {
            System.out.println("Error: No se encontró el cliente con ID " + idUser);
            return;
        }
        if (monto <= 0) {
            System.out.println("Error: El monto a depositar debe ser mayor a cero.");
            return;
        }

        // 3. Sumar al saldo (No sobrescribir)
        float saldoActual = cliente.getCuentaBanco().getSaldo();
        cliente.getCuentaBanco().setSaldo(saldoActual + monto);

        System.out.println("Depósito exitoso. Nuevo saldo de " + cliente.getNombre() + ": " + (saldoActual + monto));
    }

    @Override
    public void darBajaCuenta(int id) {
        for (Usuarios cli : this.getSucursal().getClientesSucursal()) {
            if (cli.getCuentaBanco().getId() == id) {
                if (cli.getCuentaBanco().getEstado()) { // Si está abierta (true)
                    cli.getCuentaBanco().setEstado(false);
                    System.out.println("Cuenta dada de baja con éxito.");
                } else {
                    System.out.println("La cuenta ya se encuentra dada de baja.");
                }
                return;
            }
        }
        System.out.println("No se encontró la cuenta.");
    }

    @Override
    public Usuarios buscarClientePorId(int id) {
        for (Usuarios cli: this.getSucursal().getClientesSucursal()){
            if (cli.getId()==id){
                System.out.println("Usuario Encontrado \n");
                return cli;
            }
        }
        return null;

    }

    @Override
    public void datosPorUser(int id) {
        for (Usuarios cli: this.getSucursal().getClientesSucursal()){
            if (cli.getId()==id){
                System.out.println("Usuario Encontrado \n");
                System.out.println(cli.toString());
            }
        }
    }

    @Override
    public void hacerTransferecia(String cbu, ArrayList<Cliente> clientes, float monto) {

    }

    @Override
    public void verMisDatos() {
        System.out.println(super.toString());
    }

    @Override
    public void crearGCuentaBancaria() {
        Scanner escaner = new Scanner(System.in);
        System.out.println("\n--- Alta de Gestor de Cuentas Bancarias ---");

        // Pedir datos (puedes crear un método privado 'pedirDatosComunes' para no repetir esto)
        System.out.print("ID: ");
        int id = escaner.nextInt();
        System.out.print("Nombre: ");
        String nom = escaner.nextLine();
        escaner.nextLine();
        System.out.print("Apellido: ");
        String ape = escaner.nextLine();
        System.out.print("Direccion: ");
        String dire = escaner.nextLine();
        System.out.print("DNI: ");
        int dni = escaner.nextInt();
        escaner.nextLine();
        System.out.print("Username: ");
        String user = escaner.nextLine();
        System.out.print("Password: ");
        String pass = escaner.nextLine();

        // Instanciar con el Rol correspondiente
        GestorCuentasBancarias nuevoG = new GestorCuentasBancarias(id, nom, ape, dni, dire, Rol.G_CUENTAS, user, pass, this.getBanco(), this.getSucursal(), null);

        // Guardar en la lista de la sucursal
        this.getSucursal().getClientesSucursal().add(nuevoG);
        System.out.println("Gestor de Cuentas creado y asignado a " + this.getSucursal().getNombreSucursal());
    }

    @Override
    public void crearGBalances() {
        Scanner escaner = new Scanner(System.in);
        System.out.println("\n--- Alta de Gestor de Balances ---");

        System.out.println("Ingrese un id: ");
        int idGbalance=escaner.nextInt();
        escaner.nextLine();
        System.out.println("Ingrese el nombre del nuevo cliente");
        String nombreGbalance=escaner.nextLine();

        System.out.println("Ingrese el apellido del nuevo cliente :");
        String apellidoGbalance=escaner.nextLine();

        System.out.println("Ingrese su dni:");
        int dniGbalance=escaner.nextInt();
        escaner.nextLine();
        System.out.println("Ingrese su direccion: ");
        String direccion=escaner.nextLine();

        System.out.println("Ingrese su username: ");
        String username=escaner.nextLine();

        System.out.println("Ingrese su password: ");
        String password=escaner.nextLine();

        Banco bancoCli=new Banco(getBanco());
        Sucursal sucuCli=new Sucursal(getSucursal());

        GestorBalances nuevoB = new GestorBalances(idGbalance, nombreGbalance, apellidoGbalance, dniGbalance, direccion, Rol.G_BALANCES, username, password, this.getBanco(), this.getSucursal(), null);

        this.getSucursal().getClientesSucursal().add(nuevoB);
        System.out.println("Gestor de Balances creado exitosamente.");
    }

    @Override
    public void crearGClientes() {
        Scanner escaner = new Scanner(System.in);
        System.out.println("\n--- Alta de Gestor de Clientes ---");

        System.out.println("Ingrese un id: ");
        int idCliente = escaner.nextInt();
        escaner.nextLine(); // LIMPIEZA OBLIGATORIA: después de un int para poder leer un String después.

        System.out.println("Ingrese el nombre del nuevo cliente:");
        String nombreCli = escaner.nextLine(); // Ahora sí va a frenar acá.

        System.out.println("Ingrese el apellido del nuevo cliente:");
        String apellidoCli = escaner.nextLine(); // No necesita limpieza porque el anterior fue un String.

        System.out.println("Ingrese su dni:");
        int dniCli = escaner.nextInt();
        escaner.nextLine(); // LIMPIEZA OBLIGATORIA: para que la dirección no se saltee.

        System.out.println("Ingrese su direccion: ");
        String direccion = escaner.nextLine(); // Ahora sí funciona.

        System.out.println("Ingrese su username: ");
        String username = escaner.nextLine();

        System.out.println("Ingrese su password: ");
        String password = escaner.nextLine();

        Banco bancoCli=new Banco(getBanco());
        Sucursal sucuCli=new Sucursal(getSucursal());

        GestorClientes nuevoGC = new GestorClientes(idCliente, nombreCli, apellidoCli, dniCli, direccion, Rol.G_CLIENTES, username, password, this.getBanco(), this.getSucursal(), null);

        this.getSucursal().getClientesSucursal().add(nuevoGC);
        System.out.println("Gestor de Clientes dado de alta.");
    }

    @Override
    public void crearCliente() {
        Scanner escaner=new Scanner(System.in);

        System.out.println("Ingrese un id: ");
        int idCliente=escaner.nextInt();
        escaner.nextLine();
        System.out.println("Ingrese el nombre del nuevo cliente");
        String nombreCli=escaner.nextLine();
        System.out.println("Ingrese el apellido del nuevo cliente :");
        String apellidoCli=escaner.nextLine();
        System.out.println("Ingrese su dni:");
        int dniCli=escaner.nextInt();
        escaner.nextLine();
        System.out.println("Ingrese su direccion: ");
        String direccion=escaner.nextLine();
        System.out.println("Ingrese su username: ");
        String username=escaner.nextLine();
        System.out.println("Ingrese su password: ");
        String password=escaner.nextLine();
        Banco bancoCli=new Banco(getBanco());
        Sucursal sucuCli=new Sucursal(getSucursal());

        CuentaBanco cuentaBanco=new CuentaBanco();//Lo asigna el GestorCuentaBancos

        Cliente nuevoCliente=new Cliente(idCliente,nombreCli,apellidoCli,dniCli,direccion,Rol.CLIENTE,nombreCli,apellidoCli,bancoCli,sucuCli,cuentaBanco);

        this.getSucursal().getClientesSucursal().add(nuevoCliente);
    }

    @Override
    public Sucursal crearSucursal() {

        Scanner escaner=new Scanner(System.in);
        System.out.println("Ingrese el nombre de la nueva sucursal?: \n");
        String nombre=escaner.nextLine();
        System.out.println("Ingrese el id de la nueva sucursal?: \n");
        int id=escaner.nextInt();
        System.out.println("Ingrese la direccion de la nueva sucursal?: \n");
        String direccion=escaner.nextLine();

        //ArrayList<Usuarios>usuariosAdmin=new ArrayList<>();
        ArrayList<Usuarios>clientes=new ArrayList<>();

        Sucursal sucursal=new Sucursal(nombre,id,direccion,this.getBanco(),clientes);
        return sucursal;
    }

    @Override
    public void asignarResponsables() {

    }


    @Override
    public Usuarios iniciarSesion(ArrayList<Usuarios>listaUsers,String username,String password) {
        for (Usuarios u: listaUsers){
            if (u.getPassword().equals(password) && u.getUsername().equals(username)){
                System.out.println("Se ingreso Exitosamente");
                return u;
            }
        }
        System.out.println("Usuario o password incorrectos \n");
        return  null;
    }

    @Override
    public void cerrarSesion() {

    }
    @Override
    public void extraer(float monto) {
        super.extraer(monto);
    }

    @Override
    public void depositar(float monto) {
        super.depositar(monto);
    }



    @Override
    public void transferir(float monto, String cbu) {
        super.transferir(monto, cbu);
    }

    @Override
    public float hacerBalanceCuentas() {
        float total = 0;
        // Recorre los clientes de la sucursal donde trabaja el gestor
        for (Usuarios cli : this.getSucursal().getClientesSucursal()) {
            total += cli.getCuentaBanco().getSaldo();
        }
        return total;
    }

    @Override
    public float hacerBalancesSucursal() {
        float balanceTotalBanco = 0;

        // 1. Obtenemos el banco al que pertenece este gestor
        Banco miBanco = this.getBanco();

        if (miBanco != null && miBanco.getSucursales() != null) {
            // 2. Recorremos todas las sucursales del banco
            for (Sucursal sucu : miBanco.getSucursales()) {
                float balanceSucursal = 0;

                // 3. De cada sucursal, recorremos sus clientes
                if (sucu.getClientesSucursal() != null) {
                    for (Usuarios cli : sucu.getClientesSucursal()) {
                        // Sumamos el saldo de la cuenta del cliente
                        balanceSucursal += cli.getCuentaBanco().getSaldo();
                    }
                }

                System.out.println("Sucursal: " + sucu.getNombreSucursal() + " - Balance: $" + balanceSucursal);
                balanceTotalBanco += balanceSucursal;
            }
        }

        return balanceTotalBanco;
    }
}