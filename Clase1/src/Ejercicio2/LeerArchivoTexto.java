package Ejercicio2;

// Ejemplo tomado del libro 
// D EITEL , P AUL J. Y H ARVEY M. D EITEL
// CÓMO PROGRAMAR EN J AVA . Séptima edición
// fines educativos
// Prueba de la clase ArchivoTexto.
// Este programa lee un archivo de texto y muestra cada registro.
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class LeerArchivoTexto {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("notas2.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public void leer_informacion() {

        ArrayList<String> datos = null;
        ArrayList<Persona> personas = new ArrayList<Persona>();
        Persona p;
        Double mejorPromedio = 0.0;

        // lee registros del archivo, usando el objeto Scanner
        try {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                datos = new ArrayList<String>(Arrays.asList(linea.split(";")));
                p = new Persona(datos.get(0), datos.get(1),
                        Double.valueOf(datos.get(2)), Double.valueOf(datos.get(3)));
                personas.add(p);
            } // fin de while

            for (int i = 0; i < personas.size(); i++) {
                System.out.printf("El promedio de %s %s es: %f\n", personas.get(i).getNombre(),
                        personas.get(i).getApellido(), personas.get(i).getPromedio());
            }

            for (int i = 0; i < personas.size(); i++) {
                if (mejorPromedio < personas.get(i).getPromedio()) {
                    mejorPromedio = personas.get(i).getPromedio();
                }
            }
            System.out.println("");

            System.out.println("El mejor promedio es: " + mejorPromedio);

        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del metodo leerRegistros
    // cierra el archivo y termina la aplicación

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo
} // fin de la clase LeerArchivoTexto

