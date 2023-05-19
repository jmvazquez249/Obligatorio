package obligatorio2023.TADs.MyLinkedList;


import obligatorio2023.TADs.Exception.EmptyStackException;
import obligatorio2023.TADs.Exception.IllegalIndexException;
import obligatorio2023.TADs.MyQueue.MyQueue;
import obligatorio2023.TADs.MyStack.MyStack;

public class MyLinkedListImp<T> implements MyLinkedList<T>, MyStack<T>, MyQueue<T>
{

    private Node<T> primero;

    public Node<T> getPrimero()
    {
        return this.primero;
    }

    @Override
    public boolean esVacia() {
        if (this.primero==null){
            return true;
        }
        else{
            return false;}
    }

    @Override
    public void agregar(T obj)
    { Node<T> nuevo= new Node<>(obj);
        nuevo.setSiguiente(this.primero);
        this.primero=nuevo;
    }

    @Override
    public void agregarAlFinal(T obj)
    {
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
    public int largo(){ int contador=1;
        if(esVacia()==true){
            return 0;
        }
        else{
            Node<T> aux=this.primero;
            while(aux.getSiguiente()!=null){
                contador++;
                aux=aux.getSiguiente();
            }
            return contador;
        }
    }

    @Override
    public T quitar(int index){
        if (!esVacia() && 0<= index && index<largo()) {
            Node<T> aux = this.primero;
            if (index==0){
                Node<T> aux2= primero;
                this.primero=primero.getSiguiente();
                return aux2.getDato();
            }
            int contador = 0;
            while (contador < index-1) {
                aux = aux.getSiguiente();
                contador++;
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
    {this.primero=null;
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
    public boolean isEmpty() {
        return esVacia();
    }

    @Override
    public void clear() {
        vaciar();
    }
}
