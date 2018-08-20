package HeapDataStructure;

import java.util.Arrays;

public class HeapDS {

	private int capacity;
	private int size;
	private int[] items;
	
	public HeapDS(int capacity) {
		this.capacity = capacity;
		this.size = -1;
		this.items = new int[capacity];
	}
	
	public int getParentIndex(int index) {
		
		return (index-1)/2;
	}
	
	public int getLeftChildIndex(int index) {
		return 2*index+1;
	}
	public int getRightChildIndex(int index) {
		return 2*index+2;
	}
	
	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index)<size;
	}
	
	public boolean hasRightChild(int index) {
		return getRightChildIndex(index)<size;
	}
	
	public boolean hasParent(int index) {
		return getParentIndex(index)>=0;
	}
	
	public void ensureCapacity() {
		if(size==capacity) {
			items = Arrays.copyOf(items,capacity*2);
			capacity*=2;
		}
		
	}
	
	public int peek() {
		return items[0];
	}
	
	public int poll() {
		// Remove the element and return that element
		
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown(0);
		return item;
	}
	
	public void insert(int item) {
		size++;
		items[size] = item;
		heapifyUp();
		ensureCapacity();
		
	}
	
	public void heapifyDown(int index) {
		int largest,childIndex;
		largest = index;
		if(hasLeftChild(index)) {
			childIndex = getLeftChildIndex(index);
			if(items[childIndex]<items[index])
				largest = childIndex;
			
			childIndex = getRightChildIndex(index);
			if(items[childIndex]<items[largest])
				largest = childIndex;
				
		}
		
		if(largest!=index)
		{
			swap(largest,index);
			heapifyDown(largest);
			
		}
		
	}
	
	public void heapifyUp() {
		int index = size;
		int parentIndx;
		
		while(hasParent(index) && items[index]<items[getParentIndex(index)]) {
			parentIndx = getParentIndex(index);
			swap(index,parentIndx);
			index = parentIndx;	
			}
		
	}
	
	public void swap(int id1,int id2) {
		int temp = items[id1];
		items[id1] = items[id2];
		items[id2] = temp;
	}
	
	public void heapSort() {
		int[] sortedItems = new int[items.length];
		for(int i=size;i>0;i--) {
			swap(i,0);
			size--;
			heapifyDown(0);
		
		}
	
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int[] getItems() {
		return items;
	}
	public void setItems(int[] array) {
		this.items = array;
	}
	
}
