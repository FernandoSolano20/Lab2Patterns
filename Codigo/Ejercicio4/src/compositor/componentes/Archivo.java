package compositor.componentes;

import compositor.base.IDrive;

public class Archivo extends IDrive {
    private String nombre;
    private String extension;

    public Archivo(String nombre, String extension, IDrive parent) {
        super(parent);
        setNombre(nombre);
        setExtension(extension);
    }

    /***
     *
     * Gets y sets
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    /*************************
     Nombre: getNombre
     Parametros:
     Return: String
     Descripcion: obtiene el nombre del archivo
     ************************/
    @Override
    public String getNombre() {
        return nombre;
    }

    /*************************
     Nombre: getExtension
     Parametros:
     Return: String
     Descripcion: obtiene el extension del archivo
     ************************/
    public String getExtension() {
        return extension;
    }

    /*************************
     Nombre: agregarElemento
     Parametros:
     Return: void
     Descripcion: metodo que no debe de hacer nada en archivo ya que no es implementado
     ************************/
    @Override
    public void agregarElemento(IDrive drive) {
        System.out.println("esta es una excepcion, funcion no implementada en Archivo");
    }

    /*************************
     Nombre: imprimir
     Parametros: String space que es el espacio que va tener de la raiz
     Return: String
     Descripcion: imprimi la propiedades del archivo
     ************************/
    @Override
    public String imprimir(String space) {
        return space + "Archivo Nombre: " + getNombre() + " \n" +
                space + "Archivo Extension: " +getExtension() + "\n";
    }
}
