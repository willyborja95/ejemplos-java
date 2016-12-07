package UNO;

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
                
                 //Almacena toda la nformación de un registro
                String linea = entrada.nextLine();
                componentes = new ArrayList<String>(Arrays.asList(linea.split(",")));
                
                //Si el nombre de un país contiene la letra u, imprime su nombre junto con su nombre en inglés
                if (componentes.get(0).contains("U") || componentes.get(0).contains("u")){
                    System.out.println(componentes.get(0) + " , " + componentes.get(1));

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
