package obligatorio2023.TADs.MyHeapArray;


import static java.lang.Math.floor;

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
        }else if(this.availableAddPos==this.size){
            this.addSize();
        }
        this.heap[this.availableAddPos]=value;
        int fPos = fatherPos(this.availableAddPos);
        T fValue=this.heap[fPos];
        if(this.isMax){
            if(value.compareTo(fValue)>0){
                elevateValue(this.availableAddPos);
            }
        }else{
            if(value.compareTo(fValue)<0){
                elevateValue(this.availableAddPos);
            }
        }
        this.availableAddPos++;


    }
    public void elevateValue(int valuePos){
        int fPos = fatherPos(valuePos);
        T value = this.heap[valuePos];
        T fValue = this.heap[fPos];
        this.heap[valuePos]=fValue;
        this.heap[fPos]=value;
        int newFatherPos = fatherPos(fPos);
        T newFatherValue = this.heap[newFatherPos];
        if(this.isMax){
            if(value.compareTo(newFatherValue)>0){
                elevateValue(fPos);
            }
        }else{
            if(value.compareTo(newFatherValue)<0){
                elevateValue(fPos);
            }
        }

    }


    public void addSize(){
        T[] old = this.heap;
        T[] nuevo = (T[]) new Comparable[this.size * 2];
        for (int i=0;i<this.size;i++){
            nuevo[i]=old[i];
        }
        this.heap=nuevo;
        this.size=this.size*2;
    }

    public int fatherPos(int childPos){
        return (int) floor((childPos-1)/2);
    }
    public int leftChildPos(int fatherPos){
        return 2*fatherPos+1;
    }
    public int rightChildPos(int fatherPos){
        return 2*fatherPos+2;
    }
    @Override
    public T delete(){
        return delete(this.heap[0]);
    }
    @Override
    public T delete(T value) {
        if(availableAddPos==1){
            this.heap[0]=null;
        }else{
            int pDelete = find(value);
            T lastValue = this.heap[availableAddPos - 1];
            this.heap[pDelete] = lastValue;
            this.heap[availableAddPos - 1] = null;
            lowerValue(pDelete);
        }
        availableAddPos--;
        return value;
    }
    public void lowerValue(int pDelete){
        T valueLeftChild;
        T valueRightChild;
        if(leftChildPos(pDelete)>=this.size){
            valueLeftChild=null;
            valueRightChild=null;
        }else if(rightChildPos(pDelete)>=this.size) {
            valueRightChild = null;
            valueLeftChild = this.heap[leftChildPos(pDelete)];
        }else {
            valueLeftChild = this.heap[leftChildPos(pDelete)];
            valueRightChild = this.heap[rightChildPos(pDelete)];
        }
        T value = this.heap[pDelete];
        if(this.isMax) {
            if (valueRightChild != null) {
                if (!(this.heap[pDelete].compareTo(valueLeftChild) > 0 && this.heap[pDelete].compareTo(valueRightChild) > 0)) {
                    if (this.heap[leftChildPos(pDelete)].compareTo(this.heap[rightChildPos(pDelete)]) < 0) {
                        int posChild = rightChildPos(pDelete);
                        T valueChild = this.heap[posChild];
                        this.heap[pDelete] = valueChild;
                        this.heap[posChild] = value;
                        lowerValue(posChild);
                    } else {
                        int posChild = leftChildPos(pDelete);
                        T valueChild = this.heap[posChild];
                        this.heap[pDelete] = valueChild;
                        this.heap[posChild] = value;
                        lowerValue(posChild);
                    }
                }
            } else if (valueLeftChild != null) {
                if (this.heap[pDelete].compareTo(valueLeftChild) < 0) {
                    int posChild = leftChildPos(pDelete);
                    T valueChild = this.heap[posChild];
                    this.heap[pDelete] = valueChild;
                    this.heap[posChild] = value;
                    lowerValue(posChild);
                }
            }
        }else{
            if (valueRightChild != null) {
                if (!(this.heap[pDelete].compareTo(valueLeftChild) < 0 && this.heap[pDelete].compareTo(valueRightChild) < 0)) {
                    if (this.heap[leftChildPos(pDelete)].compareTo(this.heap[rightChildPos(pDelete)]) > 0) {
                        int posChild = rightChildPos(pDelete);
                        T valueChild = this.heap[posChild];
                        this.heap[pDelete] = valueChild;
                        this.heap[posChild] = value;
                        lowerValue(posChild);
                    } else {
                        int posChild = leftChildPos(pDelete);
                        T valueChild = this.heap[posChild];
                        this.heap[pDelete] = valueChild;
                        this.heap[posChild] = value;
                        lowerValue(posChild);
                    }
                }
            } else if (valueLeftChild != null) {
                if (this.heap[pDelete].compareTo(valueLeftChild) > 0) {
                    int posChild = leftChildPos(pDelete);
                    T valueChild = this.heap[posChild];
                    this.heap[pDelete] = valueChild;
                    this.heap[posChild] = value;
                    lowerValue(posChild);
                }
            }
        }
    }

    @Override
    public T getMax() {
        if(this.isMax) {
            return this.heap[0];
        }
        return null;

    }
    @Override
    public T getMin(){
        if(!this.isMax) {
            return this.heap[0];
        }
        return null;
    }

    public int find(T value){
        for (int i=0; i<availableAddPos; i++){
            if(this.heap[i]==value){
                return i;
            }
        }
        return -1;
    }
}
