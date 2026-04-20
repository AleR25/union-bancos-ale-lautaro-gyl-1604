package org.example.proyectoLautaro.Interface;

import org.example.proyectoLautaro.Entity.CuentaBanco;

import java.util.ArrayList;

public interface CapacidadUserCuentasBancarias  {
    void darDeBajaCuenta(int idCuenta);
    CuentaBanco crearCuenta();
    void realizarApertura(int idCuenta);
    void asignarCuenta(int idUser, int idCuenta, ArrayList<CuentaBanco>cuentas);
    void verCuentas(ArrayList<CuentaBanco>cuentas);

}
