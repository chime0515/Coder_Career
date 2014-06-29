import java.util.LinkedList;
import java.util.Queue;

public class CC_12_Mirror_Tree {
	static Queue<Node> q= new LinkedList<Node>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n=new CC_12_Mirror_Tree().Build_Tree();
		BFS(q, n);
		System.out.println();
		Mirror(n);
		q.clear();
		BFS(q,n);
	}


	static public void Mirror(Node n){
		
		if(n==null)
			return;
		
		Node tmp=null;
		tmp=n.left;
		n.left=n.right;
		n.right=tmp;				
		
		Mirror(n.left);
		Mirror(n.right);
	}

	static void BFS(Queue<Node> q, Node n){

		if(n!=null)
			q.add(n);
		while(!q.isEmpty()){
			Node tmp=q.poll();
			System.out.print(tmp.value +"->");
			if(tmp.left!=null)
				q.add(tmp.left);
			if(tmp.right!=null)
				q.add(tmp.right);			
		}
		
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
