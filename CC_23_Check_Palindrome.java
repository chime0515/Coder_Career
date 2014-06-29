
public class CC_23_Check_Palindrome {

	public static void main(String[] args) {

		int n=882377;
		boolean ans=is_palindrome(n);
		System.out.println(ans);
		
	}

	// Goal: Read only half of stream and know is palindrome or not 
	public static boolean is_palindrome(int n){
		
		int tmp=0;
		while(n>tmp){
		//while(Math.abs(tmp-n)>=99){
			if(n/10==tmp){ // include n=0~9
				System.out.println("Im here");
				return true;
			}
			else{
				tmp=n%10+tmp*10;
				n=n/10;
				if(tmp==n){
					System.out.println("n:" +n +", tmp:" +tmp);
					return true;
				}
			}	
		}
		System.out.println("n:" +n +", tmp:" +tmp);
		return false;
	}
}
