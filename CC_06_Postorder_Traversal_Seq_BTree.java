/*Good example to practice recursive*/
import java.util.*;

public class CC_06_Postorder_Traversal_Seq_BTree {

	public static void main(String[] args) {
		
		//Node r=new CC_06_Postorder_Traversal_Seq_BTree().Build_Tree();
		//postorder(r);
		System.out.println();
		//int[] a={5,7,6,9,11,10,8}; //True
		//int[] a={6,9,11,10,8}; //True
		int[] a={7,4,6,5}; //False
		
		boolean ans=sol2(a, 0, a.length-1);
		System.out.println(ans);
		
	}
	
	public static boolean sol2(int[] a, int b, int e){
		
		if(b<0 || e<0 || e<=b) return true;
		
		int p=find_position(a[e], b, e, a);
		//System.out.println(p);
		
		boolean l=check_left(a[e], a, b, p);
		boolean r=check_right(a[e], a, p, e);
		//System.out.println(l);
		//System.out.println(r);
		
		return l && r && sol2(a,b, p-1) && sol2(a, p, e-1);
	}
	
	
	public static boolean check_left(int v, int[] a, int b, int e){
		for(int i=b; i<e; i++){
			if(a[i]>v)
				return false;
		}
		return true;
	}
	public static boolean check_right(int v, int[] a, int b, int e){
		for(int i=b; i<e; i++){
			if(a[i]<v)
				return false;
		}
		return true;
	}
	public static int find_position(int v,int b, int e,int[] a){
		for(int i=b; i<=e; i++){
			if(a[i]>=v)
				return i;
		}
		
		return a.length-1;
	}
	
	public static void postorder(Node n){
		
		if(n==null)
			return;
		
		postorder(n.left);
		postorder(n.right);
		System.out.print(n.value +"->");
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
		//insert(r, 7);
		//insert(r, 5);	
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
