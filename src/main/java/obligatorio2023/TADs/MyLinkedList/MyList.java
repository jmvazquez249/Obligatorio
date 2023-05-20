package obligatorio2023.TADs.MyLinkedList;

import obligatorio2023.Exception.IllegalIndexException;

public interface MyList<T>
{
    boolean esVacia();
    void agregar(T obj);
    void agregarAlFinal(T obj);
    void agregar(T obj, int index) throws IllegalIndexException;
    int largo();
    T quitar(int index);
    T elemento(int index);
    void vaciar();
    void imprimirDatos();
    T getUltimo();

}
