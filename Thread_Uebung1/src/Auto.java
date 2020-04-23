import java.util.Random;

//aktive Klasse


public class Auto implements Runnable {
	private String kennzeichen; 
	private Parkhaus parkhaus;
	
	public Auto(String kennzeichen, Parkhaus parkhaus){
		this.kennzeichen = kennzeichen;
		this.parkhaus = parkhaus;
	}
	
	 @Override
	 public void run(){
		 while (true){
			 try{
			 parkhaus.einfahren();
			 System.out.println("Einfahrt: " + kennzeichen);
			 
			 long schlafenszeit = 1000 + new Random().nextInt(8000); 
			 Thread.sleep(schlafenszeit);
			 
			 parkhaus.ausfahren();
			 System.out.println("Ausfahrt: " + kennzeichen);
			 
			schlafenszeit = 1000 + new Random().nextInt(4000);
			Thread.sleep(schlafenszeit);
			
			 } catch (InterruptedException e){
			 e.printStackTrace();
		 }
	 }
}
	

			
	
	
	
	
	
	
	
	
	
	
	
	
	
}
