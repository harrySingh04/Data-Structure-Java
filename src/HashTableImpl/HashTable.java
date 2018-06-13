package HashTableImpl;

import java.util.ArrayList;

public class HashTable<K,V> {

	private ArrayList<HashEntry<K, V>> hashTable = new ArrayList<HashEntry<K,V>>();
	
	public int maxPossibleKeys; //Maximum number of different keys that can be stored in the hash table.
	public int currentSize; //Number of different keys stored in the table.
	
	
	public HashTable(int maxPossibleKeys) {
		this.maxPossibleKeys = maxPossibleKeys; 
		this.currentSize = 0;// Initially no records , hence size is 0.
		
		
		//Initially, Initialize each entry in the hash table to null
		for(int i=0;i<maxPossibleKeys;i++) {
			
			hashTable.add(null);
		}
		
	}
	
	
	//Method that will generate the index for the keys passed to this function
	public int hashFunction(K key) {
		
		int hashCode = key.hashCode();
		int index = hashCode % maxPossibleKeys;
		return index;
	}
	
	public void addKey(K key,V value) {
		int index = hashFunction(key);
		
		HashEntry<K,V> newNode = new HashEntry<K,V>(key,value);
		
		
		//If table does not contain any value for that key then add the value and increase the size by 1.
		if(hashTable.get(index)==null ) {
			
			
			hashTable.set(index, newNode);
		
			this.currentSize++;
		}
		else {
				
				// If new key has the same index as the existing key then add the values in the same key as a linked list.
				
				HashEntry<K,V> currentNode = hashTable.get(index);
				
			
				//Find the place to add the new key or update the existing one 
				while(currentNode!= null) {
					if(currentNode.getKey().equals(key)) {
						currentNode.setValue(value);//Update the existing keys with new values
						return;
					}
					if(currentNode.getNext()==null) {
						currentNode.setNext(newNode);
						return;
					}
					currentNode = currentNode.getNext();
					
				}
				
				
				
			
			
		}
		// If the hash table has a load factor more than 0.7 then we will double the size of the hash table.
		if(this.currentSize/this.maxPossibleKeys>0.7) {
			this.maxPossibleKeys *=2;
		}
		
		
	}
	
	public HashEntry<K,V> removeKey(K key) {
		int index = hashFunction(key);
		if(hashTable.get(index)== null) 
			return null;// Key not present in the hash table
		else {
			
			HashEntry<K,V> currentNode = hashTable.get(index);
			HashEntry<K,V> prevNode = currentNode;
			//HashEntry<K,V> head = currentNode;
			
			if(currentNode.getKey().equals(key))
			{
				hashTable.set(index,currentNode.getNext());
				return currentNode;
				
			}
			
			//Find the key in the same linked list of key.
			currentNode = currentNode.getNext();
			while(currentNode!=null) {
				if(currentNode.getKey().equals(key))
				{
					prevNode.setNext(currentNode.getNext());
					return currentNode;
				}
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
			
		}
		
		return  null; //Key not found
	}
	
	public void displayHashTable() {
		System.out.println("Hash Table \"\\n\\n\"");
		
		for(int i=0;i<maxPossibleKeys;i++) {
			System.out.print(" Index ===>"+i);
			if(hashTable.get(i)!=null) {
				HashEntry<K,V>  currentNode = hashTable.get(i);
				System.out.print("   Values ====>");
				while(currentNode!=null) {
					System.out.print("  Key  =>"+currentNode.getKey()+"  Value =>"+currentNode.getValue());
					currentNode = currentNode.getNext();
				}
				System.out.println();
				
			}
			else {
				System.out.println("-------------EMPTY-------");
			}
		}
		
	}
	
	
	
}
