package DoubLinkedList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList<Integer> list = new DoublyLinkedList();
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
		

	}

}
