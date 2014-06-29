 import java.util.*;

/*Using preoder to solve it*/

public class CC_04_Path_Specified_Sum_in_Btree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node r=new CC_04_Path_Specified_Sum_in_Btree().Build_Tree();

		ArrayList<Node> a=new ArrayList<Node>();
		int sum=22;
		preorder(r,a,sum);
		
	}
	
	public static void preorder(Node n, ArrayList<Node> a,int sum){
		
		if(n==null)
			return;
		
		a.add(n);
		boolean is_leaf=n.left==null && n.right==null;
		if(is_leaf&&sum==add_array(a)){
			print_path(a);
			//System.out.println("FIND");	
		}
		
		preorder(n.left,a,sum);
		preorder(n.right,a,sum);
		a.remove(a.size()-1);
	}
	
	public static int add_array(ArrayList<Node> a){
		int sum=0;
		for(int i=0; i<a.size(); i++){
			sum=a.get(i).value+sum;
		}
		return sum;
	}
	
	public static void print_path(ArrayList<Node> a){
		for(int i=0; i<a.size(); i++)
			System.out.print(a.get(i).value+"->");
		System.out.println();
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
		insert(r, 7);
		insert(r, 4);	
		insert(r, 12);
		
		return r;
	}
	
	public void insert(Node n, int v){
		if(n.value>=v){
			if(n.left==null){
				System.out.println("  Inserted " + v + " to left of node " + n.value);
				n.left=new Node(v);
			}
			else insert(n.left, v);
		}
		else{
			if(n.right==null){
				System.out.println("  Inserted " + v + " to right of node " + n.value);
				n.right=new Node(v);
			}
			
			else insert(n.right, v);
		}
	}
	

}
