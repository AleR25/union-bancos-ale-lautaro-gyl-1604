package org.example.structural.adapter.transferencias;

import org.example.proyectoAle.entidades.Cuenta;

public class CuentaAdapterA implements ICuentaAdapter
{
    private Cuenta cuenta;

    public CuentaAdapterA(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String getIdentificador() {
        return String.valueOf(cuenta.getIdCuenta());
    }

    @Override
    public double getSaldo() {
        return cuenta.getSaldo();
    }

    @Override
    public void depositar(double monto) {
        cuenta.depositar(monto);
    }

    @Override
    public boolean retirar(double monto) {
        if (cuenta.puedeRetirar(monto)) {
            cuenta.retirar(monto);
            return true;
        }
        return false;
    }
}
