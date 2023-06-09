import java.util.LinkedList;

public class HashTable<K, V> {
    private int size;
    private int M = 11;
    private LinkedList<HashNode<K, V>>[] chain;

    public HashTable(){
        chain = new LinkedList[M];
        size = 0;
    }

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

    public V remove(K key){
        int index = hash(key);
        if (chain[index] == null){
            return null;
        }

        for (HashNode<K, V> hashNode : chain[index]){
            if (hashNode.getKey().equals(key)){
                chain[index].remove(hashNode);
                size--;
                return hashNode.getValue();
            }
        }

        size--;
        return null;
    }

    public boolean contains(V value){
        for (LinkedList<HashNode<K, V>> linkedList : chain){
            for (HashNode<K, V> hashNode: linkedList){
                if (hashNode.getValue().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public int getSize(){
        return size;
    }

    public V get(K key){
        int index = hash(key);
        if (chain[index] == null){
            return null;
        }

        for (HashNode<K, V> hashNode : chain[index]){
            if (hashNode.getKey().equals(key)){
                return hashNode.getValue();
            }
        }
        return null;
    }

    public K getKey(V value){
        for (LinkedList<HashNode<K, V>> linkedList : chain){
            for (HashNode<K, V> hashNode: linkedList){
                if (hashNode.getValue().equals(value)){
                    return hashNode.getKey();
                }
            }
        }
        return null;
    }

    public boolean replace(K key, V oldValue, V newValue){
        for (LinkedList<HashNode<K, V>> linkedList : chain){
            if (linkedList == null){
                continue;
            }
            for (HashNode<K, V> hashNode: linkedList){
                if (hashNode.getKey().equals(key)){
                    if (hashNode.getValue().equals(oldValue)){
                        hashNode.setValue(newValue);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
