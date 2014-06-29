import java.util.Stack;


public class CC_21_Push_and_Pop_Seq_of_Stacks {

	public static void main(String[] args) {

		int[] push={1,2,3,4,5};
		int[] pop={4,5,3,2,1};
		int[] pop2={4,3,5,1,2};
		boolean ans=sol(push, pop);
		System.out.println(ans);

	}
	
	public static boolean sol(int[] push, int[] pop){
		if(push.length!=pop.length)
			return false;
		
		Stack<Integer> s=new Stack<Integer>();
		int index_push=0;
		int index_pop=0;
		
		s.push(push[index_push]);
		index_push++;
		while(true){
			if(index_push==push.length) break;
			
			if(s.peek()!=pop[index_pop]){
				s.push(push[index_push]);
				index_push++;
			}
			else{
				s.pop();
				index_pop++;
			}
		}
		
		while(!s.isEmpty()){
			if(s.pop()!=pop[index_pop]) return false;
			index_pop++;
		}
		
		if(index_pop==pop.length)
			return true;
		else 
			return false;
	}

}
