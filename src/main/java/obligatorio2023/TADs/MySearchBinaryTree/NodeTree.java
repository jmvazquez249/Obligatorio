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

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeTree<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeTree<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodeTree<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeTree<K, T> rightChild) {
        this.rightChild = rightChild;
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

    public NodeTree<K,T> findNode(K Key){
        if (this.key.compareTo(Key)==0) {
            return this;
        }
        if(this.key.compareTo(Key)>0 && rightChild!=null){
            return (NodeTree<K,T>) rightChild.find(Key);
        }
        if(this.key.compareTo(Key)<0 && leftChild!=null){
            return (NodeTree<K,T>) leftChild.find(Key);
        }
        return null;
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
    public void delete(K key){
        NodeTree<K,T> nodeToDelete = findNode(key);
        if (nodeToDelete.leftChild==null && nodeToDelete.rightChild==null){
            nodeToDelete=null;
        }else {
            NodeTree<K, T> min = rightChild.findMin();
            this.key = min.getKey();
            this.data = min.getData();
            rightChild.delete(min.getKey());
        }
    }
    public NodeTree<K,T> findMin() {
        NodeTree<K,T> m = this;
        if (leftChild != null) {
            m = leftChild.findMin();
        }
        return m;
    }

}
