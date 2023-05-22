import obligatorio2023.Exception.EmptyQueueException;
import obligatorio2023.Exception.EmptyStackException;
import obligatorio2023.Exception.IllegalIndexException;
import obligatorio2023.TADs.MyHeapArray.MyBinaryHeap;
import obligatorio2023.TADs.MyHeapArray.MyBinaryHeapImpl;
import obligatorio2023.TADs.MyLinkedList.MyLinkedListImp;
import obligatorio2023.TADs.MyLinkedList.MyList;
import obligatorio2023.TADs.MyQueue.MyQueue;
import obligatorio2023.TADs.MySearchBinaryTree.MySearchBinaryTree;
import obligatorio2023.TADs.MySearchBinaryTree.MySearchBinaryTreeImp;
import obligatorio2023.TADs.MyStack.MyStack;
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
       Numeros.vaciar();
       try{
           Numeros.dequeue();
           fail();
       }
       catch (EmptyQueueException EQE){
       } catch (Exception Ex){
           fail();
       }

    }
    @Test
    public void TestStack() throws EmptyStackException {
        MyStack<Integer> Numeros = new MyLinkedListImp<>();
        Numeros.push(4); //Primero en entrar
        Numeros.push(7);
        Numeros.push(0);
        Numeros.push(-5); //Ultimo en entrar
        assertSame(-5,Numeros.top());
        assertSame(-5,Numeros.pop());
        Numeros.vaciar();
        try {
            Numeros.pop();
            fail();
        }catch(EmptyStackException ESE){
        }catch (Exception Ex){
            fail();
        }
    }
    @Test
    public void TestBinarySearchTree(){
        MySearchBinaryTree<Integer, String> Arbol = new MySearchBinaryTreeImp();
        Arbol.insert(134,"A");
        Arbol.insert(120,"B");
        Arbol.insert(150,"C");
        Arbol.insert(127,"D");
        Arbol.insert(7,"E");
        Arbol.insert(99,"F");
        Arbol.insert(31,"G");
        Arbol.insert(60,"H");
        assertSame(3,Arbol.countLeaf());
        assertSame(8,Arbol.size());
        assertEquals("E",Arbol.find(7));
        assertEquals("C",Arbol.find(150));
        Arbol.delete(7);
        assertEquals(null,Arbol.find(7));
    }
    @Test
    public void testHeap(){
        MyBinaryHeap<Integer> HeapMax = new MyBinaryHeapImpl(true);
        HeapMax.insert(1);
        HeapMax.insert(4);
        HeapMax.insert(6);
        HeapMax.insert(5);
        assertSame(6,HeapMax.getMax());
        MyBinaryHeap<Integer> HeapMin = new MyBinaryHeapImpl(false);
        HeapMin.insert(9);
        HeapMin.insert(4);
        HeapMin.insert(5);
        HeapMin.insert(1);
        assertSame(1,HeapMin.getMin());

        assertSame(4,HeapMax.deleteValue(4));
        assertSame(-1,HeapMax.find(4));

        assertSame(4,HeapMin.deleteValue(4));
        assertSame(-1,HeapMin.find(4));


    }
}
