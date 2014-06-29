import java.util.*;
public class CC_33_Max_in_Sliding_Window {

	public static void main(String[] args) {

		int[] a={2, 3, 4, 2, 6, 2, 5, 1};
		int win_size=3;
		sol(a, win_size);
	}

	public static void sol(int[] a, int win_size){
		ArrayList<Integer> index=new ArrayList();
		ArrayList<Integer> ans=new ArrayList();
		
		
		for(int i=0; i<win_size; i++){
			while(!index.isEmpty() && a[i]>= a[index.get(index.size()-1)] ){
				index.remove(index.size()-1);
			}
			index.add(i);
		}
	
		System.out.println(index);
		
		for(int i=win_size; i<a.length; i++){
			ans.add(index.get(0));
			while(!index.isEmpty() && a[i]>=a[index.get(index.size()-1)])
				index.remove(index.size()-1);
			if(!index.isEmpty() && index.get(0)<=i-win_size)
				index.remove(index.size()-1);
			
			index.add(i);
		}
		ans.add(a[index.get(0)]);
		
		while(!ans.isEmpty())
			System.out.print(a[ans.remove(0)] +"->");
		System.out.println();
	}
	
	/*
	public static void get_last(Queue q){
		LinkedList tmp=(LinkedList) q;
	
		while(tmp.lastIndexOf(o)!=null)
			tmp=tmp.next;
		
		System.out.println(tmp.peek());
	}*/
}

