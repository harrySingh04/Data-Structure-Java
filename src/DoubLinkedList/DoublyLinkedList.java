package DoubLinkedList;

public class DoublyLinkedList<E> {

	//Starting node for the linked list
	Node<E> head = null;
	

	
	//Searching for the data in the linked list.
	public Node<E> search(E data)
	{
		
		if(head==null)
			//If there is no node, then return null
			return null;
		Node<E> current  = head;
		//Keep iterating over the linked list to find the node
		while(current!=null)
		{
			if(current.getData()==data)
				return current;
			else
				current = current.getNext();
			
		}
		// If not found then it will return
		return null;
			
	}
	// Find the size of the list
	public int size()
	{
		Node<E> current = head;
		int size = 0;
		while(current!=null)
		{
			current = current.getNext();
			size++;
		}
		return size;
	
		
	}
	
	//Adding Node at the first
	public void addFirst(E data)
	{
		Node<E> newNode = new Node(data);
		newNode.setNext(head);
		if(head!=null){
			head.setPrev(newNode);// Setting the previous node of the first item to the new item.
		}
		
		head = newNode;
		
	}
	//Adding Node at the last
		public void addLast(E data)
		{
			Node<E> newNode = new Node(data);
			Node<E> current = head;
			while(current.getNext()!=null)
				current = current.getNext();
			current.setNext(newNode);
			newNode.setPrev(current);
			
		}
		//Adding node between two position
		public void addInBetween(E data,int pos1,int pos2)
		{
			//pos1 and pos2 are two position in between which node will be inserted
			
			int curIndex = 0;
			Node<E> current = head;
			Node<E> newNode = new Node(data);
			
			while(current!=null && pos1!=curIndex)
			{
				current = current.getNext();
				curIndex++;
				
			}
			if(current==null)
				System.out.println("Index not found for insertion");
			else
			{
				Node<E> temp = current.getNext();
				current.setNext(newNode);
				newNode.setPrev(current);
				newNode.setNext(temp);
				temp.setPrev(newNode);
			}
			
		}
		
	// Adding Node at an Index(we are assuming the node index starts at 0)
		
		public void add(E data,int index)
		{
			Node<E> current = head;
			Node<E> newNode = new Node(data);
			int currIndex = 0;
			if (index==0)
				addFirst(data);
			
			else if(index==size()-1)
				addLast(data);
			
			else
				addInBetween(data,index,index+1);
			
			
		}
		
		//Removing the first element of the list
		public void removeFirst()
		{
					head = head.getNext();
					head.setPrev(null);
		}
		
		//Remove the last item from the last
		public void removeLast()
		{
			Node<E> current = head;
			Node<E> temp = head;
			while(current.getNext()!=null)
			{
				temp = current;
				current = current.getNext();
				
			}
			temp.setNext(null);
			
		}
		
		//Remove the item which is in between the list
		public void  removeInBetween(int index)
		{
			Node<E> current = head;
			Node<E> temp = head;
			int curIndex = 0;
			
			while(current!=null && curIndex!=index)
			{
				temp = current;
				current = current.getNext();
				curIndex++;
			}
			if(current.getNext()==null)
				System.out.println("Position not found for deletion");
			else
			{
				
				temp.setNext(current.getNext());
				current.getNext().setPrev(temp);
			}
		}
		
		//Display the list 
		public void displayList()
		{
			Node<E> current = head;
			while(current!=null)
			{
				System.out.println(current.getData());

				current = current.getNext();
			}
			
		}
	
}
