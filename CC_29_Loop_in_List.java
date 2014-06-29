
public class CC_29_Loop_in_List {

	public static void main(String[] args) {

		int[] a={1,2,3,4,5,6};
		Link head=insert(a);
		Link meet_pt=q1(head);
		if(meet_pt!=null){
			q2(meet_pt, head);
		}
	}

	public static void q2(Link meet_pt, Link head){
		// 1st: Get the loop size(n)
		Link tmp=meet_pt;
		int num_in_loop=1;
		while(tmp.next!=meet_pt){
			tmp=tmp.next;
			num_in_loop++;
		}
		//System.out.println("num_in_loop" +num_in_loop);
		
		Link tmp1=head;
		Link tmp2=head;
		// 2nd
		// Let tmp go ahead for n step, then move both tmp1 and tmp2, they will meet at entry;
		for(int i=0; i<num_in_loop; i++){
			tmp1=tmp1.next;
		}
		while(tmp1!=tmp2){
			tmp1=tmp1.next;
			tmp2=tmp2.next;
		}
		System.out.println("Entry: " +tmp1.value);
	}
	
	public static Link q1(Link head){
		
		Link fast=head;
		Link slow=head;
		int k=0;
		while(fast!=null || slow!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow){
				System.out.println("Find loop." +k);
				return slow;
			}
			k++;
		}
		
		System.out.println("No Loop");
		return null;
	}
	
	public static Link insert(int[] a){
		Link head=new Link(a[0]);
		Link cur=head;
		for(int i=1; i<a.length; i++){
			Link tmp=new Link(a[i]);
			cur.next=tmp;
			cur=cur.next;
		}
		
		//Make a loop to #3 here;
		cur.next=head.next.next;
		
		print(head, 8);
		return head;
	}
	
	public static void print(Link head, int size){
		Link tmp=head;
		for(int i=0; i<size; i++){
			System.out.print(tmp.value +"->");
			if(tmp.next!=null)
				tmp=tmp.next;
			else break;
		}
		System.out.println();
	}
}

class Link{
	int value;
	Link next;
	Link(int v){
		this.value=v;
		this.next=null;
	}
}
