
public class CC_32_Remove_Num_in_Array {

	public static void main(String[] args) {
		
		int num=2;
		int[] a= {4, 3, 2, 1, 2, 3, 6};
		sol(a, num);

	}
	public static void sol(int[] a, int num){
		int i=0;
		int j=a.length-1;
		int counter=0;
		
		while(i<j){
			while(a[i]!=num && i<a.length)
				i++;
			while(a[j]==num && j>=0)
				j--;
				
			// swap
			if(i<j){
				a[i]=a[j];
				a[j]=num;
				counter++;
			}
		}
		
		for(int k=0; k<a.length-counter; k++)
			System.out.print(a[k]+"->");
	}

}
