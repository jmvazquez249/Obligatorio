package obligatorio2023.TADs.MySearchBinaryTree;

public class MySearchBinaryTreeImp<K extends Comparable<K>,T> implements MySearchBinaryTree<K,T> {
    public MySearchBinaryTreeImp() {
    }

    NodeTree<K,T> raiz;
    @Override
    public T find(K key) {
        if(raiz==null){
        return null;}
        return raiz.find(key);
    }

    @Override
    public void insert(K key, T data) {
        if (raiz==null){
            this.raiz = new NodeTree(key,data);
        }else{
            raiz.insert(key,data);
        }
    }

    @Override
    public void delete(K key) {
        if (raiz!=null){
            raiz=raiz.delete(key);
        }
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

}
