package Objectos;

public abstract class Reproductor {

    public String tipoReproductor = "";
    /*************************
     Nombre: play
     Parametros: String audioType que es la extension que el usuario escogio, String fileName que es el nombre de la cancion
     Return: void
     Descripcion: reproduce la cancion
     ************************/
    public abstract void play(String audioType, String fileName);
}
