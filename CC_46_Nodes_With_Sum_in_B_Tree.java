import java.util.Stack;

/*
 * 	  10
 *  5	 13
 * 3 6
 * 
 */
public class CC_46_Nodes_With_Sum_in_B_Tree {

	
	public static boolean Find_Sum(Node n, int sum){
		
		Stack<Node> nstack = new Stack<Node>();
		Stack<Node> pstack = new Stack<Node>();
		
		Build_Next_Stack(n, nstack);
		Build_Prev_Stack(n, pstack);
		
		Node pNext=Get_Next_Node(nstack);
		Node pPrev=Get_Prev_Node(pstack);
		//System.out.println(pNext.value);
		while(pNext!=null && pPrev!=null && pNext!=pPrev){
			int ans=pNext.value+pPrev.value;
			
			if(ans==sum)
				return true;
			if(ans<sum){
				pNext=Get_Next_Node(nstack);
			}
			else{
				pPrev=Get_Prev_Node(pstack);
			}
		}
		
		return false;
	}
	// Go to the small ele
	public static void Build_Next_Stack(Node n, Stack<Node> s){
		Node tmp=n;
		while(tmp!=null){
			s.push(tmp);
			tmp=tmp.left;
			
		}
			
	}
	// Go to the largetst ele
	public static void Build_Prev_Stack(Node n, Stack<Node> s){
		Node tmp=n;
		while(tmp!=null){
			s.push(tmp);
			
			tmp=tmp.right;
		}
	}
	
	public static Node Get_Next_Node(Stack<Node> stack_n){
		
		Node next=null;
		if(!stack_n.empty()){
			next=(Node) stack_n.peek();
			
			stack_n.pop();
			
			Node rnode=next.right;
			while(rnode!=null){
				stack_n.push(rnode);
				rnode=rnode.left;
			}
		}
		
		return next;
	}
	
	public static Node Get_Prev_Node(Stack<Node> stack_p){
		
		Node prev=null;
		if(!stack_p.empty()){
			prev=(Node)stack_p.peek();
			stack_p.pop();
			
			Node lnode=prev.left;
			while(lnode!=null){
				stack_p.push(lnode);
				lnode=lnode.right;
			}
		}
			
		return prev;
	}
	
	/*
	public static Node Get_Smallest_Node(Node n){
		if(n.left==null){
			return n;
		}
		return Get_Smallest_Node(n.left);
	}
	
	public static Node Get_Largest_Node(Node n){
		if(n.right==null)
			return n;
		
		return Get_Largest_Node(n.right);
	}
	*/
	public static void main(String[] args) {
		Node r=new CC_46_Nodes_With_Sum_in_B_Tree().Build_Tree();
		//System.out.println(Get_Smallest_Node(r).value);
		//System.out.println(Get_Largest_Node(r).value);
		boolean a = Find_Sum(r,24);
		System.out.println(a);
		
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
