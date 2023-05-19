package obligatorio2023.TADs.MySearchBinaryTree;

public class MySearchBinaryTreeImp<K,T> implements MySearchBinaryTree<K,T> {
    NodeTree<K,T> raiz;
    @Override
    public T find(K key) {
        if(raiz==null){
        return null;}
        return raiz.find(key);
    }

    @Override
    public void insert(K key, T data, K parentKey) {

    }

    @Override
    public void delete(K key) {

    }

    @Override
    public int size() {
        if (raiz==null){
                return 0;
        }
        else{
            return raiz.size();
        }
    }

    @Override
    public int countLeaf() {
        if(raiz==null){
        return 0;}
        else{
            return raiz.countLeaf();
        }
    }

    @Override
    public int countCompleteElements() {
        if(raiz==null){
            return 0;
        }
        else
            return raiz.countCompleteElements();
    }
}
