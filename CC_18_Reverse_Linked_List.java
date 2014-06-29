/* Create my own LinkedList data structure
 * 
 * 
 * */


public class CC_18_Reverse_Linked_List {

	public static void Reverse(My_Link head){
		
		My_Link prev=null;
		My_Link curr=head;
		My_Link next=head.next;
		
		while(next!=null){
			curr.next=prev;
			prev=curr;
			curr=next;
			next=next.next;
		}
		
		if(next==null){
			curr.next=prev;
			prev=curr;
		}
		System.out.println("Reverse:");
		display(curr);
	}
	
	
	public static void display(My_Link head){
		My_Link tmp=head;
		while(tmp!=null){
			System.out.print(tmp.data +"->");
			tmp=tmp.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
	
		My_Link head=new My_Link(10);
		head.add(11);
		head.add(15);
		head.add(9);
		head.add(13);
		head.display(head);
		head=head.remove(13, head);
		head.display(head);
		head.add(4);
		head.add(6);
		System.out.println("Original:");
		head.display(head);
		
		Reverse(head);
		

	}

}

class My_Link{
	int data;
	My_Link next;
	
	My_Link(Integer i){
		this.data=i;
		this.next=null;
	}
	
	public void add(Integer v){
		My_Link tmp=this;
		while(tmp.next!=null){
			tmp=tmp.next;
		}
		
		My_Link l=new My_Link(v);
		tmp.next=l;
	}
	
	public My_Link remove(Integer v, My_Link head){
		My_Link cur=head;
		if(head.data==v){
			head=head.next;
			return head;
		}
		
		while(cur.next!=null){
			if(v==cur.next.data){
				System.out.println("Remove:"+v);
				cur.next=cur.next.next;
				//return head;
				break;
			}
			cur=cur.next;
		}
		return head;
	}
	
	public void display(My_Link head){
		My_Link tmp=head;
		while(tmp!=null){
			System.out.print(tmp.data +"->");
			tmp=tmp.next;
		}
		System.out.println();
	}
}