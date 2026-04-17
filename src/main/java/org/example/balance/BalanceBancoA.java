package org.example.balance;

import org.example.proyectoAle.entidades.Banco;
import org.example.proyectoAle.interf.ComponenteFinanciero;

public class BalanceBancoA implements ComponenteFinanciero {
    private Banco bancoA;

    public BalanceBancoA(Banco bancoA) {
        this.bancoA = bancoA;
    }

    public Banco getBancoA() {
        return bancoA;
    }

    public void setBancoA(Banco bancoA) {
        this.bancoA = bancoA;
    }


    @Override
    public double getSaldo() {
        return 0;
    }
}
