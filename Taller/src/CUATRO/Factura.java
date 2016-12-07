package CUATRO;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Factura {

    private Formatter salida; // objeto usado para enviar texto al archivo

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            salida = new Formatter("Factura.txt");
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrir_archivo

    // agrega registros al archivo
    public void agregar_informacion() {
        // el archivo permite el ingreso
        // de edad, nombre, apellido de una persona

        Scanner entrada = new Scanner(System.in);
        
        String prod = ""; // Variable prod de tipo cadena inicilaizada en vacio
        String por = "%"; // Variable por de tipo cadena inicilaizada en %
        int opcion, cant = 0; // Variables opcion y cant de tipo entero inicilaizada en cero
        double precio = 0, subt = 0, iva = 0, total = 0; // Variables precio, subt, iva y total de tipo double inicilaizada en cero
        boolean bandera = true; // Variable bandera de tipo Boolean inicilaizada en true

        // obtiene los datos que se van a enviar
        System.out.println("Ingrese el nombre del cliente:"); // Se pide el nombre del cliente
        String nombre = entrada.next(); // Se guarda la opcion seleccionada
        System.out.println("Ingrese la Ciudad"); // Se pide la ciudad del cliente
        String ciudad = entrada.next(); // Se guarda la opcion seleccionada
        salida.format("\t\tComercial Ventas y Reventas\nNombre: %s\nCiudad: %s\n"
                + "------------------------------------\n"
                + "PRODUCTO\t  CANTIDAD\t   PRECIO\n", nombre, ciudad); // Escribimos en el archivo txt el encabezado de la factura

        while (bandera) // itera hasta que bandera sea false
        {
            try // envía valores al archivo
            {
                System.out.println("\n\t  Menú de Compras"); // Opciones del Menú
                System.out.println("----------------------------------------");
                System.out.println("(1) - Arroz; costo del kilo $2.50");
                System.out.println("(2) - Azúcar; costo del kilo $1.50");
                System.out.println("(3) - Aceite; costo $1.30 por unidad");
                System.out.println("(4) - Tallarines; costo $1.50 por unidad");
                System.out.println("(5) - Sal; costo del kilo $1.00");
                System.out.println("----------------------------------------");
                System.out.println("Por favor escoja una opción: "); // Se pregunta por el producto a comprar
                opcion = entrada.nextInt(); // Guardamos la opcion seleccionada

                switch (opcion) { // Agregamos un condicional de seleccion
                    case 1: // Primer case para el primer producto
                        System.out.println("Por favor escriba la cantidad de kilos: "); // Se pregunta por la cantidad a comprar
                        cant = entrada.nextInt(); // Guardamos la cantidad requerida
                        prod = "Arroz     "; // Asignamos a la variable prod el nombre del producto a comprar
                        precio = cant * 2.50; // Obtenemos el precio dependiendo la cantidad
                        subt = subt + precio; // obtenemos el subtotal
                        break;
                    case 2: // Segundo case para el segundo producto
                        System.out.println("Por favor escriba la cantidad de kilos: "); // Se pregunta por la cantidad a comprar
                        cant = entrada.nextInt(); // Guardamos la cantidad requerida
                        prod = "Azucar    "; // Asignamos a la variable prod el nombre del producto a comprar
                        precio = cant * 1.50; // Obtenemos el precio dependiendo la cantidad
                        subt = subt + precio; // obtenemos el subtotal
                        break;
                    case 3: // Tercer case para el tercer producto
                        System.out.println("Por favor escriba la cantidad de unidades: "); // Se pregunta por la cantidad a comprar
                        cant = entrada.nextInt(); // Guardamos la cantidad requerida
                        prod = "Aceite    "; // Asignamos a la variable prod el nombre del producto a comprar
                        precio = cant * 1.30;// Obtenemos el precio dependiendo la cantidad
                        subt = subt + precio; // obtenemos el subtotal
                        break;
                    case 4: // Cuarto case para el cuarto producto
                        System.out.println("Por favor escriba la cantidad de unidades: "); // Se pregunta por la cantidad a comprar
                        cant = entrada.nextInt(); // Guardamos la cantidad requerida
                        prod = "Tallarines"; // Asignamos a la variable prod el nombre del producto a comprar
                        precio = cant * 1.50; // Obtenemos el precio dependiendo la cantidad
                        subt = subt + precio; // obtenemos el subtotal
                        break;
                    case 5: // Quinto case para el quinto producto
                        System.out.println("Por favor escriba la cantidad de kilos: "); // Se pregunta por la cantidad a comprar
                        cant = entrada.nextInt(); // Guardamos la cantidad requerida
                        prod = "Sal       "; // Asignamos a la variable prod el nombre del producto a comprar
                        precio = cant * 1.00; // Obtenemos el precio dependiendo la cantidad
                        subt = subt + precio; // obtenemos el subtotal
                        break;
                    default:
                        throw new AssertionError();
                }
                iva = (subt * 0.14); // Obtenemos el IVA atravez del subtotal
                total = subt + iva; // Obtenemos el total con el subtotal y el IVA

                // Escribimos en el archivo txt los productos a comprar
                salida.format("%s      %d\t    %.2f\n", prod, cant, precio);

                System.out.println("Desea ingresar un nuevo producto? \n(1) SI\n(2) NO"); // Se pregunta si deseamos agregar mas productos
                int valor = entrada.nextInt(); // Se guarda la opcion seleccionada
                if (valor == 2) { // Si la opcion seleccionada es igual a 2
                    bandera = false; // El ciclo While se termina
                }

            } // fin de try
            catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error al escribir en el archivo.");
                return;
            } // fin de catch
            catch (NoSuchElementException elementException) {
                System.err.println("Entrada invalida. Intente de nuevo.");
                entrada.nextLine(); // descarta la entrada para que el usuario intente de nuevo
            } // fin de catch

        } // fin de while
        salida.format("------------------------------------\n"
                + "\t\tSubtotal : %.2f\n\t\tIva 14 %s : %.2f\n\t\tTotal    : %.2f\t\t"
                + "", subt, por, iva, total); // Escribimos en el archivo txt la parte final de la factura
    } // fin del método agregarRegistros

    // cierra el archivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del método cerrarArchivo
} // fin de la clase ArchivoTexto

