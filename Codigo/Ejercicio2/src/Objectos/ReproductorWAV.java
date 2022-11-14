package Objectos;

public class ReproductorWAV extends Reproductor {
    public ReproductorWAV() {
        tipoReproductor = "Reproductor WAV";
        System.out.println("Creando reproductor WAV");
    }

    /*************************
     Nombre: play
     Parametros: String audioType que es la extension que el usuario escogio, String fileName que es el nombre de la cancion
     Return: void
     Descripcion: reproduce la cancion en un reproductor WAV
     ************************/
    @Override
    public void play(String audioType, String fileName) {
        System.out.println("Reproducinedo " + fileName + "\n" +
                "De tipo: " + audioType);
    }
}
