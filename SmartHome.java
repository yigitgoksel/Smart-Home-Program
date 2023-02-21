import java.util.ArrayList;
import java.util.Arrays;
//Yiðit Göksel 150119053
public class SmartHome {
	ArrayList <SmartObject> smartObjectList=new ArrayList<>();
	
	public SmartHome() {
		
	}
	public static int i=100; 
	public boolean addSmartObject(SmartObject smartObject) {
		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println("Adding new Smart Object");
		System.out.println("------------------------");
		smartObject.connect("10.0.0."+i);
		smartObjectList.add(smartObject);
		i++;
		smartObject.testObject();
		return true;
	}
	public boolean removeSmartObject(SmartObject smartObject) {
		smartObjectList.remove(smartObject);
		return true;
	}
	public boolean controlLocation(boolean onCome) {
		System.out.println("------------------------");
		System.out.println("------------------------");
		if(onCome) {
		System.out.println("Location control OnCome");
		}
		else {
		System.out.println("Location control OnLeave");	
		}
		System.out.println("------------------------");
		for(int x=0;x<smartObjectList.size();x++) {
			if(smartObjectList.get(x) instanceof SmartLight) {
				SmartLight k = (SmartLight) smartObjectList.get(x);
				if(onCome) {
					k.onCome();
				}
				else {
					k.onLeave();
				}
			}
			
		}
		return true;
	}
	public void controlMotion(boolean hasMotion,boolean isDay) {
		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println("MotionControl: HasMotion, isDay ");
		System.out.println("------------------------");
		for(int x=0;x<smartObjectList.size();x++) {
			if(smartObjectList.get(x) instanceof SmartCamera) {
				SmartCamera k = (SmartCamera) smartObjectList.get(x);
				k.controlMotion(hasMotion, isDay);
			}
		}
	}
	
	public void controlProgrammable(){
		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println("Programmable: runProgram");
		System.out.println("------------------------");
		for(int x=0;x<smartObjectList.size();x++) {
			if(smartObjectList.get(x) instanceof SmartLight) {
				SmartLight k = (SmartLight) smartObjectList.get(x);
				k.runProgram();
				
			}
			else if(smartObjectList.get(x) instanceof SmartPlug) {
				SmartPlug y = (SmartPlug) smartObjectList.get(x);
				y.runProgram();
			}
		}
	}
	
	public void controlTimer(int seconds) {
		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println("Programmable: Timer= "+seconds+" seconds");
		System.out.println("------------------------");
		for(int x=0;x<smartObjectList.size();x++) {
			if(smartObjectList.get(x) instanceof SmartLight) {
				SmartLight k = (SmartLight) smartObjectList.get(x);
				if(seconds>0) {
					k.setTimer(seconds);
				}
				if(seconds==0) {
					k.cancelTimer();
				}
				
			}
			else if(smartObjectList.get(x) instanceof SmartPlug) {
				SmartPlug y = (SmartPlug) smartObjectList.get(x);
				if(seconds>0) {
					y.setTimer(seconds);
				}
				if(seconds==0) {
					y.cancelTimer();
				}
			}
		}
	}
	
	public void controlTimerRandomly() {		
		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println("Programmable: Timer = 0, 5 or 10 seconds randomly");
		System.out.println("------------------------");
		for(int x=0;x<smartObjectList.size();x++) {
			if(smartObjectList.get(x) instanceof SmartLight) {
				SmartLight k = (SmartLight) smartObjectList.get(x);
				int[] choices = {0,5,10};  
		    	java.util.Random random = new java.util.Random();
		    	int randomInt = random.nextInt(choices.length);
		    	if(randomInt==0) {
		    		k.cancelTimer();
		    	}
		    	else {
		    		k.setTimer(choices[randomInt]);
		    	}
		    	
				
			}
			else if(smartObjectList.get(x) instanceof SmartPlug) {
				SmartPlug y = (SmartPlug) smartObjectList.get(x);
				int[] choices = {0,5,10};  
		    	java.util.Random random = new java.util.Random();
		    	int randomInt = random.nextInt(choices.length);
		    	if(randomInt==0) {
		    		y.cancelTimer();
		    	}
		    	else {
		    		y.setTimer(choices[randomInt]);
		    	}
			}
		}
	}
	
	
	public void sortCameras() {
		ArrayList <SmartObject> sortList=new ArrayList<>();
		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println("Sort Smart Cameras");
		System.out.println("------------------------");
		
		for(int x=0;x<smartObjectList.size();x++) {
			if(smartObjectList.get(x) instanceof SmartCamera) {
				SmartCamera k = (SmartCamera) smartObjectList.get(x);
				sortList.add(k);
				
			}
		}
		SmartCamera[] objectsArray = sortList.toArray(new SmartCamera[0]);
		Arrays.sort(objectsArray);
		for(int i=0;i<objectsArray.length;i++) {
			System.out.println(objectsArray[i]);
		}
	}
	
	

}
