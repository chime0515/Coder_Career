/*
 * Transfer to bit 
 * */
public class CC_50_Num_Appearing_Once {

	public static void main(String[] args) {
		
		int[] a={1,1,1,4,3,4,3,2,3,4};
		//ANSWER IS 2
		//System.out.println(1<<1);
		sol(a);

	}
	public static void sol(int[] a){
		
		
		int[] bitSum=new int[32];
		
		//Initialize
		for(int i=0; i<bitSum.length; i++){
			bitSum[i]=0;
		}
		
		for(int i=0; i<a.length; i++){
			int bitMask=1;
			for(int j=31; j>=0; j--){
				int bit=a[i]&bitMask;
				
				if(bit!=0) 
					bitSum[j]=bitSum[j]+1;
				
				bitMask=bitMask<<1;
			}
			
		}
		// Now lets see bitSum
		int ans=0;
		for(int i=0; i<bitSum.length; ++i){		
			ans=ans+bitSum[i]%3;
			ans=ans<<1;
		}
		/* **** Remember to shift one more time back !!!*/
		ans=ans>>1;
		System.out.println(ans);
	}

}
