package co.edu.unbosque.model;

/**
 * Clase que representa un libro en el sistema de gestión de biblioteca.
 * Contiene atributos como ISBN, título, precio, cantidad disponible y cantidad vendida.
 */
public class Libro {

    private String isbn;
    private String titulo;
    private double precio;
    private int cantidadDisponible = 1;
    private int cantidadVendida = 0;
    private boolean disponible = true;

    /**
     * Constructor de la clase Libro.
     *
     * @param isbn Identificador único del libro.
     * @param titulo Título del libro.
     * @param precio Precio del libro en formato decimal.
     */
    public Libro(String isbn, String titulo, double precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.precio = precio;
        this.cantidadDisponible = 0;
        this.cantidadVendida = 0;
        this.disponible = true;
    }

    /**
     * Establece el ISBN del libro.
     *
     * @param isbn Nuevo ISBN a asignar.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo Nuevo título a asignar.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Establece el precio del libro.
     *
     * @param precio Nuevo precio a asignar.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Establece la cantidad disponible del libro.
     *
     * @param cantidadDisponible Nueva cantidad disponible a asignar.
     */
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Establece la cantidad vendida del libro.
     *
     * @param cantidadVendida Nueva cantidad vendida a asignar.
     */
    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    /**
     * Obtiene el ISBN del libro.
     *
     * @return ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return Título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el precio del libro.
     *
     * @return Precio del libro.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene la cantidad disponible del libro.
     *
     * @return Cantidad disponible del libro.
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Obtiene la cantidad vendida del libro.
     *
     * @return Cantidad vendida del libro.
     */
    public int getCantidadVendida() {
        return cantidadVendida;
    }

    /**
     * Representación en String del libro.
     *
     * @return String con el formato: "Libro{isbn=..., titulo=..., precio=..., cantidadDisponible=..., cantidadVendida=...}".
     *         Si el libro no está disponible, retorna "Espacio disponible.".
     */
    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", cantidadDisponible=" + cantidadDisponible +
                ", cantidadVendida=" + cantidadVendida +
                '}';
    }

    /**
     * Agrega unidades a la cantidad disponible del libro.
     *
     * @param unidades
     */
    public void agregarUnidades(int unidades) {
        this.cantidadDisponible += unidades;
    }

    /**
     * Establece la disponibilidad del libro.
     *
     * @param disponible `true` para marcar como disponible, `false` para retirarlo.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Verifica si el libro está disponible.
     *
     * @return `true` si el libro está disponible, `false` en caso contrario.
     */
    public boolean isDisponible() {
        return disponible;
    }


}