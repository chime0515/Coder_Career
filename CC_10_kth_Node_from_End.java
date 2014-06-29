import java.util.LinkedList;

public class CC_10_kth_Node_from_End {

	public static void main(String[] args) {

		int k=4;
		myLink head=new myLink(0);
		
		for(int i=1; i<20; i++)
			head.insert(i);
		
		head.print();
		System.out.println();
		sol(head, k);
	}
	
	public static void sol(myLink h, int k){
		myNode p1=h.head;
		myNode p2=h.head;
		
		for(int i=0; i<k; i++)
			p1=p1.next;
		while(p1!=null){
			p1=p1.next;
			p2=p2.next;
		}
		
		System.out.println("Ans: "+p2.value);
	}

}
class myLink{
	
	myNode head;
	myLink(int v){
		this.head=new myNode(v);
	}
	
	public void insert(int v){
		myNode tmp=new myNode(v);
		myNode cur=head;
		while(cur.next!=null){
			cur=cur.next;
			//System.out.println(0);
		}
		cur.next=tmp;
	}
	
	public void print(){
		myNode tmp=this.head;
		System.out.println("Original LinkedList");
		
		while(tmp!=null){
			System.out.print(tmp.value +"->");
			tmp=tmp.next;
		}
		System.out.println();
	}
}
class myNode{
	int value;
	myNode next;
	myNode(int v){
		this.value=v;
		this.next=null;
	}
}