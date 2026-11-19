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

    // ===== Variables de las entidades =====
    static String[][] usuarios = new String[12][5];
    static String[][] cajeros  = new String[12][5];
    static String[][] trenes   = new String[3][3];
    static String[][] tickets  = new String[12][7];
    static String[][] ventas   = new String[12][5];

    static Scanner entrada = new Scanner(System.in);

    static String[] encabezadosUsuario = {"Id", "Nombre", "Apellido", "Origen", "Destino"};
    static String[] encabezadosTren = {"Numero de maquina", "Modelo", "Capacidad"};

    // ===== Métodos de Usuario =====
    public static void registrarUsuario() {
        for ( int i=0; i<usuarios.length;i++){
            if (usuarios[i][0 == null]){
                System.out.println("registrando usuari (fila"+ (i+1) ")+ :");
                for (int j=0; j<usuario[i].length;j++){
                    System.out.println("ingrese los dato"+encabezadosUsuario);
                    usuario[i][j]= entrada.nextLine()
                }
            }
        }

    }
    public static void actualizarUsuario() {
      System.out.println("escriba el id del usuario que desea actualizar")
      id= entrada.nextInt();
      int i  = id -1;

      System.out.println("seleccione el dato a actualizar 1.nombre 2.apellido 3.origen 4 destino");

      int opcion = entrada.nextInt();
      entrada.nextLine();

      switch (opcion){
          case 1:
              System.out.println("escriba el nombre a actualizar");
              nombre[i][1]=entrada.nextLine();
              break;
          case 2:
              System.out.println("escria el apellido a actualizar");
              apellido[i][2]= entrada.nextLine();
              break;
          case 3:
              System.out.println("escriba el nuevo origen");
              origen[i][3] = entrada.hasNextLine();
              break;
          case 4:
              System.out.println("escriba el nuevo destino");
              destino[i][4] = entrada.nextLine();
              break;
          default:
              System.out.println("escriba una opcion validad");
              break;



      }


    }
    public static void consultarUsuarioPorId() {
        System.out.println("escriba el id del usuario a consultar");
        int id = Integer.parseInt(entrada.nextLine());
        int i = id - 1;

        if (i >= 0 && i < usuarios.length && usuarios[i][0] != null) {
            System.out.println("Datos usuario " + id + ": ");
            for (int j = 0; j < usuarios[i].length; j++) {
                System.out.println(encabezadosUsuario[j] + ": " + usuarios[i][j]);
            }
        } else {
            System.out.println("Ese usuario no existe.");
        }
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


    }

    // ===== Métodos del Tren =====
public static void registrarTren() {
    
}


    public static void actualizarTren() { }
    public static void consultarTrenPorId() { }
    public static void consultarTodosLosTrenes() { }
    public static void eliminarTren() { }

    // ===== Métodos del Cajero =====
    public static void registrarCajero() { }
    public static void login() { }

    // ===== Métodos del Ticket =====
    public static void registrarTicket() { }
    public static void actualizarTicket() { }
    public static void consultarTicketPorId() { }
    public static void consultarTodosLosTickets() { }
    public static void eliminarTicket() { }

    // ===== Métodos de la Venta =====
    public static void registrarVenta() { }
    public static void actualizarVenta() { }
    public static void consultarVentaPorId() { }
    public static void consultarTodasLasVentas() { }
    public static void eliminarVenta() { }

    // ===== Menús =====
    public static void menuApp() { }
    public static void menuUsuario() { }
    public static void menuTren() { }
    public static void menuTickets() { }
    public static void menuVenta() { }

    // ===== Método principal =====
    public static void main(String[] args) {
        // aquí arranca el programa
    }
}