/*
 * Using DFS to fill block;
 * */

import java.util.*;


public class CC_41_Groups_of_1_in_Matrix {

	public static void main(String[] args) {
	
		int[][] m=new int[][]{{1,1,0,0,1},
							  {1,0,0,1,0},
							  {1,1,0,1,0},
							  {0,0,1,0,1} };// Ans=5;
		sol(m);
	}

	public static void sol(int[][] m){
		
		int counter=0;
		
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[0].length; j++){
				if(m[i][j]==1){
					counter++;
					m=setAdj0(m, i, j); // Set adjacent=0;
				}
			}
		}
		System.out.println("Ans:"+counter);
		

	}
	
	public static int[][] setAdj0(int[][] m, int x, int y){
		
		location loc=new location(x, y);
		Stack<location> s=new Stack<location>();
		s.push(loc);
		
		while(!s.isEmpty()){
			location tmp=s.pop();
			int i=tmp.i;
			int j=tmp.j;
			m[i][j]=0;
			//up
			if(i>0 && m[i-1][j]==1){
				//System.out.println(1);
				location up=new location(i-1,j);
				s.push(up);
			}
			//right
			if(j<(m[0].length-2) && m[i][j+1]==1 ){
				//System.out.println(2);
				location r=new location(i, j+1);
				s.push(r);
			}
			// down
			if(i<(m.length-2) && m[i+1][j]==1){
				//System.out.println(3);
				location d=new location(i+1, j);
				s.push(d);
			}
			//left
			if(j>0 && m[i][j-1]==1){
				//System.out.println(4);
				location l=new location(i, j-1);
				s.push(l);
			}
			
		}
		
		return m;
	}
	
	public static void print(int[][] m){
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[0].length; j++){
				System.out.print(m[i][j] +"\t");
			}
			System.out.println();
		}
	}
}

class location{
	int i;
	int j;
	location(int x, int y){
		this.i=x;
		this.j=y;
	}
}
