package TRES;

public class Ejecutor {

    public static void main(String args[]) {
        //se crea una instancia un objeto LeerArchivoTexto para abir, leer y cerra un archivo
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();
        aplicacion.abrirArchivo("estudiantes.txt");//se abre el archivo estudiantes.txt
        aplicacion.leer_informacion();//se lee la información del archivo mencionado
        aplicacion.escribir_archivo();//se escribe la información dentro de un nuevo archivo
        aplicacion.cerrarArchivo(); //se cierra el archivo
    } // fin de main
} // fin de la clase PruebaLeerArchivoTexto
