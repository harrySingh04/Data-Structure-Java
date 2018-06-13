package BinaryTreeImpl;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree<Integer> bst = new BinaryTree<Integer>();
		bst.addInsert(60);
		bst.addInsert(55);
		bst.addRec(100);
		bst.addRec(45);
		bst.addRec(57);
		bst.addRec(67);
		bst.addInsert(107);
		bst.addInsert(101);
		bst.addInsert(59);
		
		bst.deleteItem(55);
		
		System.out.println("Inorder using iteration");
		bst.inOrderIter();
		System.out.println("Inorder using recursion");
		bst.inOrderR();
		
		

	}

}
