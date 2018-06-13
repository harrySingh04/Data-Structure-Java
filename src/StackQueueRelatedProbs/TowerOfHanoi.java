package StackQueueRelatedProbs;

public class TowerOfHanoi {

	Stack[] hanoiStacks = new Stack[3];
	int noDisk;

	public TowerOfHanoi(int noDisk) {
		this.noDisk = noDisk;
		for(int i=0;i<3;i++) {
			hanoiStacks[i] = new Stack(noDisk);
		}

	}

	//Insert the value in the first tower with the decreasing order 
	//such that large number disk is at bottom.
	public void intializeFirstDisk() {

		for(int i=noDisk;i>0;i--) {
			hanoiStacks[0].push(i);
		}
	}
	
	public void moveDisks(int n,int start,int dest) {
		int helperPeg=0;
		if(n==1) {
			hanoiStacks[dest].push(hanoiStacks[start].pop());
		}
		else {
			
			helperPeg = 3 -start -dest;
			moveDisks(n-1,start,helperPeg);
			hanoiStacks[dest].push(hanoiStacks[start].pop());
			moveDisks(n-1,helperPeg,dest);
			
			
		}
		
	}
	
	public void puzzleStart() {
	
		moveDisks(noDisk,0,2);
		
	}
	
	

}

