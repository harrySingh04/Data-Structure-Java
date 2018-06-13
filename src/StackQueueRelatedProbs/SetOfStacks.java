package StackQueueRelatedProbs;


import java.util.*;

public class SetOfStacks {
	
/*The objective of this class to implement a stack in which once the 
 stack gets fulled , then we have to use another stack to implement the stack
 and add the value inside that stack.*/
	
	int max;
	//int top=-1;
	int currentStack = -1;

	List<Stack> setStacks = new ArrayList<Stack>();
	
	public SetOfStacks(int max) {
		
		this.max = max;
		this.currentStack = 0;
		setStacks.add(new Stack(this.max));
	}
	
	//We will keep on pushing just like a normal stack
	// If stack is full then we will create a new stack and change the current stack to that one.
	public void push(int element) {
		
		if(setStacks.get(currentStack).top == max-1) {
			currentStack++;
			setStacks.add(new Stack(this.max));	
		}
		setStacks.get(currentStack).push(element);
	}
	
	/*
	 * Keep popping up the element from the 
	 * */
	public void pop() {
		setStacks.get(currentStack).pop();
		if(setStacks.get(currentStack).top == -1)
		{
			setStacks.set(currentStack, null);
			currentStack--;
		}
	}
	

}
