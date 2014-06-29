
public class CC_16_Max_Len_Incre_Substring {

	static int[] table=new int[100];
	public static void sol(int[] a){
		
		int len=a.length;
		table[0]=1;
		
		int max=0;
		
		for(int i=1; i<len; i++){
			max=0;
			for(int j=0; j<i; j++){
				if(a[i]<a[j]){// && table[j]>max){
					//System.out.println("test");
					if(table[j]>max)
						max=table[j];
				}		
				else
					max=table[j]+1;
			}
			table[i]=max;
		}
		//Find the longest sub now
		max=0;
		for(int i=0; i<len; i++){
			if(table[i]>max)
				max=table[i];
		}
		System.out.println("Answer:" +max);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={7, 2, 3, 1, 5, 4, 8, 5, 9, 6, 7};
		sol(a);
	}

}
