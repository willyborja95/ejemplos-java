package Ejercicio2;


public class Ejecutor{
   public static void main( String args[] )
   {
      LeerArchivoTexto aplicacion = new LeerArchivoTexto();

      
      aplicacion.abrirArchivo();
      aplicacion.leer_informacion();
      aplicacion.cerrarArchivo();
      
   } // fin de main
} // fin de la clase PruebaCrearArchivoTexto

