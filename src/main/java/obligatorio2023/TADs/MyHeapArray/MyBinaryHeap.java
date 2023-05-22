package obligatorio2023.TADs.MyHeapArray;

public interface MyBinaryHeap<T> {

    T getMax();
    T deleteMax();

    void insert(T value);
    T eliminar(T value);

}

