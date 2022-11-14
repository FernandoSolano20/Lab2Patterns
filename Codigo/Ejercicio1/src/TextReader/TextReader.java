package TextReader;

import Implementacion.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
    private static List<User> users = new ArrayList<>();

    /*************************
     Nombre: importText
     Parametros:
     Return: List<User>
     Descripcion: importa el txt table_user y retorna una lista de usuarios
     ************************/
    public List<User> importText(){

        List<User> myList = new ArrayList<User>();
        try
        {
            FileInputStream fin = new FileInputStream("C:\\Users\\fersolano\\Desktop\\Lab#2\\Ejercicio1\\table_user.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            br.readLine();
            int index1 = 0;
            String[] user = new String[3];
            String line = null;
            while ((line = br.readLine()) != null)
            {
                user = line.split(";");
                myList.add(new User(user[0],user[1],user[2]));
            }
            fin.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return myList;
    }

    /*************************
     Nombre: exportText
     Parametros:
     Return: void
     Descripcion: exporta toda la lista de usuarios que se encuentre en memoria
     ************************/
    public static void exportText()
    {
        File file = null;
        FileWriter fileWriter = null;
        BufferedWriter writer = null;
        try
        {
            file = new File("C:\\Users\\fersolano\\Desktop\\Lab#2\\Ejercicio1\\table_user.txt");
            fileWriter = new FileWriter(file);
            // create file if not exists
            if (!file.exists())
            {
                file.createNewFile();
            }
            // initialize BufferedWriter
            writer = new BufferedWriter(fileWriter);
            writer.append("usuario;password;role");
            writer.append(System.getProperty("line.separator"));
            for (User user:users) {
                writer.write((user.getUser() + ";" + user.getPassword() + ";" + user.getRole()));
                writer.append(System.getProperty("line.separator"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // close BufferedWriter
            if (writer != null)
            {
                try
                {
                    writer.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            // close FileWriter
            if (fileWriter != null)
            {
                try
                {
                    fileWriter.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

    /*************************
     Nombre: exportText
     Parametros: String user, formato que ocupa usuario en txt
     Return: void
     Descripcion: escribe el usuario agregado en el txt
     ************************/
    public static void exportText(String user)
    {
        File file = null;
        FileWriter fileWriter = null;
        BufferedWriter writer = null;
        try
        {
            file = new File("C:\\Users\\fersolano\\Desktop\\Lab#2\\Ejercicio1\\table_user.txt");
            fileWriter = new FileWriter(file,true);
            // create file if not exists
            if (!file.exists())
            {
                file.createNewFile();
            }
            // initialize BufferedWriter
            writer = new BufferedWriter(fileWriter);
            writer.write(user);
            writer.append(System.getProperty("line.separator"));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // close BufferedWriter
            if (writer != null)
            {
                try
                {
                    writer.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            // close FileWriter
            if (fileWriter != null)
            {
                try
                {
                    fileWriter.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

    /*************************
     Nombre: getUsers
     Parametros:
     Return: List<User>
     Descripcion: importa toda los usurarios
     ************************/
    public List<User> getUsers(){
        return users = importText();
    }

    /*************************
     Nombre: addUser
     Parametros:user User, usuario
     Return: String
     Descripcion: agrega un usuario a la lista de usuarios
     ************************/
    public static String addUser(User user){
        users.add(user);
        return "Agregado";
    }
}
