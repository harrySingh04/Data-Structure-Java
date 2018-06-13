package SingLinkedImpl;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedListMethodsPrac<E> {

	public static void main(String args[]) {
		
	}

	@SuppressWarnings("unchecked")
	//Remove Duplicates from unsorted linked list
	
	//First Method using the extra buffer
	
	
	void removeDuplicated(SingleLinkedList<E> list) {
			Hashtable hashTable = new Hashtable();
			
			Node<E> current = list.head;
			Node<E> prev=current;
			while(current!=null) {
				if(hashTable.containsKey(current.getData()))
				{
					prev.setNext(current.getNext());
					current = current.getNext();
					
				}
				else {
					hashTable.put(current.getData(),true);
					prev = current;
					current = current.getNext();
				}
				
				
			}
		
	}
	
	//Second Method without using extra buffer
	void removeDuplicates(SingleLinkedList<E> list) {
		
		Node<E> current = list.head;
		Node<E> findOne;
		
		while(current!=null) {
			Node<E> prev = current;
			findOne = current.getNext();
			
			while(findOne!=null) {
				if(findOne.getData()==current.getData()) {
					prev.setNext(findOne.getNext());
					
				}
				else {
					prev = findOne;
				}
			
				findOne = findOne.getNext();
				
			}
			current = current.getNext();
			
		} 
		
	}
	
	
}
