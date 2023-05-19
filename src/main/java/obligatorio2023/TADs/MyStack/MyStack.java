package obligatorio2023.TADs.MyStack;

import obligatorio2023.Exception.EmptyStackException;

public interface MyStack<T>{
    public void push(T dato);
    public T pop() throws EmptyStackException, EmptyStackException;
    public T top();
    public boolean isEmpty();
    public void clear();
}
