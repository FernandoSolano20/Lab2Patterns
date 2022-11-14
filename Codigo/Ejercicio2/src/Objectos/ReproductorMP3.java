package Objectos;

public class ReproductorMP3 {
    private String tipoMotor= "MP3";

    public ReproductorMP3() {
        System.out.println("Creando reproductor mp3");
    }

    /*************************
     Nombre: reproducir
     Parametros: String audioType que es la extension que el usuario escogio, String fileName que es el nombre de la cancion
     Return: void
     Descripcion: reproduce la cancion en un reproductor mp3
     ************************/
    public void reproducir(String audioType, String fileName){
        System.out.println("Reproduciendo cancion en mp3");
        System.out.println("Reproducinedo " + fileName + "\n" +
                "De tipo: " + audioType);
    }
}
