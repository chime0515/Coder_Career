import java.util.*;


public class Stack_min_solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Test for java stack class
		Stack st = new Stack();
		st.push(1);
		st.push("a");
		System.out.println("Stack:"+st);
		*/
	
		/*
		Stack st=new Stack();
	    String a="a";   
	    st.push(a);   
	    String c="c";   
	    st.push(c);
	    String b="b";   
	    st.push(b);
	    
	    System.out.println(st.peek());
	    while(!st.empty()){
	    	System.out.println(st.pop()); 
	    }*/
		
		getmin gtm = new getmin();
		int [] inputarray = {3,4,2,1};
		for(int i=0; i<inputarray.length;i++){
			System.out.println("Push:"+inputarray[i]);
			gtm.push(inputarray[i]);
			System.out.println("DataStack: "+gtm.datastack);
			System.out.println("MIN is: "+gtm.min()+"\n");
		}
		
		
		System.out.println("Pop: "+1);
		gtm.pop();
		System.out.println("DataStack: "+gtm.datastack);
		System.out.println("MIN is: "+gtm.min()+"\n");
		
		System.out.println("Pop: "+2);
		gtm.pop();
		System.out.println("DataStack: "+gtm.datastack);
		System.out.println("MIN is: "+gtm.min()+"\n");
		
		System.out.println("Push: "+0);
		gtm.push(0);
		System.out.println("DataStack: "+gtm.datastack);
		System.out.println("MIN is: "+gtm.min()+"\n");
		

	}

}



class getmin{
	Stack datastack = new Stack();
	private int min;
	public getmin(){
		
	}
	
	public void push(int input){
		if(datastack.empty()){
			datastack.push(input);
			min = input;
		}
		else if(input >= min){
			datastack.push(input);
		}
		else if(input < min){
			int temp = 2*input-min;
			datastack.push(temp);
			min = input;
		}
	}
	
	public void pop(){
		if(!datastack.empty()){
			int top = (Integer)datastack.peek();
			if(top >= min){
				datastack.pop();
			}
			else{
				datastack.pop();
				min = 2*min-top;
			}
		}
		else
			System.out.println("Stack is empty");
	}
	
	
	public int min(){
		return min;
	}
	
	public int peek(){
		int top = (Integer)datastack.peek();
		if(top>= min){
			return top;
		}
		else
			return min;
	}	
	
}



