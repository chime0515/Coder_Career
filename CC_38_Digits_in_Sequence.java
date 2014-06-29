
public class CC_38_Digits_in_Sequence {

	public static void main(String[] args) {
		// Position
		int p=1001;
		sol(p);
		//System.out.println((int)Math.pow(10, 2));
	}
	
	public static void sol(int p){
		
		int dig=1;
		int tmp=p;
		
		while(tmp>0){
			if(dig==1){
				tmp=tmp-(int)Math.pow(10, dig);
				if(tmp<=0){
					System.out.println("Ans:"+p);
					break;
				}
			}
			else{
				tmp=tmp-((int)Math.pow(10, dig-1)*9)*dig;
				if(tmp<0){
					tmp=tmp+(int)Math.pow(10, dig-1)*9*dig;
					break;
				}
			}
			dig++;
		}
		//System.out.println(dig +", " +tmp);
		
		int ans=tmp/dig+(int)Math.pow(10, dig-1);
		int bit=tmp%dig;
		//System.out.println(ans+", bit " +bit);
		int mask=1;
		for(int i=0; i<bit; i++) ans=ans/10;
		
		ans=ans%10;
		
		System.out.println("ANS: " +ans);
		
		
	}

}
