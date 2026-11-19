package Works;

import java.util.Scanner;

public class TallerFinalYo {

    // Crear las variables para las entidades
    /* Ferrocarriles de Antioquia requiere un sistema que permita asignar
- un ticket en un tren a un usuario a través de una venta.
- Del Usuario requiere: id, nombre , apellido, origen , destino.
- Del cajero requiere conocer los mismos datos (id, nombre, apellido) y adicional
- el rol y la contraseña.
- Del tren requiere conocer: # de máquina , módelo, capacidad.
- Del Ticket requiere conocer: Id del ticket , usuario, tren , asiento , origen , destino, precio.
- De la venta requiere conocer: id de la venta , id del ticket, precio, cantidad , total
- El sistema debe permitir registrar, actualizar , consultar por id , consultar todos y eliminar, para cada
- entidad del sistema (Usuarios, trenes, tickets , ventas)
- El sistema debe permitir navegar las opciones a través de menús
- El sistema debe permitir registrar un cajero e iniciar sesión
- El sistema debe permitir al cajero contar con un dashboard con los menus a las diferentes opciones.
- después de iniciar sesión.
- La compañia cuenta con tres trenes cada uno con capacidad de 4 pasajeros.
- Cada tren hace un viaje de ida y vuelta, en un día , a tres destinos: Santa Fe , Cisneros y Puerto Berrio  */

    //usuario
    static int id;
    static String nombre;
    static String apellido;
    static String destino;
    static String origen;

    //cajero
    static String contraseña;
    static String rol;

    //tren
    static String numerodemaquina;
    static String modelo;
    static String capacidad;

    // Ticket
    static int ticketId;
    static int usuario;
    static String origenRuta;
    static String destinoRuta;
    static String silla;
    static int tren;
    static String fecha;
    static String hora;
    static double precio;

    // Venta
    static int ventaId;
    static int ticketIdVenta;
    static int cantidad;
    static double precioVentaUnitario;
    static double totalVenta;

    static String[][] usuarios = new String[12][5];
    static String[][] cajeros = new String[12][5];
    static String[][] trenes = new String[3][3];
    static String[][] tickets = new String[12][9];
    static String[][] ventas = new String[12][5];

    static Scanner entrada = new Scanner(System.in);

    static String[] encabezadosUsuario = {"Id", "Nombre", "Apellido", "Origen", "Destino"};
    static String[] encabezadosTren = {"Numero de maquina", "Modelo", "Capacidad"};
    static String[] encabezadostickets = {"Id ticket", "Usuario", "Origen", "Destino", "Silla", "Tren", "Fecha", "Hora", "Precio"};
    static String[] encabezadosCajero = {"Id", "Nombre", "Apellido", "Rol", "Contraseña"};
    static String[] encabezadoVentas = {"VentaId", "ticketIdVenta", "cantidad", "precioVentaUnitario", "totalVenta"};

    public static void main(String[] args) {
        // Método principal para iniciar la aplicación con el menú inicial / login
        int opcion = 0;
        do {
            System.out.println("\n=== FERROCARRILES DE ANTIOQUIA ===");
            System.out.println("1. Registrar Cajero");
            System.out.println("2. Iniciar Sesion (Login)");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opcion:");
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1:
                    registrarCajero();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 3);
    }

    // ===== Métodos de Usuario =====
    public static void crearUsuario() {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i][0] == null) {
                System.out.println("Registrando nuevo usuario (Fila " + (i + 1) + "):");
                for (int j = 0; j < usuarios[i].length; j++) {
                    System.out.println("Ingrese " + encabezadosUsuario[j] + ": ");
                    usuarios[i][j] = entrada.nextLine();
                }
                System.out.println("Usuario registrado con exito.");
                return;
            }
        }
        System.out.println("No hay mas espacio para usuarios.");
    }

    public static void consultarUsuarios() {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i][0] != null) {
                System.out.println("Usuario " + (i + 1) + ":");
                for (int j = 0; j < usuarios[i].length; j++) {
                    System.out.println(encabezadosUsuario[j] + ": " + usuarios[i][j]);
                }
                System.out.println("----------------------");
            }
        }
    }

    public static void consultarUsuarioPorId() {
        System.out.println("Indique el id del usuario a consultar");
        int idBuscado = Integer.parseInt(entrada.nextLine());
        int i = idBuscado - 1;

        if (i >= 0 && i < usuarios.length && usuarios[i][0] != null) {
            System.out.println("Datos usuario " + idBuscado + ": ");
            for (int j = 0; j < usuarios[i].length; j++) {
                System.out.println(encabezadosUsuario[j] + ": " + usuarios[i][j]);
            }
        } else {
            System.out.println("Ese usuario no existe.");
        }
    }

    public static void actualizarUsuario() {
        System.out.println("Ingrese el id del usuario a actualizar");
        int idBuscado = Integer.parseInt(entrada.nextLine());
        int i = idBuscado - 1;

        if (i >= 0 && i < usuarios.length && usuarios[i][0] != null) {
            System.out.println("Seleccione el dato a actualizar 1. Nombre 2. Apellido 3. Origen 4. Destino");
            int opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Actualizar nombre");
                    usuarios[i][1] = entrada.nextLine();
                    break;
                case 2:
                    System.out.println("Actualizar apellido");
                    usuarios[i][2] = entrada.nextLine();
                    break;
                case 3:
                    System.out.println("Actualizar origen");
                    usuarios[i][3] = entrada.nextLine();
                    break;
                case 4:
                    System.out.println("Actualizar destino");
                    usuarios[i][4] = entrada.nextLine();
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } else {
            System.out.println("Ese usuario no existe.");
        }
    }

    public static void eliminarUsuario() {
        System.out.println("Ingrese el id del usuario a eliminar");
        int idBuscado = Integer.parseInt(entrada.nextLine());
        int i = idBuscado - 1;

        if (i >= 0 && i < usuarios.length) {
            for (int j = 0; j < usuarios[i].length; j++) {
                usuarios[i][j] = null;
            }
            System.out.println("Usuario eliminado.");
        } else {
            System.out.println("Ese usuario no existe.");
        }
    }

    // ===== Métodos del Tren =====
    public static void crearTren() {
        for (int i = 0; i < trenes.length; i++) {
            if (trenes[i][0] == null) {
                System.out.println("Registrando tren (Fila " + (i + 1) + "):");
                for (int j = 0; j < trenes[i].length; j++) {
                    System.out.println("Ingrese " + encabezadosTren[j] + ": ");
                    trenes[i][j] = entrada.nextLine();
                }
                System.out.println("Tren registrado con exito.");
                return;
            }
        }
        System.out.println("No hay espacio para mas trenes.");
    }

    public static void consultarTrenes() {
        for (int i = 0; i < trenes.length; i++) {
            if (trenes[i][0] != null) {
                System.out.println("Tren " + (i + 1) + ":");
                for (int j = 0; j < trenes[i].length; j++) {
                    System.out.println(encabezadosTren[j] + ": " + trenes[i][j]);
                }
                System.out.println("----------------------");
            }
        }
    }

    public static void consultarTrenPorNumeroDeMaquina() {
        System.out.println("Indique el numero de maquina a consultar");
        int numero = Integer.parseInt(entrada.nextLine());
        int i = numero - 1;

        if (i >= 0 && i < trenes.length && trenes[i][0] != null) {
            System.out.println("Datos tren " + numero + ": ");
            for (int j = 0; j < trenes[i].length; j++) {
                System.out.println(encabezadosTren[j] + ": " + trenes[i][j]);
            }
        } else {
            System.out.println("Ese tren no existe.");
        }
    }

    public static void actualizarTren() {
        System.out.println("Escriba el ID o número del tren que desea cambiar:");
        String trenId = entrada.nextLine(); // Pedimos el ID en texto para buscarlo con calma

        boolean encontrado = false;

        // Tu bucle for para recorrer las filas buscando la coincidencia
        for (int i = 0; i < trenes.length; i++) {

            // Verificamos que la casilla no esté vacía y que el ID coincida
            if (trenes[i][0] != null && trenes[i][0].equals(trenId)) {
                encontrado = true;

                System.out.println("Seleccione el dato a actualizar: 1. Modelo 2. Capacidad");
                int opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Escriba el nuevo modelo:");
                        trenes[i][1] = entrada.nextLine();
                        System.out.println("¡Modelo actualizado con éxito!");
                        break;
                    case 2:
                        System.out.println("Escriba la nueva capacidad:");
                        trenes[i][2] = entrada.nextLine();
                        System.out.println("¡Capacidad actualizada con éxito!");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                break; // Rompemos el for porque ya encontramos y actualizamos el tren
            }
        }

        // Si terminó de buscar y el switch de encontrado sigue en falso
        if (!encontrado) {
            System.out.println("Ese tren no existe en el sistema.");
        }
    }

    public static void eliminarTren() {
        System.out.println("Ingrese el numero de maquina del tren a eliminar");
        int numero = Integer.parseInt(entrada.nextLine());
        int i = numero - 1;

        if (i >= 0 && i < trenes.length) {
            for (int j = 0; j < trenes[i].length; j++) {
                trenes[i][j] = null;
            }
            System.out.println("Tren eliminado.");
        } else {
            System.out.println("Ese tren no existe.");
        }
    }

    // ===== Métodos del Cajero =====
    public static void registrarCajero() {
        for (int i = 0; i < cajeros.length; i++) {
            if (cajeros[i][0] == null) {
                System.out.println("Registrando cajero:");
                for (int j = 0; j < cajeros[i].length; j++) {
                    System.out.println("Ingrese " + encabezadosCajero[j] + ":");
                    cajeros[i][j] = entrada.nextLine();
                }
                System.out.println("Cajero registrado exitosamente.");
                return;
            }
        }
        System.out.println("No hay espacio para mas cajeros.");
    }

    public static void login() {
        System.out.println("Ingrese su id:");
        String idIngresado = entrada.nextLine();
        System.out.println("Ingrese su contraseña:");
        String claveIngresada = entrada.nextLine();

        boolean entro = false;

        for (int i = 0; i < cajeros.length; i++) {
            if (idIngresado.equals(cajeros[i][0]) && claveIngresada.equals(cajeros[i][4])) {
                entro = true;
                break;
            }
        }

        if (entro) {
            System.out.println("Bienvenido.");
            menuApp();
        } else {
            System.out.println("Id o contraseña incorrectos.");
        }
    }

    // ===== Métodos del Ticket =====
    public static void registrarTicket() {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0] == null) {
                System.out.println("Registrando ticket:");
                for (int j = 0; j < tickets[i].length; j++) {
                    System.out.println("Ingrese " + encabezadostickets[j] + ": ");
                    tickets[i][j] = entrada.nextLine();
                }
                System.out.println("Ticket registrado.");
                return;
            }
        }
        System.out.println("No hay espacio para mas tickets.");
    }

    public static void actualizarTicket() {
        System.out.println("Ingrese el id del ticket a actualizar");
        int idBuscado = Integer.parseInt(entrada.nextLine());
        int i = idBuscado - 1;

        if (i >= 0 && i < tickets.length && tickets[i][0] != null) {
            System.out.println("Seleccione el dato a actualizar");
            System.out.println("1. Usuario 2. Origen 3. Destino 4. Silla 5. Tren 6. Fecha 7. Hora 8. Precio");
            int opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Actualizar usuario");
                    tickets[i][1] = entrada.nextLine();
                    break;
                case 2:
                    System.out.println("Actualizar origen");
                    tickets[i][2] = entrada.nextLine();
                    break;
                case 3:
                    System.out.println("Actualizar destino");
                    tickets[i][3] = entrada.nextLine();
                    break;
                case 4:
                    System.out.println("Actualizar silla");
                    tickets[i][4] = entrada.nextLine();
                    break;
                case 5:
                    System.out.println("Actualizar tren");
                    tickets[i][5] = entrada.nextLine();
                    break;
                case 6:
                    System.out.println("Actualizar fecha");
                    tickets[i][6] = entrada.nextLine();
                    break;
                case 7:
                    System.out.println("Actualizar hora");
                    tickets[i][7] = entrada.nextLine();
                    break;
                case 8:
                    System.out.println("Actualizar precio");
                    tickets[i][8] = entrada.nextLine();
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } else {
            System.out.println("Ese ticket no existe.");
        }
    }

    public static void consultarTicketPorId() {
        System.out.println("Indique el id del ticket a consultar");
        int idBuscado = Integer.parseInt(entrada.nextLine());
        int i = idBuscado - 1;

        if (i >= 0 && i < tickets.length && tickets[i][0] != null) {
            System.out.println("Datos ticket " + idBuscado + ": ");
            for (int j = 0; j < tickets[i].length; j++) {
                System.out.println(encabezadostickets[j] + ": " + tickets[i][j]);
            }
        } else {
            System.out.println("Ese ticket no existe.");
        }
    }

    public static void consultarTodosLosTickets() {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0] != null) {
                System.out.println("Ticket " + (i + 1) + ":");
                for (int j = 0; j < tickets[i].length; j++) {
                    System.out.println(encabezadostickets[j] + ": " + tickets[i][j]);
                }
                System.out.println("----------------------");
            }
        }
    }

    public static void eliminarTicket() {
        System.out.println("Ingrese el id del ticket a eliminar");
        int idBuscado = Integer.parseInt(entrada.nextLine());
        int i = idBuscado - 1;

        if (i >= 0 && i < tickets.length) {
            for (int j = 0; j < tickets[i].length; j++) {
                tickets[i][j] = null;
            }
            System.out.println("Ticket eliminado.");
        } else {
            System.out.println("Ese ticket no existe.");
        }
    }

    // ===== Métodos de la Venta =====
    public static void registrarVenta() {
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i][0] == null) {
                System.out.println("Registrando venta:");
                for (int j = 0; j < ventas[i].length; j++) {
                    System.out.println("Ingrese " + encabezadoVentas[j] + ": ");
                    ventas[i][j] = entrada.nextLine();
                }
                System.out.println("Venta registrada.");
                return;
            }
        }
        System.out.println("No hay espacio para mas ventas.");
    }

    public static void actualizarVenta() {
        System.out.println("Ingrese el VentaId de la venta a actualizar:");
        int idVenta = Integer.parseInt(entrada.nextLine());
        int i = idVenta - 1;

        if (i >= 0 && i < ventas.length && ventas[i][0] != null) {
            System.out.println("Seleccione el dato a actualizar:");
            System.out.println("1. ticketIdVenta | 2. cantidad | 3. precioVentaUnitario | 4. totalVenta");
            int opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Actualizar ticketIdVenta:");
                    ventas[i][1] = entrada.nextLine();
                    break;
                case 2:
                    System.out.println("Actualizar cantidad:");
                    ventas[i][2] = entrada.nextLine();
                    break;
                case 3:
                    System.out.println("Actualizar precioVentaUnitario:");
                    ventas[i][3] = entrada.nextLine();
                    break;
                case 4:
                    System.out.println("Actualizar totalVenta:");
                    ventas[i][4] = entrada.nextLine();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Esa venta no existe.");
        }
    }

    public static void consultarVentaPorId() {
        System.out.println("Indique el VentaId de la venta a consultar:");
        int idBuscado = Integer.parseInt(entrada.nextLine());
        int i = idBuscado - 1;

        if (i >= 0 && i < ventas.length && ventas[i][0] != null) {
            System.out.println("Datos venta " + idBuscado + ": ");
            for (int j = 0; j < ventas[i].length; j++) {
                System.out.println(encabezadoVentas[j] + ": " + ventas[i][j]);
            }
        } else {
            System.out.println("Esa venta no existe.");
        }
    }

    public static void consultarTodasLasVentas() {
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i][0] != null) {
                System.out.println("Venta " + (i + 1) + ":");
                for (int j = 0; j < ventas[i].length; j++) {
                    System.out.println(encabezadoVentas[j] + ": " + ventas[i][j]);
                }
                System.out.println("----------------------");
            }
        }
    }

    public static void eliminarVenta() {
        System.out.println("Ingrese el VentaId de la venta a eliminar:");
        int idBuscado = Integer.parseInt(entrada.nextLine());
        int i = idBuscado - 1;

        if (i >= 0 && i < ventas.length) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = null;
            }
            System.out.println("Venta eliminada con exito.");
        } else {
            System.out.println("Esa venta no existe.");
        }
    }

    // ===== Menús (Dashboard y Submenús) =====
    public static void menuApp() {
        int opcion = 0;
        do {
            System.out.println("\n=== DASHBOARD PRINCIPAL - CAJERO ===");
            System.out.println("1. Gestionar Usuarios");
            System.out.println("2. Gestionar Trenes");
            System.out.println("3. Gestionar Tickets");
            System.out.println("4. Gestionar Ventas");
            System.out.println("5. Cerrar Sesion");
            System.out.println("Seleccione una opcion:");
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuTren();
                    break;
                case 3:
                    menuTickets();
                    break;
                case 4:
                    menuVentas();
                    break;
                case 5:
                    System.out.println("Cerrando sesion...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }

    public static void menuUsuario() {
        int opcion = 0;
        do {
            System.out.println("\n--- MENU USUARIOS ---");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Consultar Todos los Usuarios");
            System.out.println("3. Consultar Usuario por ID");
            System.out.println("4. Actualizar Usuario");
            System.out.println("5. Eliminar Usuario");
            System.out.println("6. Volver al Dashboard");
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1: crearUsuario(); break;
                case 2: consultarUsuarios(); break;
                case 3: consultarUsuarioPorId(); break;
                case 4: actualizarUsuario(); break;
                case 5: eliminarUsuario(); break;
                case 6: System.out.println("Volviendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);
    }

    public static void menuTren() {
        int opcion = 0;
        do {
            System.out.println("\n--- MENU TRENES ---");
            System.out.println("1. Registrar Tren");
            System.out.println("2. Consultar Todos los Trenes");
            System.out.println("3. Consultar Tren por Numero de Maquina");
            System.out.println("4. Actualizar Tren");
            System.out.println("5. Eliminar Tren");
            System.out.println("6. Volver al Dashboard");
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1: crearTren(); break;
                case 2: consultarTrenes(); break;
                case 3: consultarTrenPorNumeroDeMaquina(); break;
                case 4: actualizarTren(); break;
                case 5: eliminarTren(); break;
                case 6: System.out.println("Volviendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);
    }

    public static void menuTickets() {
        int opcion = 0;
        do {
            System.out.println("\n--- MENU TICKETS ---");
            System.out.println("1. Registrar Ticket");
            System.out.println("2. Consultar Todos los Tickets");
            System.out.println("3. Consultar Ticket por ID");
            System.out.println("4. Actualizar Ticket");
            System.out.println("5. Eliminar Ticket");
            System.out.println("6. Volver al Dashboard");
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1: registrarTicket(); break;
                case 2: consultarTodosLosTickets(); break;
                case 3: consultarTicketPorId(); break;
                case 4: actualizarTicket(); break;
                case 5: eliminarTicket(); break;
                case 6: System.out.println("Volviendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);
    }

    public static void menuVentas() {
        int opcion = 0;
        do {
            System.out.println("\n--- MENU VENTAS ---");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Consultar Todas las Ventas");
            System.out.println("3. Consultar Venta por ID");
            System.out.println("4. Actualizar Venta");
            System.out.println("5. Eliminar Venta");
            System.out.println("6. Volver al Dashboard");
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1: registrarVenta(); break;
                case 2: consultarTodasLasVentas(); break;
                case 3: consultarVentaPorId(); break;
                case 4: actualizarVenta(); break;
                case 5: eliminarVenta(); break;
                case 6: System.out.println("Volviendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);
    }
}