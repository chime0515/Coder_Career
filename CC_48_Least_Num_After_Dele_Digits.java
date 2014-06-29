import java.util.ArrayList;


public class CC_48_Least_Num_After_Dele_Digits {

	public static void main(String[] args) {
		
		int n=24635;
		int k=3;

		sol(n, k);
	}

	public static void sol(Integer n, int k){
		char[] c=String.valueOf(n).toCharArray();
		ArrayList<Character> al=new ArrayList<Character>();
		
		for(int i=0; i<c.length; i++)
			al.add(c[i]);
	
		System.out.println(al);
		
		for(int i=0; i<k; i++){
			int tp=findTurnPt(al);
			System.out.println("Remove: " +al.get(tp));
			al.remove(tp);
		}
		System.out.println(al.toString());
		
	}
	
	public static char[] copy(int tp, char[] tmp, char[] c, int b, int e){
		
		for(int i=b; i<=e; i++){
			
		}
		
		return tmp;
	}
	
	public static int findTurnPt(ArrayList<Character> al){
		
		for(int i=0; i<al.size()-1;i++){
			if(al.get(i)>al.get(i+1))
				return i;
		}
		return al.size()-1;
	}
	
}
