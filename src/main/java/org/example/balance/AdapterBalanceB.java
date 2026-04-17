package org.example.balance;

import org.example.proyectoLautaro.Entity.Banco;

//Mi banco
public class AdapterBalanceB implements ComponenteBalances {
    private Banco bancoB;

    public Banco getBancoB() {
        return bancoB;
    }

    public void setBancoB(Banco bancoA) {
        this.bancoB = bancoB;
    }

    public float balanceSucursal(int id){
        float resultado=bancoB.hacerBalancesSucursal(id);
        return  resultado;
    }

    public float balanceBanco(){
        float resultado= bancoB.hacerBalanceCuentas();
        return resultado;
    }
}
