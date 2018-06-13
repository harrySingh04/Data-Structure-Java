package HashTableImpl;

public class DriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		HashTable<Integer,String> hash = new HashTable(10);
		
		hash.addKey(12, "c");
		hash.addKey(4, "d");
		hash.addKey(2, "a");
		//System.out.println(hash.removeKey(12));
		hash.addKey(3, "b");
		hash.addKey(33, "e");
		hash.addKey(3, "g");
		hash.addKey(13,"f");
		hash.addKey(13,"z");
		hash.displayHashTable();
		
		System.out.print("\n\n");
		
		

		
		hash.displayHashTable();
		
		
		
		
		

	}

}
