package org.example.proyectoLautaro.Interface;

import org.example.proyectoLautaro.Entity.CuentaBanco;

public interface CapacidadUserCuentasBancarias  {
    void darDeBajaCuenta(int idCuenta);
    CuentaBanco crearCuenta();
    void realizarApertura(int idCuenta);

}
