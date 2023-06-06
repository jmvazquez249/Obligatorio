package obligatorio2023.TADs.MyHash;

import obligatorio2023.Exception.IllegalEntryException;
import obligatorio2023.Exception.ValueAlreadyExistsException;

public interface MyHashInt<K,V> {
    public void put(K key, V Value) throws IllegalEntryException, ValueAlreadyExistsException;
    public int contains(K key);
    public void remove(K key);
    public V get(K key);

}
