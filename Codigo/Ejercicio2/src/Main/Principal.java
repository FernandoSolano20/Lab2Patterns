package Main;

import Adaptador.ReproductorMP3Adapter;
import Objectos.Reproductor;
import Objectos.ReproductorMP3;
import Objectos.ReproductorWAV;

import java.util.Scanner;

public class Principal {
    private static Scanner read = new Scanner(System.in);

    /*************************
     Nombre: main
     Parametros: String[] args, arguementos
     Return: void
     Descripcion: programa principal
     ************************/
    public static void main(String[] args) {
        mostrarMenu();
    }

    /*************************
     Nombre: showMenu
     Parametros:
     Return: void
     Descripcion: muesta menu
     ************************/
    private static void mostrarMenu() {
        int opc = 0;
        do{
            System.out.println("Digite lo que desea");
            System.out.println("1- Digite archivo a reproducir");
            System.out.println("2- Salir");
            opc = read.nextInt();
            procesarOpcion(opc);
        }while (opc != 2);
    }

    /*************************
     Nombre: processOpc
     Parametros: opc int opcion del usuario
     Return: void
     Descripcion: procesa la opcion del usuario
     ************************/
    private static void procesarOpcion(int opc) {
        switch (opc){
            case 1:
                datosArchivo();
                break;

            case 2:
                System.out.println("Salir");
                break;

            default:
                System.out.println("No valido");
                break;
        }
    }

    /*************************
     Nombre: datosArchivo
     Parametros:
     Return: void
     Descripcion: obtiene el nombre y extension del archivo
     ************************/
    private static void datosArchivo() {
        System.out.println("Digite nombre");
        String nombre = read.next();

        int extension = 0;
        do{
            System.out.println("Seleccione la extension");
            System.out.println("1- WAV");
            System.out.println("2- MP3");
            extension = read.nextInt();
        }while (extension != 1 && extension != 2);
        crearReproductor(nombre,extension);
    }

    /*************************
     Nombre: crearReproductor
     Parametros: String nombre que es el nombre de la cancion, int extension que es la extension que el usuario escogio
     Return: void
     Descripcion: obtiene el nombre y extension del archivo
     ************************/
    private static void crearReproductor(String nombre, int extension) {
        Reproductor reproductor = null;
        String exten = "";
        if(extension == 1){
            reproductor = new ReproductorWAV();
            exten = "WAV";
        }
        else {
            reproductor = new ReproductorMP3Adapter();
            exten = "MP3";
        }
        reproductor.play(exten,nombre);
    }
}
