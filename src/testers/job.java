package testers;


public class job{
	int arrival;
	int timeToJob;
	int departureTime;
	
	public job(int arrival, int timeToJob){
		this.arrival = arrival;
		this.timeToJob = timeToJob;
	}
	
	public int getArrival(){
		return arrival;
	}
	
	public int getTimeToJob(){
		return timeToJob;
	}
	
	public int getDepartureTime(){
		return departureTime;
	}
	
	public void setTimeToJob(int i){
		this.timeToJob = i;
	}
	public void setDepartureTime(int i){
		departureTime = i;
	}
}