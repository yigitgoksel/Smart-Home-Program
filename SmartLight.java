import java.util.Calendar;
public class SmartLight extends SmartObject implements LocationControl,Programmable{
	 //Yiðit Göksel 150119053
	private boolean hasLightTurned;
	private Calendar programTime;
	private boolean programAction;
	
	public SmartLight(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}

	public void turnOnLight() {
		if(isConnectionStatus()) {
			if(hasLightTurned==false) {
				hasLightTurned=true;
				System.out.println("Smart Light - " +getAlias() +" is turned on now (" + getStringTime()+ ")" );
			}
			else{
				System.out.println("Smart Light - " +getAlias() +" has been already turned on. ");
			
			}
		}
	}
	public void turnOffLight() {
		if(isConnectionStatus()) {
			if(hasLightTurned) {
				hasLightTurned=false;
				System.out.println("Smart Light - " +getAlias() +" is turned off now (" + getStringTime()+ ")" );
			}
		}
		else {
			System.out.println("Smart Light - " +getAlias() +" has been already turned off. ");
		}
		
	}
	
	@Override
	public boolean testObject() {
		if(isConnectionStatus()) {
			SmartObjectToString();
			turnOnLight();
			turnOffLight();
			System.out.println("Test completed for SmartLight. ");
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
			if(hasLightTurned) {
				turnOffLight();
			}
			
			return true;
		}
		else {
			return false;
		}
	}	
	
	public void onCome() {
		if(isConnectionStatus()) {
			
			System.out.println("On Come -> Smart Light - " + getAlias());
			System.out.println("Smart Light - "+getAlias()+ " is turned on now (" + getStringTime()+ ")");
			hasLightTurned=true;
		}
	}
	
	public void onLeave() {
		if(isConnectionStatus()) {
			System.out.println("On Leave -> Smart Light - " + getAlias());
			System.out.println("Smart Light - "+getAlias()+ " is turned off now (" + getStringTime()+ ")");
			hasLightTurned=false;
		}
	}
	public void setTimer(int seconds) {
		if(isConnectionStatus()) {
			programTime=Calendar.getInstance();
			programTime.add(Calendar.SECOND,seconds );
			if(hasLightTurned) {
				System.out.print("Smart light - "+getAlias()+" will be turned off "+seconds+ " seconds later!");			
				System.out.print("(Current time : " + getStringTime()+ ")");
			}
			if(hasLightTurned==false) {
				System.out.print("Smart light - "+getAlias()+" will be turned on "+seconds+ " seconds later!");			
				System.out.print("(Current time : " +getStringTime()+ ")");
			}
			
		}
	}
	
	public void canceltimer() {
		if(isConnectionStatus()) {
			programTime=null;
		}
	}
	
	public void runProgram() {
		if(isConnectionStatus()) {		
			if(programTime!=null) {
				if(getStringTime(programTime).equals(getStringTime())) {
					if(!programAction) {
						programAction=true;
						System.out.println("Run Program -> Smart Light - "+getAlias());
						System.out.println("Smart Light - "+getAlias()+" is turned off now "+getStringTime());
						if(hasLightTurned) {
							turnOffLight();
						}
						else {
							turnOnLight();
						}
					}
						
				}
				
			}
		}
		
	}

	public boolean isHasLightTurned() {
		return hasLightTurned;
	}

	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
	}

	public Calendar getProgramTime() {
		return programTime;
	}

	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}

	public boolean isProgramAction() {
		return programAction;
	}

	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}

	@Override
	public void cancelTimer() {
		if(isConnectionStatus()) {	
			programTime=null;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
		
	}
