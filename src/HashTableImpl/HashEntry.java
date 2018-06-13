package HashTableImpl;

public class HashEntry<K,V> {

	private  K key;
	private V value;
	
	private HashEntry<K,V> head; //Node to store the first element of the linked list
	private HashEntry<K,V> next; //Node to store the next elemenet reference in the linked list;
	
	

	public HashEntry<K, V> getHead() {
		return head;
	}



	public void setHead(HashEntry<K, V> head) {
		this.head = head;
	}



	public HashEntry(K key,V value) {
		this.key = key;
		this.value = value;
		
		this.head = null;
		this.next = null;
	}
	
	
	
	public HashEntry<K, V> getNext() {
		return next;
	}

	public void setNext(HashEntry<K, V> next) {
		this.next = next;
	}

	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	
}
