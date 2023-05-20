import obligatorio2023.Exception.EmptyQueueException;
import obligatorio2023.Exception.IllegalIndexException;
import obligatorio2023.TADs.MyLinkedList.MyLinkedListImp;
import obligatorio2023.TADs.MyLinkedList.MyList;
import obligatorio2023.TADs.MyQueue.MyQueue;
import org.junit.Test;

import static org.junit.Assert.*;


public class funcionesTAD {
    @Test
    public void testList() throws IllegalIndexException {
       MyList<Integer> Numeros = new MyLinkedListImp<>();
       Numeros.agregar(1);
       Numeros.agregar(10);
       Numeros.agregar(4);
       Numeros.agregar(8);
       Numeros.agregar(7);
       assertFalse(Numeros.esVacia());
       assertSame(5,Numeros.largo());
       Numeros.agregar(5,3);
       assertSame(5, Numeros.elemento(3));
       assertSame(5, Numeros.quitar(3));
       Numeros.vaciar();
       assertTrue(Numeros.esVacia());
       Numeros.agregarAlFinal(10);
       Numeros.agregarAlFinal(0);
       Numeros.agregarAlFinal(4);
       assertSame(4, Numeros.getUltimo());

    }
    @Test
    public void TestQueue() throws EmptyQueueException {
       MyQueue<Integer> Numeros = new MyLinkedListImp<>();
       Numeros.enqueue(9); //Primero en entrar
       Numeros.enqueue(7);
       Numeros.enqueue(-1);
       Numeros.enqueue(24); //Ultimo en entrar
       assertSame(9,Numeros.dequeue());
       assertEquals(3, Numeros.largo());
       assertSame(7,Numeros.dequeue());
       assertSame(-1,Numeros.dequeue());
        assertSame(24,Numeros.dequeue());
        try{
           Numeros.dequeue();
           fail();
       }
       catch (EmptyQueueException ex){}
       catch (Exception ex){
           fail();
       }

    }
    @Test
    public void TestStack(){

    }
}
