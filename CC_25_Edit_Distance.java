
public class CC_25_Edit_Distance {

	static int[][] table=new int[30][30];
	public static void main(String[] args) {
		
		String s1="Saturday";
		String s2="Sunday";
		//System.out.println(s1.charAt(1));
		sol(s1, s2);
	}

	public static void sol(String s1, String s2){
		
		for(int i=0; i<table.length; i++)
			table[i][0]=i;
		
		for(int j=0; j<table.length; j++)
			table[0][j]=j;
		
		for(int i=1; i<s2.length(); ++i){	
			for(int j=1; j<s1.length(); ++j){
				if(s1.charAt(j-1)==s2.charAt(i-1)){
					table[i][j]=table[i-1][j-1];
				}
				else{		
					int min=Math.min(table[i-1][j], table[i][j-1]);
					table[i][j]=Math.min(min, table[i-1][j-1])+1;
				}	
			
			}
		}
		
		System.out.println(table[s2.length()-1][s1.length()-1]);
	}
}
