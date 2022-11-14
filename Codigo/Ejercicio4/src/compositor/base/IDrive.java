package compositor.base;

public abstract class IDrive {
    private IDrive parent;

    public IDrive(IDrive parent) {
        setParent(parent);
    }

    /*************************
     Nombre: getParent
     Parametros:
     Return: IDrive
     Descripcion: padre del objecto
     ************************/
    public IDrive getParent() {
        return parent;
    }

    /*************************
     Nombre: setParent
     Parametros: IDrive parent que es el papa del objeto
     Return: void
     Descripcion: set padre del objecto
     ************************/
    public void setParent(IDrive parent) {
        this.parent = parent;
    }

    /***
     *
     * Funciones que se implementan en los hijos
     */
    public abstract String getNombre();
    public abstract void agregarElemento(IDrive drive);
    public abstract String imprimir(String space);

    /***
     * Funciones no implementadas en clase abstracta
     */

    public IDrive buscarCarpeta(String nombre){
        System.out.println("No implementada");
        return null;
    }

    public IDrive buscarArchivo(String nombre){
        System.out.println("No implementada");
        return null;
    }

    public void eliminarElemento(IDrive elemento){
        System.out.println("No implementada");
    }
}
