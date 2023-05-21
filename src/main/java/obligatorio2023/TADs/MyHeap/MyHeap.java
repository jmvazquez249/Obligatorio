package obligatorio2023.TADs.MyHeap;

import obligatorio2023.TADs.MyLinkedList.Node;

public interface MyHeap<T> {

    public T getMax();
    public T extraerMax();
    public void insert(T value);

}

