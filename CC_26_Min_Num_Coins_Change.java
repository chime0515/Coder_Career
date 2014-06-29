
public class CC_26_Min_Num_Coins_Change {

	static int[] table=new int[100];
	
	public static void sol1(int c, int[] coins){
		
		table[0]=0;
		int min=9999; // Set this to max value for default
		
		for(int i=1; i<=c; i++){
			for(int j=0; j<coins.length; j++){
				if(i-coins[j]>=0){
					if(min>table[i-coins[j]]+1){	
						min=table[i-coins[j]]+1;
					}
				}
				table[i]=min;
			}
			min=9999;
		}
		System.out.println(table[c]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c=15;
		int[] coins={1,3,9,10};
		
		sol1(c,coins);
		
	}

}
