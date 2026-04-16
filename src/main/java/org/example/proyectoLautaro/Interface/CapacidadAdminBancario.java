package org.example.proyectoLautaro.Interface;

import org.example.proyectoLautaro.Entity.CuentaBanco;
import org.example.proyectoLautaro.Entity.Usuarios.Usuarios;

public interface CapacidadAdminBancario extends CapacidadUserCuentasBancarias,CapacidadUserBalances,CapacidadUsers{
    void verUsuarios();
    Usuarios crearUsuarios();
    @Override
    default float hacerBalanceCuentas() {
        return 0;
    }

    @Override
    default float hacerBalancesSucursales() {
        return 0;
    }

    @Override
    default void darDeBajaCuenta(int idCuenta) {

    }

    @Override
    default CuentaBanco crearCuenta() {
        return null;
    }

    @Override
    default void realizarApertura(int idCuenta) {

    }

}
