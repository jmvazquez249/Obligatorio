package obligatorio2023.TADs.MyHeapArray;

public interface MyBinaryHeap<T> {

    T getMax();
    T getMin();
    void insert(T value);
    T delete(T value);
    T delete();
    int find(T value);

}

