
public class CC_19_Left_Rotation_String {

	public static void main(String[] args) {

		int num=2;
		String s="abcdefg";
		// Should be "cdefgab"
		System.out.print("Sol1:");
		sol(s, num);
		System.out.print("Sol2 Reverse twice:");
		sol2_reverse(s, num);
		//System.out.println(s.substring(2)+s.substring(0, 2));

	}
	
	public static void sol(String s, int num){
		
		int len=s.length();
		num=num%len;
		String t=s.substring(num)+s.substring(0, num);
		System.out.println(t);
	}

	public static void sol2_reverse(String s, int num){
		
		int len=s.length();
		num=num%len;
		String ans=reverse(s, 0, len-1);
		//System.out.println(ans);
		String s1=reverse(ans, 0, len-num-1);
		String s2=reverse(ans, len-num, len-1);
		System.out.println(s1+s2);
		
		
	}
	public static String reverse(String s, int b, int e){
		char[] c=s.toCharArray();
		int bb=b;
		int ee=e;
		//System.out.println(c[2]);
		while(b<=e){
			char tmp;
			tmp=c[b];
			c[b]=c[e];
			c[e]=tmp;
			b++; 
			e--;
		}
		String ss = "";
		for(int i=bb; i<=ee; i++){
			ss=ss+c[i];
		}
		return ss;
	}
}
