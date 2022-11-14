package Main;
import compositor.base.IDrive;
import compositor.componentes.Archivo;
import compositor.componentes.Carpeta;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<IDrive> elementos = new ArrayList<>();
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
     Nombre: mostrarMenu
     Parametros:
     Return: void
     Descripcion: muestra menu
     ************************/
    private static void mostrarMenu() {
        int opc = 0;
        do{
            System.out.println("Digite lo que desea");
            System.out.println("1- Crear archivo");
            System.out.println("2- Crear carpeta");
            System.out.println("3- Mover elementos");
            System.out.println("4- Mostrar elementos");
            System.out.println("5- Buscar elementos");
            System.out.println("6- Salir");

            opc = read.nextInt();
            procesarOpc(opc);
        }while (opc != 6);
    }

    /*************************
     Nombre: processOpc
     Parametros: opc int opcion del usuario
     Return: void
     Descripcion: procesa la opcion del usuario
     ************************/
    private static void procesarOpc(int opc) {
        switch (opc){
            case 1:
                crearArchivo();
                break;

            case 2:
                crearCarpeta();
                break;

            case 3:
                mover();
                break;

            case 4:
                mostrarElementos();
                break;

            case 5:
                System.out.println(buscarArchivo().imprimir(""));
                break;

            case 6:
                System.out.println("Saliendo");
                break;

            default:
                System.out.println("No valido");
                break;
        }
    }

    /*************************
     Nombre: mostrarElementos
     Parametros:
     Return: void
     Descripcion: muestra todos los elemntos en drive
     ************************/
    private static void mostrarElementos() {
        for (IDrive ele:elementos) {
            System.out.println(ele.imprimir(""));
        }
    }

    /*************************
     Nombre: mover
     Parametros:
     Return: void
     Descripcion: mueve un elemento (carpeta o archivo) a una carpeta en especifico
     ************************/
    private static void mover() {
        System.out.println("Digite el nombre de carpeta");
        String nombre = read.next();

        System.out.println("Digite el nombre de lo que va a mover");
        String file = read.next();

        IDrive archivo = buscarElemento(file);
        IDrive carpeta = buscarCarpeta(nombre);
        if(carpeta != null && archivo != null){
            IDrive parent = setParent(archivo,carpeta);
            carpeta.agregarElemento(archivo);
            if(parent == null){
                elementos.remove(archivo);
            }
            else {
                parent.eliminarElemento(archivo);
            }

        }
    }

    /*************************
     Nombre: setParent
     Parametros: IDrive archivo o elemento que se va a mover , IDrive carpeta
     Return: IDrive
     Descripcion: obtiene la carpeta papa del elemnto que se quiere mover, se la coloca en el atributo parent
     si la funcion retorna null significa que el elemento se encuentra en la raiz del directorio
     ************************/
    private static IDrive setParent(IDrive archivo, IDrive carpeta) {
        IDrive elemento = (archivo);
        IDrive parent = elemento.getParent();
        elemento.setParent(carpeta);
        return parent;
    }

    /*************************
     Nombre: crearCarpeta
     Parametros:
     Return: void
     Descripcion: crea una nueva carpeta en la raiz
     ************************/
    private static void crearCarpeta() {
        String nombre = nameFile();

        IDrive elemento = new Carpeta(nombre,null);
        elementos.add(elemento);
    }

    /*************************
     Nombre: crearArchivo
     Parametros:
     Return: void
     Descripcion: crea un nuevo archivo en la raiz
     ************************/
    private static void crearArchivo() {
        String nombre = nameFile();

        System.out.println("Digite la extension");
        String extension = read.next();

        IDrive elemento = new Archivo(nombre,extension,null);
        elementos.add(elemento);
    }

    /*************************
     Nombre: nameFile
     Parametros:
     Return: String
     Descripcion: pide el nombre del archivo
     ************************/
    private static String nameFile(){
        System.out.println("Digite el nombre");
        return read.next();
    }

    /*************************
     Nombre: buscarArchivo
     Parametros:
     Return: IDrive
     Descripcion: busca el archivo en la raiz o mas adentro de la raiz
     ************************/
    private static IDrive buscarArchivo(){
        String nombre = nameFile();
        IDrive e = null;
        for (IDrive ele:elementos) {
            if (ele instanceof Archivo) {
                if(nombre.equals(ele.getNombre())){
                    e = ele;
                    break;
                }
            }
            else if (ele instanceof Carpeta){
                e = ele.buscarArchivo(nombre);
                if(e != null){
                    break;
                }
            }
        }
        return e;
    }

    /*************************
     Nombre: buscarCarpeta
     Parametros: String nombre de la carpeta
     Return: IDrive
     Descripcion: busca la carpeta en la raiz o mas adentro de la raiz
     ************************/
    private static IDrive buscarCarpeta(String nombre){
        IDrive ele = null;
        for (IDrive elemento:elementos) {
            if (elemento instanceof Carpeta){
                if(elemento.getNombre().equals(nombre)){
                    ele = elemento;
                    break;
                }
                else {
                    ele = elemento.buscarCarpeta(nombre);
                    if(ele != null){
                        break;
                    }
                }
            }
        }
        return ele;
    }

    /*************************
     Nombre: buscarElemento
     Parametros: String nombre la carpeta o archivo
     Return: IDrive
     Descripcion: busca un archivo o carpeta en la raiz o mas adentro de la raiz
     ************************/
    private static IDrive buscarElemento(String nombre){
        IDrive ele = null;
        for (IDrive elemento:elementos) {
            if (elemento instanceof Carpeta){
                if(elemento.getNombre().equals(nombre)){
                    ele = elemento;
                    break;
                }
                else {
                    ele = elemento.buscarCarpeta(nombre);
                    if(ele != null){
                        break;
                    }
                    else {
                        ele = elemento.buscarArchivo(nombre);
                        if (ele != null){
                            break;
                        }
                    }
                }
            }
            else if (elemento.getNombre().equals(nombre)){
                ele = elemento;
                break;
            }
        }
        return ele;
    }
}
