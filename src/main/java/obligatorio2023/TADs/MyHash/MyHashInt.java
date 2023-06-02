package obligatorio2023.TADs.MyHash;

import obligatorio2023.Exception.IllegalEntryException;

public interface MyHashInt<K,V> {
    public void put(K key, V Value) throws IllegalEntryException;
    public int contains(K key);
    public void remove(K key);
    public V get(K key);

}
