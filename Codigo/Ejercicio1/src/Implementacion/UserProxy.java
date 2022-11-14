package Implementacion;

import Interfaz.IUser;
import TextReader.TextReader;

public class UserProxy implements IUser {

    private TextReader textReader = new TextReader();
    private User user = null;

    /*************************
     Nombre : getUser
     Parametros: userName (String), nombre de usuario, pass(String) contraseña del usuario
     Return: boolean
     Descripcion: Metodo para saber si un usuario existe y saber si la contraseña que digito es igual para darle accesso al sistema
     ************************/
    public boolean getUser(String userName, String pass){
        boolean result = false;
        this.user = searchUser(userName);
        if (this.user != null && this.user.getPassword().equals(pass)){
            result = true;
        }
        return result;
    }

    /*************************
     Nombre: changePass
     Parametros: userName (String), nombre de usuario, pass(String) contraseña del usuario
     Return: String de mensaje
     Descripcion: busca a usuario por nombre y llama al metodo del usaurio para cambiar la contraseña
     ************************/
    @Override
    public String changePass(String userName, String pass) {
        String msg = null;
        if(this.user.getRole().equals("admin")){
            User user = searchUser(userName);
            if(user != null){
                msg = user.changePass(userName, pass);
            }
            else {
                msg = "No se encontro un usuario";
            }
        }
        else if (this.user.getUser().equals(userName)){
            this.user.changePass(userName,pass);
            msg = "Modificado";
        }
        else {
            msg = "Usuario sin permisos";
        }
        return msg;
    }

    /*************************
     Nombre: searchUser
     Parametros: userName(String) nombre usuario
     Return: User
     Descripcion: retorna un usuario por el nombre
     ************************/
    private User searchUser(String userName){
        User u = null;
        for (User user:textReader.getUsers()) {
            if(userName.equals(user.getUser())){
                u = user;
            }
        }
        return u;
    }

    /*************************
     Nombre: greetUser
     Parametros:
     Return:String
     Descripcion: Saludar a usuario conectado si tiene permisos
     ************************/
    @Override
    public String greetUser() {
        String msg = null;
        if (this.user == null){
            msg = "Usuario sin permisos";
        }
        else{
            msg = this.user.greetUser();
        }
        return msg;
    }

    /*************************
     Nombre: addUser
     Parametros: userName (String), nombre de usuario, pass(String) contraseña del usuario, role (String) rol de usuario
     Return: String
     Descripcion: agrega un nuevo usuario si es un usuario administrador
     ************************/
    @Override
    public String addUser(String user, String pass, String role){
        String msg = null;
        if(this.user.getRole().equals("admin")){
            this.user.addUser(user,pass,role);
            msg = "Usuario agregado";
        }
        else {
            msg = "Usuario sin permisos";
        }
        return msg;
    }
}
