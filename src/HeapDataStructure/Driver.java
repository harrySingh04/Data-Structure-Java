package HeapDataStructure;

public class Driver {
	enum State {unvisited,visiting,visited};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HeapDS heap = new HeapDS(10);
		heap.insert(7);
		heap.insert(2);
		heap.insert(1);
		heap.insert(9);
		heap.insert(3);
		heap.insert(4);
		heap.insert(11);
		heap.insert(16);
		heap.insert(8);
		//heap.heapSort();
		for(int i=0;i<heap.getSize();i++) {
			System.out.println(heap.getItems()[i]);
		}
		
	}

}
