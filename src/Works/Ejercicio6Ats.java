package Works;

import java.util.Scanner;

public class Ejercicio6Ats {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int horasTotales, semanas, dias, horas;


        System.out.println("Digite el total de horas");

        horasTotales = entrada.nextInt();

        semanas=horasTotales/168;
        dias = horasTotales%168/24;
        horas = horasTotales%24;

        System.out.println(" el equivalente es: ");
        System.out.println(" el numero de semana es : " + semanas);
        System.out.println (" el numero de dias es: " + dias);
        System.out.println ("el numero de hora es: " + horas);


    }
}


