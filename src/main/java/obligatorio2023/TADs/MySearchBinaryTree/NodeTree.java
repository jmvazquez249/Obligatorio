package obligatorio2023.TADs.MySearchBinaryTree;

public class NodeTree<K extends Comparable<K>, T> {
    K key;
    T data;
    NodeTree<K, T> leftChild;
    NodeTree<K, T> rightChild;

    public NodeTree(K key, T data) {
        this.key = key;
        this.data = data;
    }

    public K getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public T find(K Key) {
        if (this.key.compareTo(Key)==0) {
            return this.data;
        }
        if(this.key.compareTo(Key)>0 && rightChild!=null){
            return rightChild.find(Key);
        }
        if(this.key.compareTo(Key)<0 && leftChild!=null){
            return leftChild.find(Key);
        }
        return null;
    }

    int size() {
        int tizq = 0;
        int tder = 0;
        if (leftChild != null) {
            tizq = leftChild.size();
        }
        if (rightChild != null) {
            tder = rightChild.size();
        }
        return tder + tizq + 1;
    }

    int countLeaf() {
        if (leftChild == null && leftChild == null) {
            return 1;
        }
        int leafsizq = 0;
        int leafsder = 0;
        if (leftChild != null) {
            leafsizq = leftChild.countLeaf();
        }
        if (rightChild != null) {
            leafsder = rightChild.countLeaf();
        }
        return leafsizq + leafsder;
    }

    public void insert(K Key, T data) {
        if(this.key.compareTo(Key)>0){
            if (this.rightChild!=null) {
                rightChild.insert(Key, data);
            }else{
                this.rightChild= new NodeTree<>(Key,data);
            }
        }
        if(this.key.compareTo(Key)<0){
            if (this.leftChild!=null) {
                leftChild.insert(Key, data);
            }else{
                this.leftChild= new NodeTree<>(Key,data);
            }
        }
    }
    public NodeTree<K,T> delete(K key){
        NodeTree<K,T> nodeToDelete = this;
        if(this.key.compareTo(key)>0){
            if (rightChild!=null){
                rightChild=rightChild.delete(key);
            }
        }else if (key.compareTo(this.key)<0){
            if(leftChild!=null){
                leftChild=leftChild.delete(key);
            }
        }else if (leftChild!=null && rightChild!=null){
            NodeTree<K, T> min = rightChild.findMin();
            this.key = min.getKey();
            this.data = min.getData();
            rightChild = rightChild.delete(min.getKey());
        }else{
            if (leftChild != null) {
                nodeToDelete = leftChild;
            } else {
                nodeToDelete = rightChild;
            }

        }
        return nodeToDelete;
    }
    public NodeTree<K,T> findMin() {
        NodeTree<K,T> m = this;
        if (leftChild != null) {
            m = leftChild.findMin();
        }
        return m;
    }

}
