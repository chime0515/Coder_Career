/**
 * 
 * @author JohnnyWang
 *
 */
public class CC_07_Reverse_Word_in_Sentence {
	public static void main(String[] args) {

		String s="I am a student";
		//expected_ans="student a am I";

		sol(s);
		
	}

	public static void sol(String s){
		char[] c=String.valueOf(s).toCharArray();
		System.out.println(c);
		reverse(c, 0, c.length-1);
		
		//find space, and reverse again
		int start=0;
		int end=0;
		for(int i=0; i<c.length-1; i++){
			if(c[i]==' '){
				end=i-1;
				reverse(c, start, end);
				start=i+1;
			}
		}	
	}
	
	public static void reverse(char[] c, int b, int e){
		swap(c, b, e);
	}
	
	public static void swap(char[] c, int b, int e){
		while(b<e){
			char tmp= c[b];
			c[b]=c[e];
			c[e]=tmp;
			b++; 
			e--;
		}
	}
}
