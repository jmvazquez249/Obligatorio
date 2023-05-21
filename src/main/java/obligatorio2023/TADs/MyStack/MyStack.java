package obligatorio2023.TADs.MyStack;

import obligatorio2023.Exception.EmptyStackException;

public interface MyStack<T>{
    void push(T dato);
    T pop() throws EmptyStackException;
    T top();
    boolean esVacia();
    void vaciar();
}
