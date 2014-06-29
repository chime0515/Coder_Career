/*
 * 	  10
 *  5	 13
 * 3 6
 * 
 */
public class CC_45_Closest_Node_in_BST{

	public static void main(String[] args) {
		Node r=new CC_45_Closest_Node_in_BST().Build_Tree();
		
		int v=4;
		
		System.out.println(sol(r, v).value);
	}
	
	public static Node sol(Node n, int v){
		if(n==null) return null;
		
		Node closest=n;
		int minDist=Integer.MAX_VALUE;
		Node tmp=n;
		
		while(tmp!=null){
			int curDist=Math.abs(tmp.value-v);
			if(curDist==0)
				return tmp;
			
			if(curDist<minDist){
				minDist=curDist;
				closest=tmp;
				
			}
			
			if(v>tmp.value)
				tmp=tmp.right;
			else{
				tmp=tmp.left;
			}
			
		}
		System.out.println("Cloesest Node: "+closest.value);
		return closest;
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
		
		Node r=new Node(10);
		System.out.println("Start tree with root " +r.value);
		insert(r, 5);
		insert(r, 6);
		insert(r, 3);	
		insert(r, 13);
		System.out.println("In-Order");
		print_inorder(r);
		System.out.println();
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

	public void print_inorder(Node n){
		if(n==null) return;
		
		print_inorder(n.left);
		System.out.print( n.value +" -> ");
		print_inorder(n.right);
		
	}
}
