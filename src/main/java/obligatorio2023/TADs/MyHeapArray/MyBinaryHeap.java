package obligatorio2023.TADs.MyHeapArray;

public interface MyBinaryHeap<T> {

    T getMax();
    T getMin();
    void insert(T value);
    T deleteValue(T value);
    T delete();
    int find(T value);
    public T deleteIndex(int index);

}

