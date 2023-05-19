package obligatorio2023.TADs.MyLinkedList;


import obligatorio2023.TADs.Exception.IllegalIndexException;

public class ListaDoblementeEnlazadaGenerics<T> extends MyLinkedListImp<T> implements MyLinkedList<T> {

    private Node<T> primero;
    @Override
    public Node<T> getPrimero() {
        return super.getPrimero();
    }

    @Override
    public boolean esVacia() {
        return super.esVacia();
    }

    @Override
    public void agregar(T obj) {
        super.agregar(obj);
    }

    @Override
    public void agregarAlFinal(T obj) {
        Node<T> nuevo= new Node<>(obj);
        if (this.primero==null){
            this.primero=nuevo;
        }
        else{
            Node<T> aux=this.primero;
            while(aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
        }
    }

    @Override
    public void agregar(T obj, int index) throws IllegalIndexException {
        if(index>largo()||index<0){
            throw  new IllegalIndexException("El indice es incorrecto");
        }
        else{
            Node<T> nuevo = new Node<>(obj);
            if (index == 0) {
                agregar(obj);
            } else {
                if (index == largo()) {
                    agregarAlFinal(obj);
                } else {
                    int recorre = 0;
                    Node<T> aux = this.primero;
                    while (recorre < index - 1) {
                        recorre++;
                        aux = aux.getSiguiente();

                    }

                    nuevo.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(nuevo);
                    nuevo.setAnterior(aux);
                }
            }
        }
    }

    @Override
    public int largo() {
        return super.largo();
    }

    @Override
    public T quitar(int index) {
        return super.quitar(index);
    }

    @Override
    public T elemento(int index) {
        return super.elemento(index);
    }

    @Override
    public void vaciar() {
        super.vaciar();
    }

    @Override
    public void imprimirDatos() {
        super.imprimirDatos();
    }
}
