package StackQueueRelatedProbs;

public class Driver {

	public static void main(String[] args) {
		
			int[] a = {1,2,7,6,4,3,5};
			System.out.println(solution(a,2,2));
		}
		
		public static int solution(int[] A,int k,int m) {
			int length = A.length;
			int maxDay=0,getGroup=0;
			
			//ArrayList newList = new ArrayList<>();
			int valueIndex,counter=0;
			
			int[] newA = new int[length];
			
			for(int i=0;i<newA.length;i++) {
				newA[i] = 0;
			}
			
			for(int i=0;i<A.length;i++) {
				
				newA[A[i]] = 1;
				counter++;
				if(counter>=m) {
					getGroup = checkGroups(newA,k,m);
				}
				
				if(getGroup!=0)
					maxDay = i+1;
				
				
				
				
			}
			
			if(maxDay==0)
				return -1;
			else
				return maxDay;
		}
			
			public static int checkGroups(int[] group,int k,int m) {
				int start = 0;
				int countGroup = 0;
				for(int i=0;i<group.length;i++) {
					if(group[i]==1) {
						start = start+1;
					}
					else {
						start = 0;
					}
					
					if(start>=k)
						countGroup++;
						
					
				}
				
				if(countGroup==m)
					return countGroup;
				else
					return 0;
					
				
				
			}
			
			
			
			
			
			
		}
		
		

