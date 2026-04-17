package org.example.structural.adapter.transferencias;

public class ServicioDeTransferencia {
    /*PROPOSITO: ESTA CLASE VA A SERVIR PARA REALIZAR LA TRANSFERENCIA
    EN EL METODO TRANSFERIR AL TENER DE TIPO "ICuentaAdapter" puedo usar tanto
    "CuentaAdapterA" como "CuentaAdapterB" COMO ARGUMENTO TANTO DE ORIGEN COMO
    DE DESTINO, ESTO VA A PERMITIR QUE PUEDA TANSFERIR DE UN BANCO A OTRO Y VICEVERSA
    * */
    public static void transferir(ICuentaAdapter origen, ICuentaAdapter destino, double monto) {

        if (origen.retirar(monto)) {
            destino.depositar(monto);
            System.out.println("Transferencia interbancaria exitosa");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}
