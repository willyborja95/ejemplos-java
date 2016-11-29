/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio;

import escrituraArchivos2.Universidad;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author SALAS
 */
public class ClaseEscritura {
    
    private Formatter salida;
    
    public void abrir_archivo(){
        try{
            salida = new Formatter("calificaciones.txt");            
        }
        catch(FileNotFoundException file){
            System.err.println(
                    "No ha podido crearse el archivo.");
            System.exit(1);
        }
        catch(SecurityException secutiry){
            System.err.println("No tiene acceso de escritura a este archivo.");
            System.exit(1);
        }
    }
    
    public void agregar_informacion() {
        // el archivo permite el ingreso
        // de edad, nombre, apellido de una persona
        
        Scanner entrada = new Scanner(System.in);
        boolean bandera = true;

        while (bandera) // itera hasta que bandera sea false
        {
            try // envía valores al archivo
            {
                // obtiene los datos que se van a enviar
                System.out.println("Ingrese los nombres");
                String nombres = entrada.nextLine();
                System.out.println("Ingrese los apellidos");
                String apellidos = entrada.nextLine();
                System.out.println("Ingrese la calificacion 1");
                double calificacion1 = entrada.nextDouble();
                System.out.println("Ingrese la calificacion 2");
                double calificacion2 = entrada.nextDouble();
                Universidad u = new Universidad(n_hombres, n_mujeres, nombre, ciudad);
                // escribe el nuevo registro
                salida.format("%d|%d|%s|%s\n", u.obtener_numero_hombres(), u.obtener_numero_mujeres(), u.obtener_nombre(), u.obtener_ciudad());

                System.out.println("Desea ingresar más datos si (1), no(2)");
                int valor = entrada.nextInt();
                if (valor == 2) {
                    bandera = false;
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
    } // fin del método agregarRegistros

    // cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    }
    
}
