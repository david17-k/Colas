package ColaPrioridad;

public class ListaSimple <T>{
    private Nodo<T>siguiente;
    private int tamaño;

    public void agregar(T dato){
        Nodo<T>nodo=new Nodo<>(dato);
        if(siguiente==null){
            siguiente=nodo;
        }else{
            nodo.setSiguiente(siguiente);
            siguiente=nodo;
        }
        tamaño++;
    }
}
