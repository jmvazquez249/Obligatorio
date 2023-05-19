package obligatorio2023.tad.pila;


import obligatorio2023.tad.exceptions.EmptyStackException;

public class PilaArray<T>  implements Pila<T>{

    private T datos[];
    private int indiceTop;
    private static final int CAPACIDAD_INICIAL=100;

    public PilaArray(){
        datos= (T[]) new Object[CAPACIDAD_INICIAL];
        indiceTop=-1;
    }

    public PilaArray(int capacidad){
        datos = (T[]) new Object[capacidad];
        indiceTop=-1;
    }
    @Override
    public void push(T dato) {
            if(indiceTop==datos.length-1){
                System.out.println("excepcion pila llena");
            }
            else{
                indiceTop++;
                datos[indiceTop]=dato;
            }
    }

    @Override
    public T pop() throws EmptyStackException {
        if (indiceTop<0){
            System.out.println("Excepcion pila vacia");
            return null;
        }
         T elDato=datos[indiceTop];
        datos[indiceTop]=null;
        indiceTop--;
        return elDato;
    }

    @Override
    public T top() {
        if(indiceTop<0){
            System.out.println("Excepcion pila vacia");
            return null;
        }
        else{
        return datos[indiceTop]; }
    }

    @Override
    public boolean isEmpty() {
        return indiceTop<0;
    }

    @Override
    public void clear() {
        for(int i=0;i<indiceTop;i++){
            datos[i]=null;
        }

    }
}
