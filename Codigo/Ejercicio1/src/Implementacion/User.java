package Implementacion;

import Interfaz.IUser;
import TextReader.TextReader;

public class User implements IUser {
    private String userName;
    private String password;
    private String role;

    public User(String user, String password, String role) {
        setUser(user);
        setPassword(password);
        setRole(role);
    }

    /***
     Gets and sets
     */
    public String getUser() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /*************************
     Nombre: changePass
     Parametros: userName (String), nombre de usuario, pass(String) contraseña del usuario
     Return: String de mensaje
     Descripcion: busca a usuario por nombre y cambia contraseña
     ************************/
    public String changePass(String user, String pass) {
        setPassword(pass);
        TextReader.exportText();
        return user + "Modificado";
    }

    /*************************
     Nombre: greetUser
     Parametros:
     Return:String
     Descripcion: Saludar a usaurio conectado
     ************************/
    public String greetUser() {
        return "Hola: " + getUser() + "\n" +
                "Su role es: " + getRole();
    }

    /*************************
     Nombre: addUser
     Parametros: userName (String), nombre de usuario, pass(String) contraseña del usuario, role (String) rol de usuario
     Return: String
     Descripcion: agrega un nuevo usuario
     ************************/
    public String addUser(String user, String pass, String role) {
        User newUser = new User(user,pass,role);
        String msg = TextReader.addUser(newUser);
        TextReader.exportText(newUser.formatUserToCSV());
        return msg;
    }

    /*************************
     Nombre: formatUserToCSV
     Parametros:
     Return: String
     Descripcion: formatear objecto con ; para guardar en txt
     ************************/
    private String formatUserToCSV(){
        return userName + ";" + password + ";" + role;
    }
}
