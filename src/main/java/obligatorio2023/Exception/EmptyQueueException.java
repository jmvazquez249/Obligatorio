package obligatorio2023.Exception;

public class EmptyQueueException  extends Exception{
    public EmptyQueueException(){
        super("Error la cola esta vacia");
    }
}
