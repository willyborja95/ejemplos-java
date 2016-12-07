package UNO;

import UNO.LeerArchivoTexto;

public class Ejecutor {

    public static void main(String args[]) {
        //se crea una instancia un objeto LlerArchivoTexto para abir, leer y cerra un archivo
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();
        aplicacion.abrirArchivo("paises.txt");
        aplicacion.leer_informacion();
        aplicacion.cerrarArchivo();
    } // fin de main
} // fin de la clase PruebaLeerArchivoTexto
