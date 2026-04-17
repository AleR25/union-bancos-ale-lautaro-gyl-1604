package org.example.structural.adapter.transferencias;

public interface ICuentaAdapter
{
    /*
    * PROPOSITO: CREAR UNA PLANTILLA PARA LAS CUENTAS
    * DE BANCO A COMO BANCO B, PARA REALIZAR LAS ACCIONES
    * NECESARIAS PARA UNA COMUNICACIÓN SIN PROBLEMA.
    * */
    String getIdentificador(); // CBU o ID
    double getSaldo();
    void depositar(double monto);
    boolean retirar(double monto);
}
