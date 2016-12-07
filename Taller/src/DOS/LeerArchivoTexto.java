package DOS;

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

    // permite al usuario abrir un archivo
    public void abrirArchivo(String archivo) {
        try {
            entrada = new Scanner(new File(archivo));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee un archivo
    public void leer_informacion() {
         
        ArrayList<String> componentes = null; //Se almacenan individualmente los componentes que conforman un registro en el archivo

        // inicio del bloque try
        try{
            while (entrada.hasNext()) {
                
                 //Almacena toda la información de un registro
                String linea = entrada.nextLine();
                componentes = new ArrayList<String>(Arrays.asList(linea.split("\\|")));
                
                //Si el apellido d un estudiante empieza con A, B, C, E o U, se imprimirán sus datos
                if (componentes.get(0).substring(0, 1).contains("A") || componentes.get(0).substring(0, 1).contains("B") || componentes.get(0).substring(0, 1).contains("C") ||componentes.get(0).substring(0, 1).contains("E") || componentes.get(0).substring(0, 1).contains("U")){
                    System.out.println(linea);
                }

            } // fin de while
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
