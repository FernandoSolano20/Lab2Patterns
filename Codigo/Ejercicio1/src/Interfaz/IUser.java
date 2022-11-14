package Interfaz;

import Implementacion.User;

public interface IUser {
    public String changePass(String user, String pass);
    public String greetUser();
    public String addUser(String user, String pass, String role);
}
