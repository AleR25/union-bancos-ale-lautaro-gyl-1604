package org.example.entidades;

public class Cuenta {
    private int contador = 1;

    private int idCuenta;
    private String titular;
    private Usuario usuario;
    private double saldo;
    private boolean activa;
    private TipoCuenta tipoDeCuenta;

    /*
    * para que un usuario pueda realizar cualquier operacion la
    * cuenta tiene que estar activa
    * */

    public Cuenta(String titular, Usuario usuario, TipoCuenta tipoDeCuenta) {
        this.idCuenta = contador++;
        this.titular = titular;
        this.usuario = usuario; //Puede ser cliente o administrador
        this.saldo = 0;
        this.activa = true;
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public void depositar(double monto)
    {
        if (monto > 0 && activa == true)
        {
            sumarSaldo(monto);
            System.out.println("El saldo actual de " + this.titular + " es de: " + this.saldo);
        }
        else if(monto < 0 && activa == false)
        {
            System.out.println("El monto a depositar en la cuenta de " + this.titular + " es insuficiente");
        }
        else
        {
            System.out.println("Su cuenta esta inavilitada para hacer esta operación");
        }
    }

    public void retirar(double monto)
    {
        if (!activa)
        {
            System.out.println("La cuenta se encuentra inactiva");
        }
        else if (monto <= 0)
        {
            System.out.println("El monto a extraer tiene que ser mayor a cero");
        }
        else if (!puedeRetirar(monto))
        {
            System.out.println("El monto a extraer de la cuenta de "
                    + this.titular
                    + " es mayor del que posee en la cuenta");
        }
        else
        {
            restarSaldo(monto);
            System.out.println("El saldo actual de "
                    + this.titular
                    + " es de: " + this.saldo);

            System.out.println("El monto entregado a "
                    + this.titular
                    + " es de: " + monto);
        }
    }

    public boolean puedeRetirar(double monto)
    {
        return this.saldo >= monto;
    }

    private void restarSaldo(double monto)
    {
        this.saldo -= monto;
    }

    private void sumarSaldo(double monto)
    {
        this.saldo += monto;
    }
}
