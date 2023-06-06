import obligatorio2023.Exception.*;
import obligatorio2023.TADs.MyHash.MyHashClosedImpl;
import obligatorio2023.TADs.MyHash.MyHashInt;
import obligatorio2023.TADs.MyHeapArray.MyBinaryHeap;
import obligatorio2023.TADs.MyHeapArray.MyBinaryHeapImpl;
import obligatorio2023.TADs.MyLinkedList.MyLinkedListImp;
import obligatorio2023.TADs.MyLinkedList.MyList;
import obligatorio2023.TADs.MyQueue.MyQueue;
import obligatorio2023.TADs.MySearchBinaryTree.MySearchBinaryTree;
import obligatorio2023.TADs.MySearchBinaryTree.MySearchBinaryTreeImp;
import obligatorio2023.TADs.MyStack.MyStack;
import obligatorio2023.TADs.Conjunto.Conjunto;
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
       assertNull(Numeros.elemento(-1));
       assertNull(Numeros.elemento(100));
       assertNull(Numeros.quitar(-1));
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
    public void testQueue() throws EmptyQueueException {
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
    public void testStack() throws EmptyStackException {
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
    public void testBinarySearchTree(){
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
    @Test
    public void testConjunto() {
        Conjunto<Integer> conj1 = new Conjunto<>();
        for (int i = 0; i < 10; i++) {
            conj1.agregar(i);
        }
        Conjunto<Integer> conj2 = new Conjunto<>();
        for (int i = 0; i < 10; i++) {
            conj2.agregar(i + 3);
        }
        Conjunto<Integer> uni12 = conj1.union(conj2);
        Conjunto<Integer> dif12 = conj1.diferenciaSimetrica(conj2);
        Conjunto<Integer> difnorm12=conj1.diferencia(conj2);
        Conjunto<Integer> difnorm21=conj2.diferencia(conj1);
        Conjunto<Integer> int12=conj1.interseccion(conj2);
        assertEquals(13, uni12.largo());
        assertEquals(6, dif12.largo());
        assertSame(2,uni12.getPrimero().getDato());
        assertSame(0,dif12.getPrimero().getDato());
        assertEquals(3,difnorm12.largo());
        assertEquals(3,difnorm21.largo());
        assertEquals(7,int12.largo());
        for(int k=0;k<int12.largo();k++){
            assertSame((k + 3),int12.elemento(k));
        }
    }
    @Test
    public void testHash() throws IllegalEntryException, ValueAlreadyExistsException {
        MyHashInt<String,String> Hash = new MyHashClosedImpl<String,String>(7);
        Hash.put("Francia","Paris");
        Hash.put("España","Madrid");
        Hash.put("Uruguay","Montevideo");
        Hash.put("Argentina","Buenos Aires");
        Hash.put("Brasil","Brasilia");
        Hash.put("Alemania","Berlin");
        Hash.put("Suiza","Berna");


        assertSame("Montevideo",Hash.get("Uruguay"));
        assertSame("Berna", Hash.get("Suiza"));

        assertSame(-1,Hash.contains("Polonia"));
//
        Hash.remove("Francia");
        assertSame(-1,Hash.contains("Francia"));
        Hash.remove("Argentina");
        assertSame(-1,Hash.contains("Argentina"));

        Hash.put("Estados Unidos","Washington D.C");
        Hash.put("Chile","Santiago");
        Hash.put("Portugal","Lisboa");

        assertSame("Lisboa", Hash.get("Portugal"));


    }

    }
