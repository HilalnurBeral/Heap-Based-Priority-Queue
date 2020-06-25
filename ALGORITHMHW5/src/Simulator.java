
//-----------------------------------------------------
// Title: Simulator class 
// Author:Hilalnur Beral 
// Section: 01
// Assignment: 5
// Description: This class is used to show the threaded execution.
//--------------------------

//VERY IMPORTANT NOTE!!!!!! : We took 3 arguments that's why we added argument like in the following:

// Simulator <filename> <avgwaitingtime>

// When we run our code; we added this argument for testing: Simulator jobs.txt 5



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) throws IOException {
		
		//--------------------------------------------------------
		 // Summary: This method reads input file and fill the heap , in this way we can simulate the threaded jobs.
		 // Precondition: This is our main method
		 // Postcondition:We can see the simulation successfully.
		 //-----------
		
		
       int index=0;
		
		File file = new File(args[1]);
		
		 Scanner input = new Scanner(file);
		ArrayList<String> service = new ArrayList<String>();
		// These arraylist hold the service times of the jobs.
		ArrayList<String> priority = new ArrayList<String>();
		// These arrayList hold the priorities of the jobs.
		 
		 
		 FileInputStream fis = new FileInputStream(file);
	      byte[] byteArray = new byte[(int)file.length()];
	      fis.read(byteArray);
	      String data = new String(byteArray);
	      String[] stringArray = data.split("\r\n");

		 BufferedReader brTest = new BufferedReader(new FileReader(args[1]));
			
	       ArrayList<Jobs> job =  new ArrayList<Jobs>();;
	        int j=0;
	        String text = null;
	        String line= System.getProperty("line.separator");
	            text = brTest .readLine();
	                while (j==0) {
	                    String[] a=text.split(" ");
	                    for(int i=0;i<a.length;i++){
	                    	 service.add(a[i]);
	                    }
	                   	                    
	                    j++;
	                 }              
	                for(int i=0;i<service.size();i++){
	                	Jobs e = new Jobs(0,0,0,0);
	                	job.add(e);                
	                	job.get(i).service_time=Integer.parseInt(service.get(i));	
	                }
	                String[] lines;
	                line = brTest.readLine();
	                int c = 0;
	                while(line != null) {
	                	lines = line.split(" ");
	                	 for(int i=0;i<=1;i++){
	                		 switch (i) {
	                		 case 0:
	                			 job.get(c).setPriority(Integer.parseInt(lines[0])) ;
	                		 case 1:
	                			 job.get(c).setArrival_time((Integer.parseInt(lines[1]))); ;
	                		 } 
	                	 }
	                	 c++;
	                	
	                	line = brTest.readLine(); 
	                }
	                for(int id=0; id < job.size(); id++) {
	                	job.get(id).setId(id+1);
	                }
		
	        Heap nw = new Heap();
			for(int i =0;i<job.size(); i++) {
				nw.insertIntoMaxHeap(job.get(i));
			}
			
			nw.printHeap();

			if (args.length != 3) {
				System.out.println("Wrong arguments.");
			}

			int jobNumber = 0;
			Heap heap = new Heap();
			for( int i = 0; i < jobNumber; i++) {
				job.get(i).show();
			}
			// starting to simulate, server number starts from 1
			int jobCount = 0;

			int threadNumber = 1;
			while (true) {
				Thread thread = new Thread(threadNumber);
			
				for (int time = 0; jobCount <= jobNumber || !thread.allServersEmpty() || !heap.heapIsEmpty(); time++) {
					// insert all the requests which are coming at the same time
					while (job.get(jobCount).getArrival_time() == time) {
						heap.insertIntoMaxHeap(job.get(jobCount));
						jobCount++;
						
					}
					jobNumber++;
					// unless all servers are busy, try to load each server with a request which is
					// pulled from priority queue
					while (!thread.allServersBusy() && !heap.heapIsEmpty()) 														
					{
						Jobs tmp = heap.heapDelete();
						if (tmp != null) {
							thread.process(tmp, time);
						}
						
					}
					
					thread.update(); // update all servers' times and states
				}
				
				double avgWaiting = thread.getTotalWaiting() / (double) jobNumber;

				if (avgWaiting < Integer.parseInt(args[2])) {
					heap.printHeap();
					System.out.println(thread.getLog());
					System.out.println("Average waiting time: " + avgWaiting + " mins");

					break;
				} else {
					threadNumber++;

				}

			}
		}
	}
