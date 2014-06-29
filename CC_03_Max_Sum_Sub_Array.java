import java.util.ArrayList;

public class CC_03_Max_Sum_Sub_Array {

	static int[] table=new int[100];
	
	public static void main(String[] args) {
		
		int[] a= {1, -2, 3, 10, -4, 7, 2, -5};
		// This will go WRONG!
		//int[] a={1,-8,-4};
		sol1_DP(a);

	}
	
	
	public static void sol1_DP(int[] a){
		
		table[0]=a[0];
				
		int max_sum=-100;
		int index_max=-1; // Record the max sum index;
		
		for(int i=1; i<a.length; i++){
			if(table[i-1]<=0){
				table[i]=a[i];		
			}
			else{
				table[i]=a[i]+table[i-1];
				
			}
			if(table[i]>max_sum){
				max_sum=table[i];
				index_max=i;
			}
		}
		
		System.out.println("Reverse Print");
		print_path(a, index_max);
		
	}


	
	public static void print_path(int[] a, int index){
		//USE minus!
		int sum=table[index];
		for(int i=index; sum!=0; i--){
			System.out.print(a[i]+" -> ");
			sum=sum-a[i];
		}
	}
	
}

