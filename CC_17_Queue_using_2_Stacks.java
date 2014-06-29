
public class CC_17_Queue_using_2_Stacks {

	static my_stack s1=new my_stack(10);
	static my_stack s2=new my_stack(10);
	public static void main(String[] args) {
/*
		my_stack s = new my_stack(10);
		s.push(5);
		s.push(3);
		s.pop();
		s.push(15);
		s.print();
		*/
		sol();
	}
	
	public static void sol(){
		appendTail(1);
		appendTail(2);
		appendTail(3);
		appendTail(4);
		appendTail(5);
		System.out.println("Delete 1");
		deleteHead();
		System.out.println("Delete 2");
		deleteHead();
	}
	
	public static void appendTail(int v){
		if(s1.isEmpty() && s2.isEmpty()){
			s1.push(v);
			s1.print();
		}
		
		/*else if(s1.isEmpty()){
			s2.push(v);
			s2.print();
		}*/
		else{
			s1.push(v);
			s1.print();
		}
	}
	
	public static void deleteHead(){
		if(s1.isEmpty()&&s2.isEmpty()){
			System.out.println("Queue is empty.");
			return;
		}
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
			s2.pop();
			s2.print();
		}
		else{
			s2.pop();
			s2.print();
		}
			
	}

}

class my_stack{
	private int[] stack;
	private int size;
	private int top;
	my_stack(int v){
		this.size=v;
		this.stack=new int[this.size];
		this.top=-1;
	}
	
	public void push(int v){
		if(this.top>size)
			System.out.println("Out of boundary");
		else{
			top=top+1;
			stack[top]=v;
		}
	}
	
	public Integer pop(){
		if(top<0)
			return null;
		else{
			int v=this.stack[top];
			top=top-1;
			return v;
		}
	}
	public Boolean isEmpty(){
		if(this.top==-1) return true;
		else return false;
	}
	public void print(){
		//System.out.println("Top to bottom");
		for(int i=top; i>=0; i--){
			System.out.print(this.stack[i] +"->");
		}
		System.out.println();
	}
	
}
