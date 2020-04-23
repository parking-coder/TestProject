//passive Klasse


public class Parkhaus {
	
	private int kapazitaet;
	private int belegtePlaetze = 0;
	private Object monitor = new Object();
	
	//Konstruktor
	public Parkhaus(int kapazitaet){
		this.kapazitaet = kapazitaet;
	}
	
	public void einfahren(){
		synchronized (monitor){
			while(kapazitaet == belegtePlaetze){
					try {
						System.out.println(" Warten an Schranke: " + Thread.currentThread().getName());
						monitor.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
			}
			belegtePlaetze = belegtePlaetze + 1; 
			monitor.notify();
		}
	
	}
	
	public void ausfahren (){
		synchronized (monitor){
			belegtePlaetze = belegtePlaetze - 1;
			monitor.notify();
		}
	}


	public int getkapazitaet(){
		synchronized (monitor){
		return this.kapazitaet;
		}
	}
}