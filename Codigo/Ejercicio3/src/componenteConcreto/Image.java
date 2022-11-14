package componenteConcreto;

import componente.BaseImagen;

public class Image extends BaseImagen {
    protected String nombre;
    public Image(String nombre) {
        setNombre(nombre);
    }

    /***
     *Set nombre
     ***/
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*************************
     Nombre: obtnerNombre
     Parametros:
     Return: String
     Descripcion: obtiene el nombre atributo
     ************************/
    @Override
    public String obtnerNombre() {
        return nombre;
    }

    /*************************
     Nombre: getNombre
     Parametros:
     Return: String
     Descripcion: obtiene el nombre
     ************************/
    @Override
    public String getNombre() {
        return "Imagen: " + nombre;
    }
}
