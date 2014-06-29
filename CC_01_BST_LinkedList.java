/* Sol1 is not good
 * Cuz it is recursive.
*/
import java.util.*;


public class CC_01_BST_LinkedList {

	static Stack<Node> s=new Stack<Node>();
	
	public static void main(String[] args) {
		
		Node n=new CC_01_BST_LinkedList().Build_Tree();
	
		build_stack(s, n);
		
		
		Link head=new Link(Get_Next(s).value);

		/*
		Sol1(head, Get_Next(s).value,s);
		*/
		
		Link prev=head;
		Link current=null;
		
		while(!s.isEmpty()){
		    Node tmp=null;
			tmp=Get_Next(s);
			if(tmp!=null){
				current=Sol2(prev, tmp.value);
				prev=current;
				//System.out.println(tmp.value);
			}
			
		}
		
		// Using 2 for loop to examine if it's double link
		Check_Answer(head);

	}

	static public Link Sol2(Link prev, int v){
		
		Link current = new Link(v); 
		if(current.prev==null){
			current.prev=prev;
		}
		if(prev.next==null){
			prev.next=current;
		}
		
		return current;
	}
	
	/*Sol1 is not good becuase its recursive.*/
	static public void Sol1(Link prev, int v, Stack<Node> s){
		
		Link current = new Link(v); 
		if(current.prev==null){
			current.prev=prev;
		}
		if(prev.next==null){
			prev.next=current;
		}
		
	    Node tmp=null;
		tmp=Get_Next(s);
		
		if(tmp!=null){
			Sol1(current, tmp.value, s);
		}
		
	}
	
	
	static public Node Get_Next(Stack<Node> s){
		Node next=null;
		if(!s.isEmpty()){
			next=s.pop();
			Node r=next.right;
			
			while(r!=null){
				s.push(r);
				r=r.left;
			}
		}
		//System.out.println("Get_Next:"+next.value);
		return next;
	}
	
	static public void build_stack(Stack<Node> s, Node n){
		if(n!=null){
			while(n!=null){
				s.push(n);
				n=n.left;
			}
		}		
		//System.out.println(s.peek().value);
	}
	

	
	static class Link{
		Link next;
		Link prev;
		int data;
		
		Link(int v){
			this.data=v;
			next=null;
			prev=null;
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
		
		Node r=new Node(10);
		System.out.println("Start tree with root " +r.value);
		insert(r, 6);
		insert(r, 4);
		insert(r, 8);	
		insert(r, 14);
		insert(r, 12);
		insert(r, 16);
		
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

	static void Check_Answer(Link head){
		Link tmp=head;
		while(tmp!=null){
			System.out.print(tmp.data+"->");
			if(tmp.next!=null)
				tmp=tmp.next;
			else 
				break;
		}
		System.out.println();
		while(tmp!=null){
			System.out.print(tmp.data+"->");
			tmp=tmp.prev;
		}
		
	}
}
