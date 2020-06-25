import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//-----------------------------------------------------
// Title: Tester class 
// Author:Hilalnur Beral 
// Section: 01
// Assignment: 5
// Description: This class is implemented in order to test our methods..
//--------------------------



//VERY IMPORTANT NOTE:IN THIS CLASS WE SHOWED OUR CORRECT IMPLEMENTATIONS. 
//EVEN THOUGH THERE ARE SOME MISTAKES IN HW , WE IMPLEMENTED SOME CORRECT FUNCTIONS.

public class Tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		
int index=0;
		
		File file = new File("jobs.txt");
		
		
		ArrayList<String> service = new ArrayList<String>();
		ArrayList<String> priority = new ArrayList<String>();
		 
		 
		 FileInputStream fis = new FileInputStream(file);
	      byte[] byteArray = new byte[(int)file.length()];
	      fis.read(byteArray);
	      String data = new String(byteArray);
	      String[] stringArray = data.split("\r\n");

		 BufferedReader brTest = new BufferedReader(new FileReader("jobs.txt"));
			
	       ArrayList<Jobs> arr =  new ArrayList<Jobs>();;
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
	                	arr.add(e);                
	                	arr.get(i).service_time=Integer.parseInt(service.get(i));	
	                }
	                String[] lines;
	                line = brTest.readLine();
	                int c = 0;
	                while(line != null) {
	                	lines = line.split(" ");
	                	 for(int i=0;i<=1;i++){
	                		 switch (i) {
	                		 case 0:
	                			 arr.get(c).setPriority(Integer.parseInt(lines[0])) ;
	                		 case 1:
	                			 arr.get(c).setArrival_time((Integer.parseInt(lines[1]))); ;
	                		 } 
	                	 }
	                	 c++;
	                	
	                	line = brTest.readLine(); 
	                }
	                for(int id=0; id < arr.size(); id++) {
	                	arr.get(id).setId(id+1);
	                }
		
		
		System.out.println("Service Times of the jobs");
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i).service_time);
		
			
		}
		
		System.out.println("Priorities of the jobs");
		
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i).priority);
		
			
		}
		
		System.out.println("Arrival times of the jobs");
		
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i).arrival_time);
		
			
		}
		
		System.out.println("IDs of the jobs");
		
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i).id);
		
			
		}
		
		
		
		

	}

}
