package compositor.componentes;

import compositor.base.IDrive;

import java.util.ArrayList;

public class Carpeta extends IDrive {
    private ArrayList<IDrive> elementos;
    private String nombre;

    public Carpeta(String nombre, IDrive parent) {
        super(parent);
        elementos = new ArrayList<>();
         setNombre(nombre);
    }

    /***
     *
     * Gets y sets
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     Nombre: agregarElemento
     Parametros: IDrive drive
     Return: void
     Descripcion: metodo que agrega elemento como hijo de la carpeta
     ************************/
    @Override
    public void agregarElemento(IDrive drive) {
        elementos.add(drive);
    }

    /*************************
     Nombre: buscarCarpeta
     Parametros: IDrive drive
     Return: void
     Descripcion: metodo que busca carpetas dentro de la carpeta
     ************************/
    @Override
    public IDrive buscarCarpeta(String nombre){
        IDrive ele = null;
        for (IDrive elemento:elementos) {
            if(elemento instanceof Carpeta){
                if(elemento.getNombre().equals(nombre)){
                    ele = elemento;
                    break;
                }
                else {
                    ele = ((Carpeta) elemento).buscarCarpeta(nombre);
                    if(ele != null){
                        break;
                    }
                }
            }
        }
        return ele;
    }

    /*************************
     Nombre: buscarArchivo
     Parametros: IDrive drive
     Return: void
     Descripcion: metodo que busca archivos dentro de la carpeta
     ************************/
    @Override
    public IDrive buscarArchivo(String nombre){
        IDrive ele = null;
        for (IDrive elemento:elementos) {
            if(elemento instanceof Archivo && elemento.getNombre().equals(nombre)){
                ele = elemento;
                break;
            }
            else if(elemento instanceof Carpeta){
                ele = ((Carpeta) elemento).buscarArchivo(nombre);
                if(ele != null){
                    return ele;
                }
            }
        }
        return ele;
    }

    /*************************
     Nombre: eliminarElemento
     Parametros: IDrive drive
     Return: void
     Descripcion: metodo que eliminarElemento elemento dentro de la carpeta
     ************************/
    @Override
    public void eliminarElemento(IDrive elemento){
        elementos.remove(elemento);
    }

    /*************************
     Nombre: imprimir
     Parametros: String space que es el espacio que va tener de la raiz
     Return: String
     Descripcion: imprimi la propiedades de la carpeta
     ************************/
    @Override
    public String imprimir(String space) {
        String msg = space + "Carpeta Nombre: " + getNombre() + "\n";
        for (IDrive ele:elementos) {
            msg += ele.imprimir(space + "   ");
        }
        return msg;
    }
}
