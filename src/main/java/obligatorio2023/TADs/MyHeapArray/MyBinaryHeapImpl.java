package obligatorio2023.TADs.MyHeapArray;

public class MyBinaryHeapImpl<T extends Comparable<T>> implements MyBinaryHeap<T> {
    private int size = 1;
    private T[] heap;
    private boolean isMax;
    private int availableAddPos = 0;

    public MyBinaryHeapImpl(boolean isMax) {
        this.isMax = isMax;
        this.heap=(T[]) new Comparable[size];
    }

    @Override
    public void insert(T value) {
        if (availableAddPos==0){
            this.heap[0]=value;
        }else if(this.heap[size-1]!=null){
            this.addSize();
        }
        if(this.isMax==true){
            this.heap[this.availableAddPos]=value;
            int fPos = fatherPos(this.availableAddPos);
            T fValue=this.heap[fPos];
            if(value.compareTo(fValue)>0){
                elevateValueMax(value,this.availableAddPos, fValue, fPos);
            }
        }


    }
    public void elevateValueMax(T value, int valuePos, T fValue, int fPos){
        this.heap[valuePos]=fValue;
        this.heap[fPos]=value;
        int newFatherPos = fatherPos(fPos);
        T newFatherValue = this.heap[newFatherPos];
        if(value.compareTo(newFatherValue)>0){
            elevateValueMax(value,fPos,newFatherValue,newFatherPos);
        }
    }


    public void addSize(){
        T[] old = this.heap;
        this.heap = (T[]) new Comparable[this.size * 2];
        System.arraycopy(old, 1, this.heap, 1, size);
    }

    public int fatherPos(int pos){
        return (pos-1)/2;
    }

    @Override
    public T eliminar(T value) {
        return null;
    }

    @Override
    public T getMax() {
        if(this.isMax==true){
            return this.heap[0];
        }
        return null;
    }

    @Override
    public T deleteMax() {
        return null;
    }
}
