package org.example.structural.adapter.transferencias;

public class ServicioDeTransferencia {
    public static void transferir(ICuentaAdapter origen, ICuentaAdapter destino, double monto) {

        if (origen.retirar(monto)) {
            destino.depositar(monto);
            System.out.println("Transferencia interbancaria exitosa");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}
