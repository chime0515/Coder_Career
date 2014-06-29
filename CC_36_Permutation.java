
public class CC_36_Permutation {

	public static void main(String[] args) {

		char[] c={'a', 'b', 'c', 'e'};
		//sol(c,0);
		System.out.println(97&98);
		
	}

	public static void sol(char[] c, int b){
		
		if(b==c.length-1) 
			print(c);
		
		else{
			for(int i=b; i<c.length; i++){
				
				char tmp=c[i];
				c[i]=c[b];
				c[b]=tmp;
				
				sol(c, b+1);
				// Swap Back
				tmp=c[i];
				c[i]=c[b];
				c[b]=tmp;
				
			}
		}
	}
	
	public static void print(char[] c){
		for(int i=0; i<c.length; i++)
			System.out.print(c[i]);
			
		System.out.println();
	}
}
