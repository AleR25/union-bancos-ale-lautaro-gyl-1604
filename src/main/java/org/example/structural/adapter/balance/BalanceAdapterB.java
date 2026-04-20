package org.example.structural.adapter.balance;

import org.example.proyectoLautaro.Entity.Banco;

public class BalanceAdapterB implements IComponenteFinanciero {
    private Banco banco;

    public BalanceAdapterB(Banco banco) {
        this.banco = banco;
    }

    @Override
    public double getSaldo()
    {
        return this.banco.hacerBalanceCuentas();
    }
}
