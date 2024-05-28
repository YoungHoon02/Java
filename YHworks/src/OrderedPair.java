public class OrderedPair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public OrderedPair(String key2, String string) {
        //TODO Auto-generated constructor stub
    }

    public K getKey() {return key;}
    public V getValue() {return value;}
}
