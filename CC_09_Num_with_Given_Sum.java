/*
 * Problem1: Given a sorted array and a sum. Find a pair eles == sum.
 * 
 * Problem2: Given an array, please determine whether it 
 * contains three numbers whose sum equals to 0.
 * 
 */
public class CC_09_Num_with_Given_Sum {

	public static void main(String[] args) {
		int[] a={1,2,4,7,11,15};
		int sum=15;
		// Expected ans=(4,11)
		problem1(a, sum);
	}

	public static void problem2(int a){
		
	}
	
	public static void problem1(int[] a, int sum){
		int p1=0;
		int p2=a.length-1;
		
		while(p1<=p2){
			if((a[p1]+a[p2])==sum){
				System.out.println("Ans: " +a[p1] +" and " +a[p2]);
				return;
			}
			if(a[p1]+a[p2]>sum)
				p2--;
			else
				p1++;
		}
		System.out.println("Not find.");
	}
	
}
