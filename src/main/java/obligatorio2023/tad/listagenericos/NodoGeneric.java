package obligatorio2023.tad.listagenericos;

public class NodoGeneric<T>
{
    private NodoGeneric<T> siguiente;
    private T dato;

    public NodoGeneric<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoGeneric<T> anterior) {
        this.anterior = anterior;
    }

    private NodoGeneric<T> anterior;
    public NodoGeneric()
    {

    }

    public NodoGeneric(T dato)
    {
        this.dato =  dato;
    }

    public NodoGeneric<T> getSiguiente()
    {
        return this.siguiente;
    }

    public void setSiguiente(NodoGeneric<T> nodo)
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
