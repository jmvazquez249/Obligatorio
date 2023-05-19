package obligatorio2023.tad.pila;

import obligatorio2023.tad.exceptions.EmptyStackException;
import um.prog2.tad.exceptions.EmptyStackException;

public interface Pila <T>{
    public void push(T dato);
    // servira para agregar datos a la pila
    public T pop() throws EmptyStackException, EmptyStackException;
    //quita el elemento superior elementos de la pila
    public T top();
    // devuelve el elemento superior de la pila
    public boolean isEmpty();
    //devuelve si es vacia
    public void clear();
    //vacia la pila

}
