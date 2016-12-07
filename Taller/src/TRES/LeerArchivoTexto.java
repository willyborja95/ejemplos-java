package TRES;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class LeerArchivoTexto {

    private Scanner entrada;//permite leer la información de un archivo existente.
    private ArchivoTexto archivo = new ArchivoTexto();//permite abriri y escribir un nuevo archivo.
    ArrayList<String> cadenaImprimir = new ArrayList<String>(); //Almacena la cadena que se imprimirá en un archivo externo.

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
        //Permite almacenar individualmente los nombres, apellidos y año de nacimiento de cada estudiante.
        ArrayList<String> componentes = null; 

        // inicio del bloque try
        try {
            while (entrada.hasNext()) {

                //Almacena toda la información de un registro
                String linea = entrada.nextLine();
                //Obtiene los componentes de la línea de código
                componentes = new ArrayList<String>(Arrays.asList(linea.split("\\|")));
                //Calculo de la edad de cada alumno
                int edad = 2016 - Integer.parseInt(componentes.get(2));
                //Genera un formulario con la información del estudiante
                cadenaImprimir.add(componentes.get(1) + " | " + componentes.get(0) + " | " + edad);
            }

            // fin de while
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
    
    public void escribir_archivo(){
        try{
            //abre un nuevo archivo.
            archivo.abrir_archivo("estudiantes-2-1.txt");
            archivo.agregar_informacion(cadenaImprimir);
            archivo.cerrar_archivo();
        }
        
        catch (SecurityException securityException) {
            System.err.println("No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
    }//fin del método escribir_archivo

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo
} // fin de la clase LeerArchivoTexto
