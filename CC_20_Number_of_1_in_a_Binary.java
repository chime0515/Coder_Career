
public class CC_20_Number_of_1_in_a_Binary {

	public static void main(String[] args) {

		int n=9;
		//System.out.println(13&4);
		sol(n);
		sol2(n);
	}

	public static void sol(int n){
		int counter=0;
		int mask=1;
		while(mask>=0){
			if((n&mask)>0)
				counter++;
			mask=mask<<1;
		}
		System.out.println("Sol1: "+counter);
	}
	
	public static void sol2(int n){
		int counter=0;
		while(n>0){
			counter++;
			n=n&(n-1);
		}
		System.out.println("Sol2: " +counter);
	}
}
