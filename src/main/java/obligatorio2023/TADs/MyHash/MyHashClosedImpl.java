package obligatorio2023.TADs.MyHash;

import obligatorio2023.Exception.IllegalEntryException;
import obligatorio2023.Exception.ValueAlreadyExistsException;

import javax.crypto.Mac;

public class MyHashClosedImpl<K,V> implements MyHashInt<K,V>   {
    private V [] hashTable;
    private K [] keysIndex;
    private int largo;
    private int contador;

    public MyHashClosedImpl(int size) {
         hashTable = (V[]) new Object[size];
         largo=size;
         keysIndex=(K[]) new Object[size];
    }
    public MyHashClosedImpl(){
        this(100);
    }

    @Override
    public void put(K key, V value) throws IllegalEntryException, ValueAlreadyExistsException {
        if (key!=null && value!=null ){
            if(contains(key) == -1){
                int code=Math.abs(key.hashCode());
                int mod= code%largo;
                boolean seagrego=false;
                while (!seagrego){
                    if(hashTable[mod]==null){
                        hashTable[mod]=value;
                        keysIndex[mod]=key;
                        seagrego=true;
                        contador++;
                    }else{
                        if (mod<largo-1){
                        mod++;}
                        else{
                            mod=0;
                        }
                    }
                }
                if(largo*0.8<contador){
                    resize();
                }
        }else{
            throw new ValueAlreadyExistsException("Valor ya fue ingresado");
            }
        }
        else{
            throw new IllegalEntryException();
        }

    }
    public void resize(){

        V[] nuevo = (V[]) new Object[this.largo * 2];

        K[] nuevok = (K[]) new Object[this.largo * 2];
        int nuevo_largo = this.largo * 2;
        for (int i=0;i<this.largo;i++){
            if (keysIndex[i]!=null){
                int code=Math.abs(keysIndex[i].hashCode());
                int mod=code%nuevo_largo;
                boolean seagrego=false;
                while (!seagrego){
                    if(nuevok[mod]==null){
                        nuevo[mod]=hashTable[i];
                        nuevok[mod]=keysIndex[i];
                        seagrego=true;
                    }else{
                        if (mod<largo-1){
                            mod++;}
                        else{
                            mod=0;
                        }
                    }
                }
            }
        }
        this.hashTable=nuevo;
        this.keysIndex=nuevok;
        this.largo=nuevo_largo;
    }
    @Override
    public int contains(K key) {
        int code=Math.abs(key.hashCode());
        int mod=code%largo;
        while(true){
            if(keysIndex[mod]==null&&hashTable[mod]==null){
                return -1;
            }else{
                if(Math.abs(keysIndex[mod].hashCode()) == code&& hashTable[mod]!=null){
                    return mod;
                }else{
                    if (mod<largo-1){
                        mod++;}
                    else{
                        mod=0;
                }
                }
            }
        }
    }

    @Override
    public void remove(K key) {
        int indice = contains(key);
        if(indice!=-1){
            hashTable[indice]=null;
        }
    }

    @Override
    public V get(K key) {
        if (contains(key)!=-1){
            return hashTable[contains(key)];
        }
        return null;
    }
}
