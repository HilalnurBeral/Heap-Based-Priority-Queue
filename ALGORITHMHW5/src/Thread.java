//-----------------------------------------------------
// Title: Thread class 
// Author:Hilalnur Beral ID:11549136358
//Author2:Ýrem Karpat ID:61234117544
// Section: 01
// Assignment: 5
// Description: This class includes variables for threads and getter setter methods.
//--------------------------



public class Thread {
    int numThreads = 0;
    Thread threads[] = null;
    String logFile =  "";
    int totalWaiting = 0;
    int timeLeftToFinish;
    boolean busy;
   
	public Thread() {
		
		// This is our constructor
		//It does not take parameter.
		busy = false;
        timeLeftToFinish = 0;
	}
	 
	 
	public Thread(int numThreads) {
		// This is our another constructor.

		//--------------------------------------------------------
		 // Summary:  This is our constructor.
		 // Precondition: numOfthreads is type of int.
		 // Postcondition:Constructor is build successfully.
		 //-----------
		this.numThreads = numThreads;
		this.threads = new Thread[numThreads];
		this.logFile = "";
		this.logFile += "Minumum number of threads required: "+ numThreads + " /n simulation with" + numThreads +": threads";
		this.totalWaiting = 0;
	}
	
	public void update() {
		for(int i = 0; i < numThreads; i++) {
			threads[i] = new Thread();
			if( threads[i].busy )
				if(--threads[i].timeLeftToFinish <= 0) {
					threads[i].busy = false;
					threads[i].timeLeftToFinish = 0;
				}
		}
	}

	public void process(Jobs job, int currTime) {
		for(int i = 0; i < numThreads; i++) {
			threads[i] = new Thread();
			if(!threads[i].busy) {
				threads[i].timeLeftToFinish = job.getService_time();
				threads[i].busy = true;
				int res = currTime - job.getArrival_time();
				logFile += "Thread " + i + " takes job "
	                    + job.getId() + "at minute " + currTime
	                    + " (wait: " + res  + " ms)\n";
			}
		}
	}
	
	boolean isBusy(int id) { return threads[id].busy; }
	int getTotalWaiting() { return totalWaiting; }
	String getLog() {return logFile;}
	int getNumThreads() { return numThreads; }
	
	//checks if all servers are full or not
	boolean allServersBusy()
	{
	    boolean allBusy = true;
	    for (int i = 0; i < numThreads; i++)
	    {
	    	threads[i] = new Thread();
	        if( !threads[i].busy )
	        {
	            allBusy = false;
	            break;
	        }
	    }
	    return allBusy;
	}
	
	//checks if all servers are empty or not
	boolean allServersEmpty()
	{
		

				//--------------------------------------------------------
				 // Summary:  This method control whether servers(threads) are empty or not.
				 // Precondition: It takes no parameter.
				 // Postcondition:This method is written successfully.
				 //-----------
		
		
	    boolean allEmpty = true;
	    for(int i = 0; i < numThreads; i++)
	    {
        	threads[i] = new Thread();
	        if(threads[i].busy)
	        {
	            allEmpty = false;
	            break;
	        }
	    }
	    return allEmpty;
	}

}