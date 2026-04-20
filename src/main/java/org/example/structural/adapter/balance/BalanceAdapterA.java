package org.example.structural.adapter.balance;

import org.example.proyectoAle.entidades.Banco;

//Mi banco
public class BalanceAdapterA implements IComponenteFinanciero {
    private Banco banco;

    public BalanceAdapterA(Banco banco) {
        this.banco = banco;
    }

    @Override
    public double getSaldo()
    {
        return this.banco.getSaldo();
    }
}
