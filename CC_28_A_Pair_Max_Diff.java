public class CC_28_A_Pair_Max_Diff {
	static int[] a={2,4,1,16,7,5,11,9};
	//static int[] a={2,4,1,5};
	public static void main(String[] args) {
	
		sol1(a);
		//sol2(a);
		
	}
	
	public static void sol1(int[] a){
		
		mm m=new mm(0,0);
		int tmp=sol1_recur(0, a.length-1, m);
		System.out.println(tmp);
	}
	
	public static int sol1_recur(int b, int e, mm m){
		// Only 1 element
		if(b==e){
			m.max=a[b];
			m.min=a[b];
			return 0;
		}
		int mid=b+(e-b)/2;

		// Divide
		mm l=new mm(0, 0);
		int left_diff=sol1_recur(b, mid, l);
		mm r=new mm(0,0);
		int right_diff=sol1_recur(mid+1, e, r);

		int cross_diff=l.max-r.min;
		
		// Record the max and min in both side
		m.max= Math.max(l.max, r.max);
		m.min= Math.min(l.min, r.min);

		int ans=(left_diff> right_diff) ? left_diff : right_diff;
		ans=Math.max(ans, cross_diff);

		return ans;
	}
	
	public static void sol2(int[] a){
		
		if(a.length<2) return;
		
		// Just initialize
		int max_diff=a[0]-a[1];
		int cur_max=a[0];
		int index_max=0;
		int index_min=0;
		
		for(int i=1; i<a.length;i++){
			if(cur_max-a[i]>max_diff){
				max_diff=cur_max-a[i];
				index_min=i;
			}
			// Update current max if necessary	
			if(cur_max<a[i]){
				cur_max=a[i];
				index_max=i;
			}
		}
		
		System.out.println(max_diff);
		System.out.println("Pair:" +a[index_max] +"," +a[index_min]);
	}

}
class mm{
	int max;
	int min;
	mm(int max, int min){
		this.max=max;
		this.min=min;
	}
}