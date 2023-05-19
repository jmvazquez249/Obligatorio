package obligatorio2023.TADs.MySearchBinaryTree;

public interface MySearchBinaryTree<K extends Comparable<K>,T>{
    T find(K key);
    void insert (K key, T data);
    void delete (K key);
    int size();
    int countLeaf();
    NodeTree<K,T> findNode(K key);

}