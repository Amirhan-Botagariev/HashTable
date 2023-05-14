import java.util.LinkedList;

public class HashTable<K, V> {
    private int size;
    private int M = 11;
    private LinkedList<HashNode<K, V>>[] chain;

    public HashTable(int m){
        this.M = m;
        size = 0;
        chain = new LinkedList[M];
    }

    private int hash(K key){
        return key.hashCode() % M;
    }

    public void put(K key, V value){
        int index = hash(key);
        if (chain[index] == null){
            chain[index] = new LinkedList<HashNode<K, V>>();
        }
        for (HashNode<K, V> node: chain[index]){
            if (node.getKey().equals(key)){
                node.setValue(value);
                return;
            }
        }

        chain[index].add(new HashNode<>(key, value));
        size++;
    }

}
