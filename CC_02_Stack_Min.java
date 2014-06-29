import java.util.*;
/* Only have solution #1
 * When pop and push ele to stack, use another stack 'min'
 * to track the min value of the all stack;
 * */
public class CC_02_Stack_Min{
	
	myStack s=new myStack(10);
	myStack m=new myStack(10);
	
	public void push(int v){
		s.push(v);
		if( m.peek()==null || v<m.peek())
			m.push(v);
	}
	
	public Integer pop(){
		int i=s.pop();
		if(i==m.peek()){
			m.pop();
		}
		return i;
	}
	
	public Integer Min(){
		return m.peek();
	}
	
	public void display(){
		System.out.print("Ori:");
		s.print_stack();
		System.out.println();
		System.out.print("Min:");
		m.print_stack();
		System.out.println();
	}
	
	public static void sol1(){
		CC_02_Stack_Min min=new CC_02_Stack_Min();
		min.push(10);
		min.push(6);
		min.push(11);
		min.push(12);
		min.push(8);
		min.push(3);
		min.push(7);
		min.pop();
		min.pop();
		System.out.println("Top Down");
		min.display();
		System.out.println("Min#: " +min.Min());
	}
	

	public static void main(String[] args) {

		sol1();
			
	}

}
class myStack{
	private int[] s;
	private int size;
	private int top;
	
	public myStack(int v){
		size=v;
		s=new int[size];
		top=-1;
	}
	
	public void Create_Stack(int i){
		size=i;
		s=new int[i];
		top=-1;
	}
	
	public void push(int v){
		
		if(top==size) 
			System.out.println("Stack is full.");
		else{
			top=top+1;
			s[top]=v;
		}
	}
	
	public Integer pop(){
		int v=-1;
		if(top<0)
			System.out.println("Empty.");
		else{
			v=s[top];
			top--;
		}	
		return v;
	}
	
	public Integer peek(){
		if(this.top==-1)
			return null;
		return s[top];
	}
	
	public void print_stack(){
		
		for(int i=top; i>=0; i--){
			System.out.print(s[i]+"->");
		}
			
	}
}