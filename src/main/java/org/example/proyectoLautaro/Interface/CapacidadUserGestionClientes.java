package org.example.proyectoLautaro.Interface;

import org.example.proyectoLautaro.Entity.Usuarios.Cliente;

public interface CapacidadUserGestionClientes  {
    //float monto, String cbu
    void verClientes();
    void crearCliente();
    void buscarClientePorId(int id);


}
