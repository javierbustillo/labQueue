package testers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import queue.SLLQueue;

public class ProcessingSystem {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String line;
		SLLQueue<job> jobs = new SLLQueue<job>();


		try (BufferedReader reader = new BufferedReader(new FileReader("/Users/Javdav/Documents/ICOM 4035/Programs/L6_QueueLab_2017 Student/input4.csv"))){

			while((line = reader.readLine()) != null){
				String[] s = line.split(",");

				int arrival = Integer.parseInt(s[0]);
				int timeToJob = Integer.parseInt(s[1]);
				job tmp = new job(arrival, timeToJob);
				jobs.enqueue(tmp);

				
			}
		}
		catch(IOException e)
		{
			
		}
		
		
		System.out.println(process(jobs));

	}
	
	public static double process(SLLQueue<job> inputQueue){
		
		SLLQueue<job> processingQueue = new SLLQueue<job>();
		ArrayList<job> terminatedJobs = new ArrayList<job>();
		int time = 0;
		
		
		while(!inputQueue.isEmpty() || !processingQueue.isEmpty()){
			if(!processingQueue.isEmpty()){
				job firstJob = processingQueue.first();
				firstJob.setTimeToJob(firstJob.getTimeToJob()-1);
				if(firstJob.getTimeToJob() == 0){
					firstJob.setDepartureTime(time);
					terminatedJobs.add(processingQueue.dequeue());
				}
				else{
					processingQueue.enqueue(processingQueue.dequeue());
				}
				if(!inputQueue.isEmpty()){
					if(inputQueue.first().getArrival()==time){
						processingQueue.enqueue(inputQueue.dequeue());
	
					}
				}
				
			}
			else{
				if(!inputQueue.isEmpty()){
					if(inputQueue.first().getArrival()==time){
						processingQueue.enqueue(inputQueue.dequeue());

					}
				
				}
			}
			time++;
		}

		double total=0;
		for(int i = 0;i<terminatedJobs.size();i++){
			total += terminatedJobs.get(i).getDepartureTime() - terminatedJobs.get(i).getArrival();
 		}
		double average = total/terminatedJobs.size();
		
		return average;
		
		
	}
	
	
	
	
	

}
