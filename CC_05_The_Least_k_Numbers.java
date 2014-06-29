
public class CC_05_The_Least_k_Numbers {

	static int max=-1;
	//static int[] a={4, 5, 1, 6, 2, 7, 3, 8, -1};
	static int[] a={5, 4, 7, 2, 1, 9, 3, 6, 10, 8};
	static int k=4;
	public static void main(String[] args) {
			
		int[] container=new int[k];
		obj o= new obj(-100, -1);
		//sol1(a, container, o);
		sol2_quicksort(a, k);
		
	}

	public static void sol2_quicksort(int[] a, int k){
		quick_sort(a, 0, a.length-1);
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] +" ");
	}
	
	public static void quick_sort(int[] a, int left, int right){
		int i=left;
		int j=right;
		if(right==(k-1)){
			System.out.println("Sort only " +k +" elements");
			return;
		}
		int pivot=a[left+(right-left)/2];
		while(i<=j){
			
			while(a[i]<pivot)
				i++;
			
			while(a[j]>pivot)
				j--;
			if(i<=j){
				swap(a, i, j);
				i++;
				j--;
			}
		}
		
		if(left<j) quick_sort(a, left, j);
		if(i<right) quick_sort(a, i, right);
	}
	
	public static void swap(int[] a, int left, int right){
		int tmp=a[left];
		a[left]=a[right];
		a[right]=tmp;
	}
	
	public static void sol1(int[] a, int[] container, obj o){
		//initial container
		for(int i=0; i<4; i++)
			container[i]=a[i];
		
		o=find_max(container, o);
		System.out.println(o.max +" " + o.loc);
		
		for(int i=4; i<a.length; i++){
			o=find_max(container, o);
			if(a[i]<o.max){
				container[o.loc]=a[i];
			}
		}
		
		for(int i=0; i<container.length; i++)
			System.out.print(container[i] +"->");
	}
	
	public static int[] replace_max(int[] a){
			
		
		return a;
	}
	// find the max value in container
	public static obj find_max(int[] container, obj o){
		int max=-100;
		for(int i=0; i<container.length; i++){
			if(max<container[i]){
				max=container[i];
				o.max=container[i];
				o.loc=i;
			}
		}
		return o;
	}
	

}
class obj{
	int max;
	int loc;
	obj(int max, int loc){
		this.max=max;
		this.loc=loc;
	}
}