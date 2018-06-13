package StackQueueRelatedProbs;

public class Stack {
	int top;
	int[] stackList;
	int max;
	
	
	public Stack(int max) {
		this.top=-1;
		this.max = max;
		stackList = new int[this.max];
		
	}
	
	void push(int element) {
		
		if(top==max-1) {
				System.out.println("Stack if full! Overflow!!!");
		}
		else {
			stackList[++top] = element;
		}
		
		
	}
	
	int pop() {
		
		return stackList[top--];
		
	}
	
	int peek() {
		return stackList[top];
	}
	
	
	// Sort the stack -additional functionality.
	
}
