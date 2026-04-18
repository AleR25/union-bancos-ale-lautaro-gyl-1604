package org.example.structural.adapter.balance;

import org.example.proyectoLautaro.Entity.Banco;

public class BalanceAdapterB implements IComponenteFinanciero {
    private Banco banco;

    @Override
    public double getSaldo()
    {
        return banco.hacerBalanceCuentas();
    }
}
