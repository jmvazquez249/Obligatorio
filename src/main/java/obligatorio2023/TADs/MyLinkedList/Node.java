package obligatorio2023.TADs.MyLinkedList;

public class Node<T>
{
    private Node<T> siguiente;
    private T dato;

    public Node<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Node<T> anterior) {
        this.anterior = anterior;
    }

    private Node<T> anterior;

    public Node() {
    }

    public Node(T dato)
    {
        this.dato =  dato;
    }

    public Node<T> getSiguiente()
    {
        return this.siguiente;
    }

    public void setSiguiente(Node<T> nodo)
    {
        this.siguiente = nodo;
    }



    public T getDato()
    {
        return this.dato;
    }

    public void setDato(T dato)
    {
        this.dato = dato;
    }
}
