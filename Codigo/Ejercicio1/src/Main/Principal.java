package Main;

import Implementacion.UserProxy;

import java.util.Scanner;

public class Principal {
    private static Scanner read = new Scanner(System.in);
    private static UserProxy userProxy = new UserProxy();

    /*************************
     Nombre: main
     Parametros: String[] args, arguementos
     Return: void
     Descripcion: programa principal
     ************************/
    public static void main(String[] args) {
        int opc = 0;
        do{
            getCredentials();
            System.out.println("Quiere salir?");
            System.out.println("1- Si");
            System.out.println("2- No");
            opc = read.nextInt();
        }while (opc != 1);
    }

    /*************************
     Nombre: getCredentials
     Parametros:
     Return: void
     Descripcion: credenciales de usuario
     ************************/
    private static void getCredentials() {
        System.out.println("Digite el usuario");
        String user = read.next();

        System.out.println("Digite la contraseña");
        String pass = read.next();

        boolean isUserExists = userProxy.getUser(user,pass);

        if (isUserExists){
            showMenu();
        }
    }

    /*************************
     Nombre: showMenu
     Parametros:
     Return: void
     Descripcion: muesta menu
     ************************/
    private static void showMenu() {
        int opc = 0;
        do{
            System.out.println("1- Cambiar su contraseña.");
            System.out.println("2- Saludar al usuario conectado");
            System.out.println("3- Agregar un nuevo usuario");
            System.out.println("4- Salir");
            opc = read.nextInt();

            processOpc(opc);
        }while (opc != 4);
    }

    /*************************
     Nombre: processOpc
     Parametros: opc int opcion del usuario
     Return: void
     Descripcion: procesa la opcion del usuario
     ************************/
    private static void processOpc(int opc) {
        switch (opc){
            case 1:
                changePass();
                break;

            case 2:
                System.out.println(userProxy.greetUser());
                break;

            case 3:
                addUser();
                break;

            case 4:
                System.out.println("Saliendo");
                break;

            default:
                System.out.println("No valido");
                break;
        }
    }

    /*************************
     Nombre: addUser
     Parametros:
     Return: void
     Descripcion: agrega usaurio
     ************************/
    private static void addUser() {
        System.out.println("Digite el usuario");
        String user = read.next();

        System.out.println("Digite la contraseña");
        String pass = read.next();

        System.out.println("Digite el role");
        String role = read.next().toLowerCase();

        System.out.println(userProxy.addUser(user,pass,role));
    }

    /*************************
     Nombre: changePass
     Parametros:
     Return: void
     Descripcion: cambia contraseña usaurio
     ************************/
    private static void changePass() {
        System.out.println("Digite el usuario");
        String user = read.next();

        System.out.println("Digite la contraseña");
        String pass = read.next();

        System.out.println(userProxy.changePass(user,pass));
    }
}
