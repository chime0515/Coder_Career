


public class Stack_min_solution1 {
	private int count = 0;
	myStack datastack = new myStack();
	myStack minstack = new myStack();
	public void setsize(int size){
		datastack.Stackcreate(size);
		minstack.Stackcreate(size);
	}
	
	
	public void push(int input){
		if(count == 0 || input < minstack.peek()){
			datastack.push(input);
			minstack.push(input);
			count++;
		}
		else if(input > minstack.peek()){
			datastack.push(input);
			minstack.push(minstack.peek());
			count++;
		}
	}
	
	public void pop(){
		if(count != 0){
			datastack.pop();
			minstack.pop();
			count--;
		}
		else
			System.out.println("The stack is empty");
	}
	
	public int getmin(){
		return minstack.peek();
	}
	
	public int peek(){
		return datastack.peek();
	}
	
	public void display(){
		System.out.print("DataStack: ");
		datastack.displaystack();
		System.out.print("MinStack: ");
		minstack.displaystack();
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack_min_solution1 min = new Stack_min_solution1();
		min.setsize(4);
		
		System.out.println("push:3");
		min.push(3);
		min.display();
		System.out.println("The MIN is:"+min.getmin()+"\n");
		
		
		System.out.println("push:4");
		min.push(4);
		min.display();
		System.out.println("The MIN is:"+min.getmin()+"\n");
		
		
		System.out.println("push:2");
		min.push(2);
		min.display();
		System.out.println("The MIN is:"+min.getmin()+"\n");
		
		
		System.out.println("push:1");
		min.push(1);
		min.display();
		System.out.println("The MIN is:"+min.getmin()+"\n");
		
		
		System.out.println("POP:1");
		min.pop();
		min.display();
		System.out.println("The MIN is:"+min.getmin()+"\n");
		
		System.out.println("POP:2");
		min.pop();
		min.display();
		System.out.println("The MIN is:"+min.getmin()+"\n");
		
		System.out.println("push:0");
		min.push(0);
		min.display();
		System.out.println("The MIN is:"+min.getmin()+"\n");
		
		

	}

}

class myStack{
	private int [] stackarray;
	private int stacksize;
	private int top = -1;
	
	public myStack() {
	}
	
	
	public void Stackcreate(int size){
		stacksize = size;
		stackarray = new int[size];
		
	}
	
	public void push(int input){
		if((top+1) < stacksize){
			top = top+1;
			stackarray[top] = input;
			//System.out.println("Push"+stackarray[top]+"into stack");
		}
		else{
			System.out.println("The stack is full");
		}
	}
	
	public int pop(){
		if(top > -1){
			//System.out.println("Pop"+stackarray[top]+"out stack");
			top = top-1;
			return stackarray[top];
		}
		else{
			System.out.println("Stack is empty");
			return -1;
		}
	}
	
	public int peek(){
		
		//System.out.println("Top of the stack:"+stackarray[top]);
		return stackarray[top];
		
	}
	
	
	public void displaystack(){
		//System.out.print("From bottom to top: ");
		for(int i=0; i<= top; i++){
			System.out.print(stackarray[i]);
			
		}
		System.out.println();
	}
	
	
}
