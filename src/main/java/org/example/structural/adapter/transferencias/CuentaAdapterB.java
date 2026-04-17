package org.example.structural.adapter.transferencias;

import org.example.proyectoLautaro.Entity.CuentaBanco;

public class CuentaAdapterB implements ICuentaAdapter
{
    private CuentaBanco cuenta;

    public CuentaAdapterB(CuentaBanco cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String getIdentificador() {
        return cuenta.getCbu();
    }

    @Override
    public double getSaldo() {
        return cuenta.getSaldo();
    }

    @Override
    public void depositar(double monto) {
        cuenta.setSaldo((float)(cuenta.getSaldo() + monto));
    }

    @Override
    public boolean retirar(double monto) {
        if (cuenta.getSaldo() >= monto) {
            cuenta.setSaldo((float)(cuenta.getSaldo() - monto));
            return true;
        }
        return false;
    }
}
