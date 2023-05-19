package obligatorio2023.tad.lista;


import obligatorio2023.tad.exceptions.IllegalIndexException;

public class ListaEnlazada implements Lista
{
    private Nodo primero;


    public ListaEnlazada()
    {

    }

    @Override
    public boolean esVacia()
    {
        if (this.primero==null){
            return true;
        }
        else{
        return false;}
    }

    @Override
    public void agregar(Object obj)
    { Nodo nuevo= new Nodo(obj);
        nuevo.setSiguiente(this.primero);
        this.primero=nuevo;
    }

    @Override
    public void agregarAlFinal(Object obj)
    {
        Nodo nuevo= new Nodo(obj);
        if (this.primero==null){
            this.primero=nuevo;
        }
        else{
            Nodo aux=this.primero;
            while(aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    @Override
    public void agregar(Object obj, int index) throws IllegalIndexException {
        if(index>largo()||index<0){
        throw  new IllegalIndexException("El indice es incorrecto");
    }
    else{
        Nodo nuevo = new Nodo(obj);
        if (index == 0) {
            agregar(obj);
        } else {
            if (index == largo()) {
                agregarAlFinal(obj);
            } else {
                int recorre = 0;
                Nodo aux = this.primero;
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
    public int largo()
    { int contador=1;
        if(esVacia()==true){
            return 0;
    }
        else{
            Nodo aux=this.primero;
            while(aux.getSiguiente()!=null){
                contador++;
                aux=aux.getSiguiente();
            }
            return contador;
        }
    }

    @Override
    public Object quitar(int index) {
        if (!esVacia() && 0<= index && index<largo()) {
            Nodo aux = this.primero;
            int contador = 0;
            while (contador < index) {
                aux = aux.getSiguiente();
                contador++;
            }
            Nodo aux2 = aux.getSiguiente();
            aux.setSiguiente(aux2.getSiguiente());
            return aux2.getDato();
        } else {
            return null;
        }
    }


    @Override
    public Object elemento(int index)
    { if(-1<index && index<largo()){
        int recorre=0;
        Nodo aux=this.primero;
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
    public void imprimirDatos() {
        if (!esVacia()) {
            Nodo aux = this.primero;
            int recorre = 0;
            while(recorre<largo()){
                System.out.println(aux.getDato());
                aux=aux.getSiguiente();
                recorre++;
            }

        }
    }

    public Nodo getPrimero()
    {
        return this.primero;
    }
}
