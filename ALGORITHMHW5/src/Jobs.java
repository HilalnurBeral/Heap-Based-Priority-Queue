
//-----------------------------------------------------
// Title: Jobs class 
// Author:Hilalnur Beral ID:11549136358
//Author2:Ýrem Karpat ID:61234117544
// Section: 01
// Assignment: 5
// Description: This class includes variables for jobs and its getters setters methods.
//--------------------------

public class Jobs {
 int id,service_time,priority;
 int arrival_time;

public Jobs( int priority,int id,int arrival_time, int service_time) {
	this.priority = priority;
	this.id = id;
	this.arrival_time = arrival_time;
	this.service_time = service_time;

}
public Jobs() {
	//Default constructor.
}


//Getters and setters methods.

public int getId() {

//Getter method for job Id
	
	return id;
}
public void setId(int id) {
	//Setter method for job Id
	this.id = id;
}
public int getService_time() {
	//Getter method for service_time
	return service_time;
}
public void setService_time(int service_time) {
	//Setter methýd for service_time.
	this.service_time = service_time;
}
public int getPriority() {
	//Getter method for priority
	return priority;
}
public void setPriority(int priority) {
	//Setter method for priority.
	this.priority = priority;
}
public int getArrival_time() {
	//Getter method for arrival_time
	return arrival_time;
}
public void setArrival_time(int arrival_time) {
	//Setter method for arrival_time
	this.arrival_time = arrival_time;
}

void show()
{
	
	//--------------------------------------------------------
	 // Summary: This method is used in order to show ID,priority,arrival time and service_time
	 // Precondition: No parameter is needed
	 // Postcondition:Method is built successfully.
	 //-----------
	
	
	System.out.println("ID: " + id + ", Priority: "+ priority
	         + ", Arrival Time: " + arrival_time + ", Service Time: " + service_time);
}


}