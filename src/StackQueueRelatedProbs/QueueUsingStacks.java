package StackQueueRelatedProbs;

public class QueueUsingStacks {
		
	Stack s1,s2;

	
	public QueueUsingStacks(int size) {
		s1 = new Stack(size);
		s2 = new Stack(size);
		
	}
	
	public void enqueue(int item) {
		s1.push(item);
	}
	
	public int dequeue() {
		int poppedItem;
		if(s2.top!=-1) {
			return s2.pop();
		}
		else {
			while(s1.top!=-1) {
				s2.push(s1.pop());
			}
			return s2.pop();
		}
		
		
	}
	
}
