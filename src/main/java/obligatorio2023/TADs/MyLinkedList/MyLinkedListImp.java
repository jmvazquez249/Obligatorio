package obligatorio2023.TADs.MyLinkedList;


import obligatorio2023.Exception.EmptyQueueException;
import obligatorio2023.Exception.EmptyStackException;
import obligatorio2023.Exception.IllegalIndexException;
import obligatorio2023.TADs.MyQueue.MyQueue;
import obligatorio2023.TADs.MyStack.MyStack;

public class MyLinkedListImp<T> implements MyList<T>, MyStack<T>, MyQueue<T> {

    private Node<T> primero;
    private Node<T> ultimo;

    public MyLinkedListImp() {
        this.primero = null;
        this.ultimo = null;
    }

    public Node<T> getPrimero()
    {
        return this.primero;
    }

    @Override
    public boolean esVacia() {
        if (this.primero==null){
            return true;
        }
        return false;
    }

    @Override
    public void agregar(T obj) {
        Node<T> nuevo= new Node<>(obj);
        if (this.primero==null){
            this.primero=nuevo;
            this.ultimo=nuevo;
        }else {
            nuevo.setSiguiente(this.primero);
            this.primero = nuevo;
        }
    }

    @Override
    public void agregarAlFinal(T obj) {
            Node<T> nuevo= new Node<>(obj);
            if (this.esVacia()){
                this.primero=nuevo;
                this.ultimo=nuevo;
            }else {
                this.ultimo.setSiguiente(nuevo);
                this.ultimo = nuevo;
            }
        }


    @Override
    public void agregar(T obj, int index) throws IllegalIndexException
    {
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
                }
            }
        }
    }

    @Override
    public int largo(){
        Node<T> aux = this.primero;
        int largo=0;
        while (aux!=null){
            aux=aux.getSiguiente();
            largo++;
        }
        return largo;
    }

    @Override
    public T quitar(int index){
        if (!esVacia() && 0<= index && index<largo()) {
            Node<T> aux = this.primero;
            if (index==0){
                Node<T> aux2= this.primero;
                this.primero=this.primero.getSiguiente();
                return aux2.getDato();
            }

            int contador = 0;
            while (contador < index-1) {
                aux = aux.getSiguiente();
                contador++;

            }
            if (index==largo()-1){
                this.ultimo=aux;
            }
            Node<T> aux2 = aux.getSiguiente();
            aux.setSiguiente(aux2.getSiguiente());

            return aux2.getDato();
        } else {
            return null;
        }
    }

    @Override
    public T elemento(int index)  { if(-1<index && index<largo()){
        if (index==largo()-1){
            return this.ultimo.getDato();
        }
        if (index==0){
            return this.primero.getDato();
        }
        int recorre=0;
        Node<T> aux=this.primero;
        while (recorre<index){
            aux=aux.getSiguiente();
            recorre++;}
        return aux.getDato();
    }
    else{
        return null;
    }
    }

    @Override
    public void vaciar()
    {
        this.primero=null;
        this.ultimo=null;
    }

    @Override
    public void imprimirDatos()
    {
        if (!esVacia()) {
            Node<T> aux = this.primero;
            int recorre = 0;
            while(recorre<largo()){
                System.out.println(aux.getDato());
                aux=aux.getSiguiente();
                recorre++;
            }

        }
    }

    @Override
    public T getUltimo() {
        return this.ultimo.getDato();
    }

    @Override
    public void push(T dato) {
        agregar(dato);
    }

    @Override
    public T pop() throws EmptyStackException {
        if(esVacia())
            throw new EmptyStackException();
        else
            return quitar(0);
    }

    @Override
    public T top() {
        return getPrimero().getDato();
    }

    @Override
    public void enqueue(T value) {
        agregar(value);

    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (!esVacia()){
        return quitar(this.largo()-1);}
        else{
            throw new EmptyQueueException();
        }
    }

}
