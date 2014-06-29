
public class CC_49_Longest_Substring_without_dup {
	public static void main(String[] args) {

		String s="thailandys";
		sol(s);
	}
	
	public static void sol(String s){
		//record the char if it appeared 
		int[] position=new int[26];
		for(int i=0; i<position.length; i++)
			position[i]=-1;

		int cur=0;
		int max=0;
		
		for(int i=0; i<s.length(); i++){
			int prev=position[s.charAt(i)-'a'];
			
			// i - prev: 上一次出現的距離，如果比cur大表示，目前走到的的長度不包含此字元，所以可以++
			if(prev<0 )//|| (i-prev)>cur)
				cur++;
			else if((i-prev)>cur)
				cur++;
			//a[i]~its prev is bigger-> update cur
			else{
				if(max<cur) max=cur;
				cur=i-prev;
			}
			position[s.charAt(i)-'a']=i;
		}
	
		if(max<cur) max=cur;
		System.out.println("Ans:" +max);
		
	}

}
