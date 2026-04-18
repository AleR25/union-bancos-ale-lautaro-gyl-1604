package org.example.structural.adapter.balance;

import org.example.proyectoAle.entidades.Banco;

//Mi banco
public class BalanceAdapterA implements IComponenteFinanciero {
    private Banco banco;

    @Override
    public double getSaldo()
    {
        return banco.getSaldo();
    }
}
