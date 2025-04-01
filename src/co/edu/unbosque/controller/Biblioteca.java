package co.edu.unbosque.controller;
import co.edu.unbosque.model.Libro;
import co.edu.unbosque.view.Menu;

import java.util.ArrayList;

/**
 * Clase controladora que gestiona las operaciones principales del sistema de biblioteca.
 * Maneja el catálogo de libros y coordina las interacciones entre la vista (Menu) y el modelo (Libro).
 *
 */
public class Biblioteca {

	private Menu menu = new Menu();
	private ArrayList<Libro> catalogo = new ArrayList<>();

	/**
	 * Método principal que inicia la ejecución del sistema de biblioteca.
	 * Presenta un menú interactivo y procesa las opciones seleccionadas por el usuario.
	 *
	 * El sistema permanece en ejecución hasta que el usuario seleccione la opción de salir (6).
	 */
	public void run() {

		do {

			int opcion = menu.mostrarMenuPrincipal();
			switch(opcion) {
				case 1:

					String datosLibro = menu.agregarLibro();
					String[] datos = datosLibro.split("&");

					if (datos.length == 3) {
						Libro nuevoLibro = new Libro("", "", 0.0);
						nuevoLibro.setIsbn(datos[0].trim());
						nuevoLibro.setTitulo(datos[1].trim());
						nuevoLibro.setPrecio(Double.parseDouble(datos[2].trim()));
						nuevoLibro.setCantidadDisponible(0);
						nuevoLibro.setCantidadVendida(0);
						nuevoLibro.setDisponible(true);

						catalogo.add(nuevoLibro);
						menu.mostrarLibroAgregado(nuevoLibro.toString());
					} else {
						System.out.println("Formato incorrecto. Use 'isbn&titulo&precio'.");
					}
					break;

				case 2:

					System.out.println("Ingresó a la opción 2: Agregar unidades a un libro\n" + "Libros:");

					for (int i = 0; i < catalogo.size(); i++) {
						Libro libro = catalogo.get(i);
						if (libro.isDisponible()) {
							System.out.println((i + 1) + ". " + libro.toString());
						} else {
							System.out.println((i + 1) + ". Espacio disponible.");
						}
					}

					String datosUnidades = menu.agregarUnidadesLibro();
					String[] partes = datosUnidades.split("&");

					if (partes.length != 2) {
						System.out.println("Formato incorrecto. Use 'númeroLibro&unidades'.");
						break;
					}

					try {

						int numeroLibro = Integer.parseInt(partes[0].trim()) - 1;
						int unidades = Integer.parseInt(partes[1].trim());

						if (numeroLibro < 0 || numeroLibro >= catalogo.size()) {
							System.out.println("El libro seleccionado no existe.");
							break;
						}

						Libro libroSeleccionado = catalogo.get(numeroLibro);

						if (!libroSeleccionado.isDisponible()) {
							System.out.println("El libro seleccionado no existe.");
							break;
						}

						if (unidades <= 0) {
							System.out.println("Las unidades deben ser mayores a cero.");
							break;
						}

						libroSeleccionado.setCantidadDisponible(libroSeleccionado.getCantidadDisponible() + unidades);
						System.out.println("Se agregaron " + unidades + " unidades al libro " + (numeroLibro + 1) + ":\n"
								+ libroSeleccionado.toString());

					} catch (NumberFormatException e) {
						System.out.println("Ingrese números válidos para libro y unidades.");
					}
					break;

				case 3:

					System.out.println("Ingresó a la opción 3: Retirar libro" + "Libros:");
					for (int i = 0; i < catalogo.size(); i++) {
						Libro libro = catalogo.get(i);
						System.out.println((i + 1) + ". " + (libro.isDisponible() ? libro.toString() : "Espacio disponible."));
					}
					String inputLibro = menu.LibroRetirar();

					try {
						int numeroLibro = Integer.parseInt(inputLibro.trim()) - 1;

						if (numeroLibro < 0 || numeroLibro >= catalogo.size()) {
							System.out.println("No se puede retirar el libro porque no existe.");
							break;
						}

						Libro libro = catalogo.get(numeroLibro);

						if (!libro.isDisponible() || libro.getCantidadDisponible() == 0) {
							System.out.println("No se puede retirar el libro porque no existe.");
							break;
						}

						System.out.println("Se retiró el libro " + (numeroLibro + 1) + ":\n" + libro.toString());

						libro.setDisponible(false);
						libro.setCantidadDisponible(0);

					} catch (NumberFormatException e) {
						System.out.println("Ingrese un número válido.");
					}
					break;

				case 4:

					System.out.println("Ingresó a la opción 4: Cambiar libro de posición" + "Libros:");
					for (int i = 0; i < catalogo.size(); i++) {
						Libro libro = catalogo.get(i);
						System.out.println((i + 1) + ". " + (libro.isDisponible() ? libro.toString() : "Espacio disponible."));
					}

					String datosCambio = menu.cambiarPosicionLibro();
					String[] partesCambio = datosCambio.split("&");

					if (partesCambio.length != 2) {
						System.out.println("Formato incorrecto. Use 'libro&posición'.");
						break;
					}

					try {
						int libroOrigenIdx = Integer.parseInt(partesCambio[0].trim()) - 1;
						int libroDestinoIdx = Integer.parseInt(partesCambio[1].trim()) - 1;

						if (libroOrigenIdx < 0 || libroOrigenIdx >= catalogo.size() ||
								libroDestinoIdx < 0 || libroDestinoIdx >= catalogo.size()) {
							System.out.println("Posición inválida.");
							break;
						}

						Libro libroOrigen = catalogo.get(libroOrigenIdx);
						Libro libroDestino = catalogo.get(libroDestinoIdx);

						if (!libroOrigen.isDisponible()) {
							System.out.println("El libro de origen no existe.");
							break;
						}

						if (libroDestino.isDisponible()) {
							System.out.println("No se puede mover el libro porque el espacio está ocupado.");
							break;
						}

						catalogo.set(libroDestinoIdx, libroOrigen);
						catalogo.set(libroOrigenIdx, new Libro("", "", 0.0));
						catalogo.get(libroOrigenIdx).setDisponible(false);

						System.out.println("Se cambió el libro de posición.");

						System.out.println("Libros:");
						for (int i = 0; i < catalogo.size(); i++) {
							Libro libro = catalogo.get(i);
							System.out.println((i + 1) + ". " + (libro.isDisponible() ? libro.toString() : "Espacio disponible."));
						}

					} catch (NumberFormatException e) {
						System.out.println("Ingrese números válidos.");
					}
					break;

				case 5:

					System.out.println("Ingresó a la opción 5: Vender libro");
					System.out.println("Libros:");
					for (int i = 0; i < catalogo.size(); i++) {
						Libro libro = catalogo.get(i);
						System.out.println((i + 1) + ". " + (libro.isDisponible() ? libro.toString() : "Espacio disponible."));
					}

					String datosVenta = menu.venderLibro();
					String[] partesVenta = datosVenta.split("&");

					if (partesVenta.length != 2) {
						System.out.println("Formato incorrecto. Use 'libro&cantidad'.");
						break;
					}

					try {
						int numeroLibro = Integer.parseInt(partesVenta[0].trim()) - 1;
						int cantidad = Integer.parseInt(partesVenta[1].trim());

						if (numeroLibro < 0 || numeroLibro >= catalogo.size()) {
							System.out.println("El libro seleccionado no existe.");
							break;
						}

						Libro libro = catalogo.get(numeroLibro);

						if (!libro.isDisponible()) {
							System.out.println("El libro seleccionado no existe.");
							break;
						}

						if (cantidad <= 0) {
							System.out.println("La cantidad debe ser mayor a cero.");
							break;
						}

						if (cantidad > libro.getCantidadDisponible()) {
							System.out.println("La cantidad no es correcta.");
							break;
						}

						libro.setCantidadDisponible(libro.getCantidadDisponible() - cantidad);
						libro.setCantidadVendida(libro.getCantidadVendida() + cantidad);

						System.out.println("Se vendieron " + cantidad + " unidades del libro:\n" + libro.toString());

					} catch (NumberFormatException e) {
						System.out.println("Ingrese números válidos.");
					}
					break;

				case 6:

					System.out.println("Goodbye");
					System.exit(0);
					break;

				default:
					System.out.println("Opción inválida");
			}
		}while (true);
	}
}
