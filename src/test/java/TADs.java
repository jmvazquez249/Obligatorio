import obligatorio2023.Exception.IllegalIndexException;
import obligatorio2023.TADs.MyLinkedList.MyLinkedListImp;
import obligatorio2023.TADs.MyLinkedList.MyList;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


public class TADs {
   @Test
    public void testList() throws IllegalIndexException {
       MyList<Integer> Numeros = new MyLinkedListImp<>();
       Numeros.agregar(1);
       Numeros.agregar(10);
       Numeros.agregar(4);
       Numeros.agregar(8);
       Numeros.agregar(7);
       assertEquals(false, Numeros.esVacia());
       assertSame(5,Numeros.largo());
       Numeros.agregar(5,3);
       assertSame(5, Numeros.elemento(3));
       assertSame(5, Numeros.quitar(3));
       Numeros.vaciar();
       assertEquals(true, Numeros.esVacia());
    }
}
