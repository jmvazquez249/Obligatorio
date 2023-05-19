package obligatorio2023.tad.pila;


import obligatorio2023.tad.exceptions.EmptyStackException;
import obligatorio2023.tad.listagenericos.ListaEnlazadaGenerics;

public class PilaEnlazada<T> extends ListaEnlazadaGenerics<T> implements Pila<T> {

    @Override
    public void push(T dato) {
        agregar(dato);
    }

    @Override
    public T pop() throws EmptyStackException {
        if(esVacia())
            throw new EmptyStackException();
        else
            return quitar(0);
    }

    @Override
    public T top() {
        return getPrimero().getDato();
    }

    @Override
    public boolean isEmpty() {
        return esVacia();
    }

    @Override
    public void clear() {
        vaciar();
    }
}
