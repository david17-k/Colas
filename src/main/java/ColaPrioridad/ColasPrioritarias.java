package ColaPrioridad;

import java.util.Iterator;

public class ColasPrioritarias <T>implements Iterable<T>{
    private Nodo<T>frente;
    private Nodo<T>fin;
    private int tamaño;

    public void encolar(T dato){
        Nodo<T>aux=new Nodo<>(dato);
        if(isEmpty()){
            frente=fin=aux;
        }else{
            fin.setSiguiente(aux);
            fin=aux;
        }
        tamaño++;

    }
    public T desencolar(){
        if(isEmpty()){
            System.out.println("No hay nada");
        }
        T dato= frente.getDato();
        frente=frente.getSiguiente();
        return dato;
    }

    public boolean isEmpty(){
        return frente==null;
    }

    public void imprimir(){
        Nodo<T>aux=frente;
        while ((aux!=null)){
            System.out.println(aux.getDato());
            aux=aux.getSiguiente();
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterador<>(frente);
    }

    public class Iterador<T>implements Iterator<T>{
        Nodo<T>nodo;
        int tamaño;

        public Iterador(Nodo<T> nodo) {
            this.nodo = nodo;
        }

        @Override
        public boolean hasNext() {
            return nodo!=null;
        }

        @Override
        public T next() {
            T dato= nodo.getDato();
            nodo=nodo.getSiguiente();
            return dato;
        }


    }


}
