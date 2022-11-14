package Adaptador;

import Objectos.Reproductor;
import Objectos.ReproductorMP3;

public class ReproductorMP3Adapter extends Reproductor {
    private ReproductorMP3 reproductorMP3;

    public ReproductorMP3Adapter() {
        this.reproductorMP3 = new ReproductorMP3();
        tipoReproductor = "Adaptador Reproductor MP3";
    }

    public ReproductorMP3Adapter(ReproductorMP3 reproductorMP3) {
        this.reproductorMP3 = reproductorMP3;
        tipoReproductor = "Adaptador Reproductor MP3";
    }

    /*************************
     Nombre: play
     Parametros: String audioType que es la extension que el usuario escogio, String fileName que es el nombre de la cancion
     Return: void
     Descripcion: adapta el reproductor de mp3 para que se pueda en un mp3
     ************************/
    @Override
    public void play(String audioType, String fileName) {
        System.out.println("Reproduciendo en adaptador de mp3");
        reproductorMP3.reproducir(audioType,fileName);

    }
}
