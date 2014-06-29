
public class CC_22_Turning_Number_in_Array {

	public static void main(String[] args) {
	
		int[] a={1,2,3,4,5,6,4,3,2};

		sol_binary_search(a);
		
	}

	public static void sol_binary_search(int[] a){
		
		int mid=a.length/2;
		while(true){
			if(a[mid]>a[a[mid-1]] && a[mid]<a[mid+1]){
				mid=mid+(len-mid)/2;
			}
		
		}
		
	}
}
