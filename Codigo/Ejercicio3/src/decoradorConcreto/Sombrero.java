package decoradorConcreto;

import componente.BaseImagen;
import decorador.ObjectoDecorador;

public class Sombrero extends ObjectoDecorador {

    public Sombrero(BaseImagen imagen) {
        this.baseImagen = imagen;
    }

    /*************************
     Nombre: getNombre
     Parametros:
     Return: String
     Descripcion: obtiene el nombre
     ************************/
    @Override
    public String getNombre() {
        return this.baseImagen.getNombre() + " con sombrero";
    }

    /*************************
     Nombre: obtnerNombre
     Parametros:
     Return: String
     Descripcion: obtiene el nombre atributo
     ************************/
    @Override
    public String obtnerNombre() {
        return baseImagen.obtnerNombre();
    }
}
