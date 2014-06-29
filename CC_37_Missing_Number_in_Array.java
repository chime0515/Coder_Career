
public class CC_37_Missing_Number_in_Array {

	
	public static void main(String[] args) {

		Integer[] a={0,4,1,5,2,3,7};
	
		sol(a);
		sol_xor(a);
	}

	// Louis
	public static void sol(Integer[] a){
		int out=0;
		for(int i=0; i<a.length; i++){
			if(a[i]!=i){
				try{
					int tmp=a[a[i]];
					a[a[i]]=a[i];
					a[i]=tmp;
				}
				catch(Exception ex){
					out=a[i];
				}
			}
		}
		
		for(int i=0; i<a.length; i++)
			if(a[i]==out)
				System.out.println(i);
	}
	
	public static void sol_xor(Integer[] a){
		int ans=0;
		for(int i=0; i<a.length; i++){
			ans=ans^i;
			ans=ans^a[i];
		}
		ans=ans^(a.length);
		System.out.println(ans);
		//for(int i=0; i<a.length; i++){
			
		
	}
}
