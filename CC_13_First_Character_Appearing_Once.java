import java.util.*;
import java.util.Map.Entry;


public class CC_13_First_Character_Appearing_Once {


	public static void main(String[] args) {
		
		String s="pbcxaacb";
		
		sol_hashmap(s);
	}

	public static void sol_hashmap(String s){
		
		char[] c=s.toCharArray();
		HashMap<Character, Integer> map=new LinkedHashMap<Character, Integer>();
		
		// Put each char into map
		for(int i=0; i<c.length; i++){
			Integer tmp=map.get(c[i]);
			if(tmp!=null)
				map.put(c[i], tmp+1);
			else
				map.put(c[i], 1);
		}
	
		for (Entry<Character, Integer> entry : map.entrySet()){
		    //System.out.println(entry.getKey() + "/" + entry.getValue());
			if(entry.getValue()==1){
				System.out.println(entry.getKey() +"/" +entry.getValue());
				break;
			}
		}
	}
}
