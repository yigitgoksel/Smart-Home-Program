
public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera> {
	private boolean status;
	private boolean nightVision;
	private int batteryLife;
	
	 //Yiðit Göksel 150119053
	public SmartCamera(String alias, String macId,boolean nightVision,int batteryLife) {
		setAlias(alias);
		setMacId(macId);
		this.nightVision=nightVision;
		this.batteryLife=batteryLife;
	}
	
	
	public void recordOn(boolean isDay) {
		if(isConnectionStatus()) {
			if(isDay==false) {
				if(nightVision==false) {
					System.out.println("Sorry! Smart Camera - "+getAlias()+" does not have night vision feature.");
				}
			}
			
			else if(status==false) {
				status=true;
				System.out.println("Smart Camera - " +getAlias() +" is turned on now " );
			}
			else{
				System.out.println("Smart Light - " +getAlias() +" has been already turned on. ");
			}
			
		}
	}
	
	public void turnOff() {
		if(isConnectionStatus()) {
			if(status) {
				status=false;
				System.out.println("Smart Camera - " +getAlias() +" is turned off now " );
			}
			else{
				System.out.println("Smart Light - " +getAlias() +" has been already turned off. ");
			}
		}
	}
	
	
	
	
	@Override
	public boolean testObject() {
		if(isConnectionStatus()) {
			SmartObjectToString();
			System.out.println("Test is starting for SmartCamera day time");
			recordOn(true);
			turnOff();
			System.out.println("Test is starting for SmartCamera night time");
			recordOn(false);
			turnOff();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean shutDownObject() {
		if(isConnectionStatus()) {
			SmartObjectToString();
			if(status) {
				turnOff();
			}
			
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public boolean controlMotion(boolean hasMotion, boolean isDay) {
		if(isConnectionStatus()) {
			
			if(hasMotion==false) {
				System.out.println("Motion not detected");
			}
			else if(hasMotion) {
				System.out.println("Motion detected!");
				if(isDay) {
					recordOn(true);
				}
				else if(isDay==false) {
					recordOn(false);
				}
			}
			
			
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int compareTo(SmartCamera arg0) {
		if(batteryLife>arg0.batteryLife) {
			return 1;
		}
		else if(batteryLife==arg0.batteryLife) {
			return 0;
		}
		else {
			return -1;
		}
	}
	public String toString() {
		if(status) {
			return "SmartCamera -> "+getAlias()+"'s battery life is "+batteryLife+" status is recording ";
		}
		else {
			return "SmartCamera -> "+getAlias()+"'s battery life is "+batteryLife+" status is not recording";
		}
		
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public boolean isNightVision() {
		return nightVision;
	}


	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}


	public int getBatteryLife() {
		return batteryLife;
	}


	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}



}
