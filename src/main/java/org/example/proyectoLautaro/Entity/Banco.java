package org.example.proyectoLautaro.Entity;

import org.example.proyectoLautaro.Entity.Usuarios.Usuarios;

import java.util.ArrayList;

public class Banco {
    private int id;
    private String nombreBanco;
    private String direccion;
    private ArrayList<Sucursal> sucursales;


    public Banco(int id, String nombreBanco, String direccion, ArrayList<Sucursal> sucursales) {
        this.id = id;
        this.nombreBanco = nombreBanco;
        this.direccion = direccion;
        this.sucursales = sucursales;
    }

    public Banco(Banco b){
        this.id=b.getId();
        this.direccion=b.getDireccion();
        this.nombreBanco=b.getNombreBanco();
        if (b.getSucursales()!=null){
            this.sucursales=new ArrayList<>(b.getSucursales());
        }


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getDireccion() {
        return direccion;
    }


    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(ArrayList<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //Sucursales
    public float hacerBalancesSucursal(int idSucursal) {
        float total = 0;

        if (this.sucursales != null) {
            // Buscamos la sucursal específica en la lista del banco
            for (Sucursal sucu : this.sucursales) {

                if (sucu.getId() == idSucursal) { // Encontramos la sucursal

                    if (sucu.getClientesSucursal() != null) {
                        for (Usuarios cli : sucu.getClientesSucursal()) {
                            total += cli.getCuentaBanco().getSaldo();
                        }
                    }
                    System.out.println("El total de la sucursal '" + sucu.getNombreSucursal() + "' (ID: " + sucu.getId() + ") es de: $" + total);
                    return total; // Retornamos el valor y salimos del método
                }
            }
        }

        System.out.println("Error: No se encontró la sucursal con ID " + idSucursal + " en este banco.");
        return total;
    }

    //banco

    public float hacerBalanceCuentas() {
        float balanceTotalBanco = 0;
        System.out.println("--- Balance Total del Banco: " + this.getNombreBanco() + " ---");

        // 1. Verificamos que la lista de sucursales no sea nula
        if (this.sucursales != null) {

            // 2. Recorremos todas las sucursales de ESTE banco
            for (Sucursal sucu : this.sucursales) {
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

        System.out.println("Balance Total General: $" + balanceTotalBanco);
        return balanceTotalBanco;
    }
}