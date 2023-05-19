package obligatorio2023.TADs.MySearchBinaryTree;

public class NodeTree<K, T> {
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

    T find(K KeyToFind){
        if (this.getKey()==KeyToFind){
            return this.getData();
        }

        if ( rightChild!=null &&rightChild.find(KeyToFind)!=null){
            return rightChild.find(KeyToFind);
        }
        if (leftChild!=null && leftChild.find(KeyToFind)!=null){
            return leftChild.find(KeyToFind);
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

    int countCompleteElements() {
        if(leftChild==null || rightChild==null){
            return 0;
        }
        return leftChild.countCompleteElements()+ rightChild.countCompleteElements()+1;

    }
}
