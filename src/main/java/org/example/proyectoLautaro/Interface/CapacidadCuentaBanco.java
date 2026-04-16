package org.example.proyectoLautaro.Interface;

import org.example.proyectoLautaro.Entity.Usuarios.Cliente;

public interface CapacidadCuentaBanco {
    void mostrarSaldo();
    void realizarTransferencia(float monto, Cliente cli);
    void verDatos();
}
