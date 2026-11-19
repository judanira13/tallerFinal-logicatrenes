package Works;

import java.util.Scanner;

public class If {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int horas;
        float salarioTotal;

        System.out.println("Ingrese el número de horas trabajadas: ");
        horas = entrada.nextInt(); // Se asigna el valor ingresado a la variable horas usando el objeto 'entrada'

        if (horas <= 40) {

            System.out.println("El salario total es: " + horas * 16);
        } else {
            System.out.println("El salario total es: " + (horas * 16 + (horas - 40 )* 20));

        }
    }
}