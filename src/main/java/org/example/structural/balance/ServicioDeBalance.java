package org.example.structural.adapter.balance;

public class ServicioDeBalance {
    public static float balanceDelA(IComponenteFinanciero bancoA) {
        return (float) bancoA.getSaldo();
    }

    //envia balance banco B al A
    public static double balanceDelB(IComponenteFinanciero bancoB) {
        return bancoB.getSaldo();
    }
}
