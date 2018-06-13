package SingLinkedImpl;

import DoubLinkedList.DoublyLinkedList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SingleLinkedList<Integer> list = new SingleLinkedList();
		list.addFirst(1);
		list.addFirst(2);
		list.addLast(3);
		list.addInBetween(4, 1, 2);
		list.add(5,0);
		list.add(6,4);
		list.add(10, 3);
		list.displayList();
		list.removeFirst();
		list.removeLast();
		list.removeInBetween(2);
		System.out.println("Deletion");
		list.displayList();
		
		System.out.println("Using doubly linked List\n\n");
		/*DoublyLinkedList<Integer> dlist  = new DoublyLinkedList();
		dlist.addFirst(1);
		dlist.addFirst(2);
		dlist.addLast(3);
		dlist.addInBetween(4, 1, 2);
		dlist.add(5,0);
		dlist.add(6,4);
		dlist.add(10, 3);
		dlist.displayList();
		dlist.removeFirst();
		dlist.removeLast();
		dlist.removeInBetween(2);
		System.out.println("Deletion");
		dlist.displayList();*/
		
		/*SingleLinkedList<String> newList = new SingleLinkedList<String>();
		newList.addFirst("Mark");
		newList.addLast("Sam");
		newList.addLast("Sue");
		newList.addLast("Sue");
		newList.addLast("Sam");
		newList.addLast("John");*/
		//LinkedListMethodsPrac prac = new LinkedListMethodsPrac();
		//prac.removeDuplicated(newList);

	}

}
