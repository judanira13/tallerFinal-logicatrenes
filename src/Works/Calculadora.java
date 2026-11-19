package Works;

import java.util.Scanner;

public class Calculadora {

    static public void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opc;
        float num1, num2 ;

        System.out.println("ingrese el primer numero");
        num1 = entrada.nextFloat();

        System.out.println("ingrese el segundo numero");
        num2 = entrada.nextFloat();



        System.out.println("Escoja que quiere relizar  1.sumar , 2.restar , 3 dividir , 4 multiplicar");
        opc = entrada.nextInt();


         switch (opc){
             case 1:float suma=num1+num2;
                 System.out.println("el total de su suma es: " +suma);
                 break;
             case 2: float resta=num1-num2;
                 System.out.println("el total de su resta es: " +resta);
                 break;
             case 3: float division=num1/num2;
                 System.out.println("el total de su multiplicacion es: " +division);
                 break;
             case 4:  float multiplicacion=num1*num2;
                 System.out.println("el total de su division es: " +multiplicacion);
                 break;
             default:
                 System.out.println("elija una opcion valida");

         }
    }



}

