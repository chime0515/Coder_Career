/*Self Define a heap. I've not finished yet*/
/*
 * http://homepage.cs.uiowa.edu/~sriram/21/spring07/code/heap.java
 */
public class CC_30_Median_in_Stream {

	public static void main(String[] args) {
		System.out.println((5)&1);

	}

}


class Heap{
	
	private Node[] heapArray;
	private int maxSize;
	private int curSize;
	Heap(int mx){
		this.maxSize=mx;
		this.curSize=0;
		this.heapArray=new Node[maxSize];
	}
	
	public boolean isEmpty(){
		return this.curSize==0;
	}
	
	public boolean insert(int v){
		if(curSize==maxSize) return false;
		
		Node tmp=new Node(v);
		heapArray[curSize]=tmp;
		trickleUp(curSize++);
		return true;
	}
	public void trickleUp(int index){
		int parent=(index-1)/2;
		Node bottom=heapArray[index];
		while(index>0 && heapArray[parent].getData()<bottom.getData()){
			// Move the parent to the correct position
			heapArray[index]=heapArray[parent]; 
			// Update the index and parent info
			index=parent;
			parent=(parent-1)/2;
		}
		heapArray[index]=bottom;
	}
	public void trickleDown(int index)
    {
    int largerChild;
    Node top = heapArray[index];       // save root
    while(index < curSize/2)       // while node has at
       {                               //    least one child,
       int leftChild = 2*index+1;
       int rightChild = leftChild+1;
                                       // find larger child
       if(rightChild < curSize &&  // (rightChild exists?)
                           heapArray[leftChild].getData() <
                           heapArray[rightChild].getData())
          largerChild = rightChild;
       else
          largerChild = leftChild;
                                       // top >= largerChild?
       if( top.getData() >= heapArray[largerChild].getData() )
          break;
                                       // shift child up
       heapArray[index] = heapArray[largerChild];
       index = largerChild;            // go down
       }  // end while
    heapArray[index] = top;            // root to index
    }  // end trickleDown()
}


class Node{
	private int data;
	public Node(int v){
		this.data=v;
	}
	
	public int getData(){
		return this.data;
	}
}