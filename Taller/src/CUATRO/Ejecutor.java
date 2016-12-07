package CUATRO;

public class Ejecutor
{
   public static void main( String args[] )
   {
      Factura aplicacion = new Factura(); // Creamos un objeto llamado aplicacion

      aplicacion.abrir_archivo(); // Llamamos el metodo abrir_archivo
      aplicacion.agregar_informacion();// Llamamos el metodo agregar_informacion
      aplicacion.cerrar_archivo(); // Llamamos el metodo cerrar_archivo
   } // fin del main
} // fin de la clase Ejecutor

