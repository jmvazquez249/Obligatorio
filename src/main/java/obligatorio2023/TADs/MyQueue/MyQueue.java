package obligatorio2023.TADs.MyQueue;

import obligatorio2023.Exception.EmptyQueueException;

public interface MyQueue<T> {
    void enqueue (T value);
    T dequeue() throws EmptyQueueException;
    int largo();
    void vaciar();

}
