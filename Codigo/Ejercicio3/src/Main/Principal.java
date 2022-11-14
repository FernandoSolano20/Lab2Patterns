package Main;

import componente.BaseImagen;
import componenteConcreto.Image;
import decoradorConcreto.Anteojos;
import decoradorConcreto.Bigote;
import decoradorConcreto.Sombrero;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<BaseImagen> images = new ArrayList<>();
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
            System.out.println("1.Crear imagen");
            System.out.println("2.Agregar anteojos");
            System.out.println("3.Agregar bigote");
            System.out.println("4.Agregar sombrero");
            System.out.println("5.Ver imagenes");
            System.out.println("6.Salir");
            System.out.println("Digite la opcion");
            opc = read.nextInt();
            procesarOpcion(opc);
        }while (opc != 6);
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
                crearImagen();
                break;

            case 2:
                agregarAnteojos();
                break;

            case 3:
                agregarBigote();
                break;

            case 4:
                agregarSombrero();
                break;

            case 5:
                listarImagenes();
                break;

            case 6:
                System.out.println("Salir");
                break;

            default:
                System.out.println("No valido");
                break;
        }
    }

    /*************************
     Nombre: listarImagenes
     Parametros:
     Return: void
     Descripcion: listar imagenes en el array
     ************************/
    private static void listarImagenes() {
        for (BaseImagen image:images) {
            printImage(image);
        }
    }

    /*************************
     Nombre: agregarSombrero
     Parametros:
     Return: void
     Descripcion: agregar sombrero a objeto imagen
     ************************/
    private static void agregarSombrero() {
        String nombre = pedirNombre();
        int index = buscarImagen(nombre);
        if(index != -1){
            BaseImagen image = images.get(index);
            image = new Sombrero(image);
            images.set(index, image);
            printImage(image);
        }
    }

    /*************************
     Nombre: agregarBigote
     Parametros:
     Return: void
     Descripcion: agregar bigote a objeto imagen
     ************************/
    private static void agregarBigote() {
        String nombre = pedirNombre();
        int index = buscarImagen(nombre);
        if(index != -1){
            BaseImagen image = images.get(index);
            image = new Bigote(image);
            images.set(index, image);
            printImage(image);
        }
    }

    /*************************
     Nombre: agregarAnteojos
     Parametros:
     Return: void
     Descripcion: agregar anteojo a objeto imagen
     ************************/
    private static void agregarAnteojos() {
        String nombre = pedirNombre();
        int index = buscarImagen(nombre);
        if(index != -1){
            BaseImagen image = images.get(index);
            image = new Anteojos(image);
            images.set(index, image);
            printImage(image);
        }
    }

    /*************************
     Nombre: crearImagen
     Parametros:
     Return: void
     Descripcion: crear objeto imagen
     ************************/
    private static void crearImagen() {
        String nombre = pedirNombre();
        if(buscarImagen(nombre) == -1){
            images.add(new Image(nombre));
        }
    }

    /*************************
     Nombre: pedirNombre
     Parametros:
     Return: void
     Descripcion: obtiene el nombre de la imagen
     ************************/
    private static String pedirNombre() {
        System.out.println("Digite el nombre");
        return read.next();
    }

    /*************************
     Nombre: buscarImagen
     Parametros: String nombre nombre la imagen
     Return: int
     Descripcion: busca en la imagenes existentes y retorna el index de la imagen y si no existe retorna -1
     ************************/
    private static int buscarImagen(String nombre){
        int index = -1;
        for (int i = 0; i < images.size(); i++) {
            if(images.get(i).obtnerNombre().equals(nombre)){
                index = i;
                break;
            }
        }
        return index;
    }

    /*************************
     Nombre: printImage
     Parametros: BaseImagen image
     Return: void
     Descripcion: obtiene el nombre de la imagen
     ************************/
    private static void printImage(BaseImagen image){
        System.out.println(image.getNombre());
    }
}
