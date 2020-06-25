
//-----------------------------------------------------
// Title: Heap Based Priority queue implementation
// Author:Hilalnur Beral ID:11549136358
//Author2:Ýrem Karpat ID:61234117544
// Section: 01
// Assignment: 5
// Description: This class implements the heap based priority queue and necessary methods
//--------------------------

import java.util.ArrayList;
import java.util.List;

public class Heap {

	public Heap() {
	}

	List<Jobs> maxHeap = new ArrayList<Jobs>();
	int size = maxHeap.size();
	
	boolean heapIsEmpty() 
	{
	   return size == 0;
	}

	public void insertIntoMaxHeap(Jobs newValue) {
		
		 //--------------------------------------------------------
		 // Summary: This method is used in order to insert operation to the maxHeap
		 // Precondition: newValue is type of Jobs
		 // Postcondition:Method is built successfully.
		 //-----------
		
		if (size >= 50) {
			System.out.println("Heap is full.");
		}
		maxHeap.add(size, newValue);
		int place = size;
		// trickle new item up to its proper position
		int parent = (place - 1) / 2;
		while ((parent >= 0) && (maxHeap.get(place).getPriority() > maxHeap.get(parent).getPriority())) { // swap
																											// items[place]
																											// and
																											// items[parent]
			Jobs temp = maxHeap.get(parent);
			maxHeap.set(parent, maxHeap.get(place));
			maxHeap.set(place, temp);

			place = parent;
			parent = (place - 1) / 2;
			
		} // end while
		++size;
	}

	// Method that returns the current maximum value in the array
	public Jobs heapDelete() {	
		
		 //--------------------------------------------------------
		 // Summary: This method is used in order to delete operation to the maxHeap
		 // Precondition: No parameter is needed
		 // Postcondition:delete operation is done successfully.
		 //-----------
		
			Jobs rootItem = maxHeap.get(0);
			maxHeap.set(0, maxHeap.get(--size));
			heapRebuild(0);
		return rootItem;
	}
	
	public void heapRebuild(int root) {
		
		//--------------------------------------------------------
		 // Summary: This method is used in order to rebuild operation to the maxHeap
		 // Precondition: root is type of int.
		 // Postcondition:Rebuild operation is done successfully.
		 //-----------
		
		 int child = 2 * root + 1;
		 if ( child < size )
		   {
			 int rightChild = child + 1; 
			  if (rightChild < size && maxHeap.get(rightChild).getPriority() > maxHeap.get(child).getPriority() || maxHeap.get(rightChild).getPriority()==maxHeap.get(child).getPriority()||maxHeap.get(rightChild).getArrival_time()<maxHeap.get(child).getArrival_time() ) {
				  child = rightChild;
			  }
			  if (maxHeap.get(root).getPriority() < maxHeap.get(child).getPriority() || maxHeap.get(root).getPriority() == maxHeap.get(child).getPriority() && maxHeap.get(root).getArrival_time() > maxHeap.get(child).getArrival_time()) {
				  	Jobs temp = maxHeap.get(root);
				  	maxHeap.set(root, maxHeap.get(child));
				  	maxHeap.set(child, temp);

				  	heapRebuild(child);
			  }
		   }
	}
	

		
		
	void printHeap() {
		
		//--------------------------------------------------------
		 // Summary: This method is used for printing the heap.
		 // Precondition: No parameter is needed.
		 // Postcondition:Print operation is done succesfully.
		 //-----------
		System.out.println("Current heap is: ");
		 for(int i = 0; i < size; i++) {
			 System.out.println("id: "+maxHeap.get(i).getId()+" priority: "+maxHeap.get(i).priority+" arrival time "+maxHeap.get(i).arrival_time+" sevice time "+maxHeap.get(i).service_time);
		 }
	}
	

	// Method for swaping the values at two indexes in an arraylist
	// Swaps the ith index element with jth index element
	public void swap(int i, int j) {
		Jobs temp1 = maxHeap.get(i);
		Jobs temp2 = maxHeap.get(j);
		maxHeap.set(j, temp1);
		maxHeap.set(i, temp2);
	}
}