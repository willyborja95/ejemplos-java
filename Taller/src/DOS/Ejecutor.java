package DOS;

public class Ejecutor {

    public static void main(String args[]) {
        //se crea una instancia un objeto LlerArchivoTexto para abir, leer y cerra un archivo
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();
        aplicacion.abrirArchivo("estudiantes.txt");
        aplicacion.leer_informacion();
        aplicacion.cerrarArchivo();
    } // fin de main
} // fin de la clase PruebaLeerArchivoTexto
