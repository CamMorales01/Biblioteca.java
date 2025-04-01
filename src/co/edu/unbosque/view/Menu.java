package co.edu.unbosque.view;
import java.util.Scanner;

/**
 * Clase Menu que maneja la interacción con el usuario.
 * Contiene métodos para mostrar menús y capturar entradas del usuario.
 */
public class Menu {

	Scanner scanner = new Scanner(System.in);

    /**
     * Muestra el menú principal y captura la opción seleccionada por el usuario.
     *
     * @return Número entero que representa la opción elegida (1-6).
     */
    public int mostrarMenuPrincipal() {

        System.out.println("\nMenu de usuario.\n"
                + "1. Agregar libro.\n"
                + "2. Agregar unidades a un libro.\n"
                + "3. Retirar libro.\n"
                + "4. Cambiar libro de posición.\n"
                + "5. Vender libro.\n"
                + "6. Salir.\n"
                + "Seleccione una opción:");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return opcion;
    }

    /**
     * Captura los datos ingresados por el usuario para agregar un nuevo libro.
     *
     * @return String con el formato "isbn&titulo&precio".
     * @example "ABC123&La Odisea&45000"
     */
    public String agregarLibro() {
        System.out.println("Ingresó a la opción 1: Agregar libro \n"
                + "Ingrese los datos separados por & (isbn, titulo, precio):");
        return scanner.nextLine();
    }

    /**
     * Muestra un mensaje indicando que el libro ha sido agregado.
     *
     * @param infolibro Información del libro agregado.
     */
    public void mostrarLibroAgregado(String infolibro) {
        System.out.println("Libro agregado: " + infolibro);
    }

    /**
     * Captura los datos para agregar unidades a un libro existente.
     *
     * @return String con el formato "libro&unidades".
     * @example "2&5"
     */
    public String agregarUnidadesLibro() {
        System.out.println("Ingrese los datos separados por & (libro&unidades):");
        return scanner.nextLine();
    }

    /**
     * Captura el número de libro que el usuario desea retirar.
     *
     * @return Número de libro como String.
     * @example "1"
     */
    public String LibroRetirar() {
        System.out.println("Ingrese el número de libro que desea retirar:");
        return scanner.nextLine();
    }

    /**
     * Captura los datos para cambiar un libro de posición.
     *
     * @return String con el formato "libroACambiarr&nuevoEspacio".
     * @example "2&1"
     */
    public String cambiarPosicionLibro() {
        System.out.println("Ingrese los datos separados por & (libro a cambiar & nuevo espacio):");
        return scanner.nextLine();
    }

    /**
     * Captura los datos para vender un libro.
     *
     * @return String con el formato "libro&cantidad".
     * @example "3&2"
     */
    public String venderLibro() {
        System.out.println("Ingrese los datos separados por & (libro&cantidad):");
        return scanner.nextLine();
    }
}
