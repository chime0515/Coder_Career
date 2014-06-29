
public class CC_35_Depth_B_Tree {
	
	  public static int TreeDepth(Node n){
		if(n==null)
			return 0;
		
		return Math.max(TreeDepth(n.left), TreeDepth(n.right))+1;
		
	  }
	  
	  public static boolean Balance1(Node n){
		  if(n==null)
			return true;
		  
		  int ln=TreeDepth(n.left);
		  int rn=TreeDepth(n.right);
		  if(ln-rn>1 || rn-ln>1)
			  return false;
		  // I'm not sure about this part....
		  else
			  return Balance1(n.left) && Balance1(n.right);
	  }
	  
	  public static boolean Balance2(Node n)
	  {
	      if(CheckDepth(n)==-1) return false; //Not balanced
	      else return true;
	  }
	  
	  public static int CheckDepth(Node n)
	  {
		  if(n==null) return 0;

		  //Check the left node
		  int ln=CheckDepth(n.left);
		  if(ln==-1) return -1; //Not balanced

		  //Check the right node
		  int rn=CheckDepth(n.right);
		  if(rn==-1) return -1;
		  
		  //Check the current node
		  int diff=ln-rn;
		  if(Math.abs(diff)>1) //Not balanced 
			  return -1; 
		  else
			  return Math.max(ln, rn)+1;
			  
	  }
	   
	  public static void main(String[] args)
	  {
		  Node root=new CC_35_Depth_B_Tree().run();
		  System.out.println("Depth of Tree:"+TreeDepth(root));
		  boolean a = Balance2(root);
		  System.out.println(a);
	  }

	  // Build a Tree Structure
	  static class Node {
		  Node left;
		  Node right;
		  int value;

		  public Node(int value) {
		  this.value = value;
		  }
	  }
	
	  public Node run(){
		  Node rootnode = new Node(1);
		  System.out.println("Building tree with rootvalue " + rootnode.value);
		  System.out.println("=================================");
		  insert(rootnode, 2);
		  insert(rootnode, 3);

		  System.out.println("Traversing tree in order");
		  System.out.println("=================================");
		  printInOrder(rootnode);
		  System.out.println("\n=================================");
		  return rootnode;
	  }
	
	  public void insert(Node node, int value) {
		  if (value < node.value) {
			  if (node.left != null) {
			  insert(node.left, value);
			  } 
			  else {
			  System.out.println("  Inserted " + value + 
			    " to left of node " + node.value);
			  node.left = new Node(value);
			  }
		  } 
		  else if (value > node.value) {
			  if (node.right != null) {
			  insert(node.right, value);
			  } 
			  else {
			  System.out.println("  Inserted " + value + " to right of node " + node.value);
			  node.right = new Node(value);
			  }
		  }
	  }
	
	  public void printInOrder(Node node) {
		  if (node != null){
		  printInOrder(node.left);
		  System.out.print(node.value +", ");
		  printInOrder(node.right);
		  }
		  
	  }
}