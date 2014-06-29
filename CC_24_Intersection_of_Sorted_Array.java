import java.util.Iterator;


public class CC_24_Intersection_of_Sorted_Array {

	public static void main(String[] args) {

		int[] a1={1,4,7,10,13};
		int[] a2={1,3,5,7,9};
		//Expected Ans {1,67}
		
		System.out.println("Sol1 O(m+n):");
		sol1(a1, a2);
		System.out.println("\n\nSol2 Binary Search O(nlogm):");
		sol2_binary_search(a1, a2);

	}
	// O(m+n)
	public static void sol1(int[] a1, int[] a2){
		
		int index1=0;
		int index2=0;
		
		while(index1<a1.length && index2<a2.length){
			if(a1[index1]==a2[index2]){
				System.out.print(a1[index1] +" ");
				index1++;
				index2++;
			}
			else if(a1[index1]>a2[index2])
				index2++;
			else
				index1++;
		}	
	}
	// O(nlogm) Binary Search
	
	public static void sol2_binary_search(int[] a1, int[] a2){
		for(int i=0; i<a2.length; i++){
			binary_search(a1, a2[i]);
		}
	}
	
	public static void binary_search(int[] a1, int v){
		
		int b=0;
		int e=a1.length-1;
		while(b<=e){
			int mid=b+(e-b)/2;
			if(a1[mid]==v){
				System.out.print(v +" ");
				break;
			}
			else if(a1[mid]>v){
				e=mid-1;
			}
			else{
				b=mid+1;
			}
		}
	}

}
