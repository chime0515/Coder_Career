public class CC_31_Is_BST {


	public static void main(String[] args) {
		Node n=new CC_31_Is_BST().Build_Tree();
		
		System.out.println(Is_BST(n, null, null));
		System.out.println(sol2_recur(n, null));
		
	}
	
	public static boolean Is_BST(Node n, Integer max, Integer min){
		
		if(n==null) return true;
		
		if(max!=null && n.value>max) return false;
		if(min!=null && n.value<=min) return false;
		
		return Is_BST(n.left, n.value, min) && Is_BST(n.right, max, n.value);
		
		
	}
	// In-Order
	public static boolean sol2_recur(Node n, Integer prev){
	
		if(n==null) return true;
		
		if(!sol2_recur(n.left, prev)) return false;
	
		if(prev!=null && n.value<=prev) return false;
		//if(n.value>n.right.value) return false;
		prev=n.value;
		if(!sol2_recur(n.right, prev)) return false;
		
		return true;
	}
	static class Node{
		Node left;
		Node right;
		int value;
		
		Node(int v){
			this.value=v;
		}
	}
	
	public Node Build_Tree(){
		
		Node r=new Node(8);
		System.out.println("Start tree with root " +r.value);
		insert(r, 6);
		insert(r, 7);
		insert(r, 5);	
		insert(r, 10);
		insert(r, 9);
		insert(r, 11);
		
		return r;
	}
	
	public void insert(Node n, int v){
		if(n.value>=v){
			if(n.left==null){
				//System.out.println("  Inserted " + v + " to left of node " + n.value);
				n.left=new Node(v);
			}
			else insert(n.left, v);
		}
		else{
			if(n.right==null){
				//System.out.println("  Inserted " + v + " to right of node " + n.value);
				n.right=new Node(v);
			}
			
			else insert(n.right, v);
		}
	}

}
