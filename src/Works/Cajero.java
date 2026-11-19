package Works;

import java.util.Scanner;

public class Cajero {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        int saldo = 1000;
        int ingresar;
        int retirar;
        int opcion;

        System.out.println("ingrese 1.ingresar dinero, 2.retirar dinero, 3. salir" );
        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el valor a ingresar");
                ingresar = entrada.nextInt();
                System.out.println("su saldo actual es : " + (ingresar + 1000));
            case 2:
                System.out.println("Ingrese el valor a retirar");
                retirar = entrada.nextInt();
                System.out.println("su saldo actual es : " + (1000- retirar));
            case 3:
                System.out.println("usted a salido del sistema");

        }
    }
}

