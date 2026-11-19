package Works;

import java.util.Scanner;

public class RecargasCel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Arreglo para guardar el saldo de los 4 operadores (Claro, Movistar, Tigo, WOM)
        int[] saldos = new int[4];
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE RECARGAS ===");
            System.out.println("1. Ingrese el valor de su recarga");
            System.out.println("2. Consulte el valor de su recarga");
            System.out.println("3. Ver el total de su saldo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarRecarga(saldos, scanner);
                    break;
                case 2:
                    consultarSaldo(saldos, scanner);
                    break;
                case 3:
                    verTotalGeneral(saldos);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema... ¡Gracias!");
                    break;
                default:
                    System.out.println("Ingrese un valor válido (del 1 al 4).");
            }

        } while (opcion != 4);

        scanner.close();
    }

    // =========================================================================
    // CAJITA 1: Ingrese el valor de su recarga
    // =========================================================================
    public static void registrarRecarga(int[] saldos, Scanner scanner) {
        // 1. Pedir y validar operador (1 a 4)
        System.out.print("\nEscriba el número de su operador (1 a 4): ");
        int operador = scanner.nextInt();

        while (operador < 1 || operador > 4) {
            System.out.print("Error. Ingrese un número válido del 1 al 4: ");
            operador = scanner.nextInt();
        }

        // 2. Pedir y validar el valor de la recarga (mínimo $1000)
        System.out.print("Escriba el valor de su recarga (mayor o igual a $1000): ");
        int valorRecarga = scanner.nextInt();

        while (valorRecarga < 1000) {
            System.out.print("Error. La recarga mínima es de $1000. Intente de nuevo: ");
            valorRecarga = scanner.nextInt();
        }

        // 3. Evaluar el bonus
        int bonus = 0;
        if (valorRecarga < 5000) {
            bonus = 0;
        } else if (valorRecarga <= 10000) {
            bonus = 1000;
        } else {
            bonus = 3000;
        }

        // 4. Proceso y guardado en el arreglo
        int recargaTotal = valorRecarga + bonus;
        saldos[operador - 1] = saldos[operador - 1] + recargaTotal;

        // 5. Confirmación al usuario
        System.out.println("✔ Recarga exitosa.");
        System.out.println("Monto ingresado: $" + valorRecarga + " | Bonus: $" + bonus);
        System.out.println("Total abonado al operador " + operador + ": $" + recargaTotal);
    }

    // =========================================================================
    // CAJITA 2: Consulte el valor de su recarga
    // =========================================================================
    public static void consultarSaldo(int[] saldos, Scanner scanner) {
        System.out.print("\nEscriba el número de operador a consultar (1 a 4): ");
        int operador = scanner.nextInt();

        while (operador < 1 || operador > 4) {
            System.out.print("Error. Escriba un número válido del 1 al 4: ");
            operador = scanner.nextInt();
        }

        int saldoActual = saldos[operador - 1];

        if (saldoActual <= 0) {
            System.out.println("No tiene saldo abonado en estos momentos en el operador " + operador);
        } else {
            System.out.println("Su saldo actual en el operador " + operador + " es: $" + saldoActual);
        }
    }

    // =========================================================================
    // CAJITA 3: Ver el total de su saldo
    // =========================================================================
    public static void verTotalGeneral(int[] saldos) {
        int totalGeneral = 0;

        for (int i = 0; i < saldos.length; i++) {
            totalGeneral += saldos[i];
        }

        System.out.println("\n--- RESUMEN GENERAL DE SALDOS ---");
        System.out.println("El saldo total acumulado entre todos los operadores es: $" + totalGeneral);
    }
}