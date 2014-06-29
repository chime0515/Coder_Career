import java.util.Iterator;


public class CC_14_Last_Number_in_Circle {

	public static void main(String[] args) {
		
		int m=3;
		
		int[] a={0,1,2,3,4};
		my_LinkedList head=new my_LinkedList(0);
		int link_size=1+a.length;
		
		insert(a, head);
		//print_link(head, link_size);
		//sol1(head, link_size, m);
		sol2_DP(a.length,m);
	}
	public static void sol2_DP(int n, int m){
		if(n<1 || m<1)
			return;
		int last=0;
		for(int i=2; i<=n; i++){
			last=(last+m)%i;
		}
		
		System.out.println(last);
	}

	public static void sol1(my_LinkedList head, int link_size, int m){
		
		if(link_size==1){
			System.out.println(head.value);
			return;
		}
		my_LinkedList tmp=head;
		
		while(link_size!=1){
		
			for(int i=0; i<m-2; i++)
				tmp=tmp.next;
			tmp.next=tmp.next.next;
			link_size=link_size-1;
			
		}
		
		System.out.println(tmp.value);

	}
	
	// insert value and make it to a loop linkedlist
	public static void insert(int[] a, my_LinkedList head){
		my_LinkedList tmp=head;
		for(int i=0; i<a.length; i++){
			my_LinkedList tmp2=new my_LinkedList(a[i]);
			tmp.next=tmp2;
			tmp=tmp2;	
		}
		// tail to head = loop
		tmp.next=head;
	}
	
	public static void print_link(my_LinkedList head, int link_size){
		my_LinkedList tmp=head;
		for(int i=0; i<link_size; i++){
			System.out.print(tmp.value +"->");
			tmp=tmp.next;
		}
	}
	
}

class my_LinkedList{
	int value;
	my_LinkedList next;
	my_LinkedList(int v){
		this.value=v;
		this.next=null;
	}
	
	
}