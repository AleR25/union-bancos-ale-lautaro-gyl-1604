package org.example.proyectoLautaro.Interface;

import org.example.proyectoLautaro.Entity.Usuarios.Cliente;

import java.util.ArrayList;

public interface CapacidadUserCliente extends CapacidadUsers{

    void hacerTransferecia(String cbu, ArrayList<Cliente>clientes,float monto);

    @Override
    void verMisDatos();
    void extraer(float monto);
    void depositar(float monto);
    void transferir(float monto,String cbu);
}