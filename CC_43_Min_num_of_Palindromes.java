
public class CC_43_Min_num_of_Palindromes {

	static int[] answer=new int[100];
	static boolean[][] table= new boolean[20][20];
	
	public static int sol1(String s){
	
		int len=s.length();
		int[] answer=new int[len];
		for(int i=0; i<len; i++) answer[i]=0;
		
		
		return answer[len-1];
		
	}
	
	public static int sol2(String s){
		
		int len=s.length();
		//int[] answer=new int[len];
		//System.out.println(len);
		for(int i=0; i<len; i++)
			answer[i]=i;
		
		for(int i=1; i<len; ++i){
			if(isPalin(s, 0, i)){
				answer[i]=0;
				//System.out.println("hi:"+answer[i]);
			}
			else{
			for(int j=0; j<i; ++j){
				if(isPalin(s, j+1, i)){// && answer[i]>answer[j]+1){
					//answer[i]=answer[j]+1;
					answer[i]=Math.min(answer[i], answer[j]+1);
				}
			}
			}
		}
		
		return answer[len-1];
		
	}
	
	public static void main(String[] args) {
	
		String s="abbaacba";
		String s2="abbac";
		//char[] c=s.toCharArray();
		isPalin2(s2,0,3);
		System.out.println(Check_table(1,2));
		
		int a = sol2(s);
		System.out.println(a);
	}

	public static boolean Check_table(int b, int e){
		return table[b][e];
	}
	// Save to table so won't do for loop every time when checking Palindrome
	public static boolean isPalin2(String s, int b, int e){
		
		char[] c=s.toCharArray();
		
		for(int i=b; i<e-i+b; ++i){
			if(c[i]!=c[e-i+b])
				table[i][e-i+b]=false;
			else
				table[i][e-i+b]=true;
		}
		
		return table[b][e];
	}
	
	public static boolean isPalin(String s, int b, int e){
			
		char[] c=s.toCharArray();
		
		for(int i=b; i<e-i+b; ++i){
			if(c[i]!=c[e-i+b])
				return false;	
		}
		
		return true;
	}
	
}
