import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable {
	 //Yiðit Göksel 150119053
	private boolean status;
	private Calendar programTime;
	private boolean programAction;
	
	
	public SmartPlug(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}
	public void turnOn() {
		if(isConnectionStatus()) {
			if(status==false) {
				status=true;
				System.out.println("Smart Plug - " +getAlias() +" is turned on now (" + getStringTime()+ ")" );
			}
			else{
				System.out.println("Smart Plug - " +getAlias() +" has been already turned on. ");
			
			}
		}
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public void turnOff() {
		if(isConnectionStatus()) {
			if(status) {
				status=false;
				System.out.println("Smart Plug - " +getAlias() +" is turned off now (" + getStringTime()+ ")" );
			}
		}
		else {
			System.out.println("Smart Plug - " +getAlias() +" has been already turned off. ");
		}
		
	}

	@Override
	public void setTimer(int seconds) {
		if(isConnectionStatus()) {
			programTime=Calendar.getInstance();
			programTime.add(Calendar.SECOND,seconds );
			if(status) {
				System.out.print("Smart Plug - "+getAlias()+" will be turned off "+seconds+ " seconds later!");			
				System.out.print("(Current time : " + getStringTime()+ ")");
			}
			if(status==false) {
				System.out.print("Smart Plug - "+getAlias()+" will be turned on "+seconds+ " seconds later!");			
				System.out.print("(Current time : " +getStringTime()+ ")");
			}
			
		}

	}

	@Override
	public void cancelTimer() {
		if(isConnectionStatus()) {
			programTime=null;
		}

	}

	@Override
	public void runProgram() {
		if(isConnectionStatus()) {		
			if(programTime!=null) {
				if(getStringTime(programTime).equals(getStringTime())) {
					if(!programAction) {
						programAction=true;
						System.out.println("Run Program -> Smart Plug - "+getAlias());
						System.out.println("Smart Plug - "+getAlias()+" is turned off now "+getStringTime());
						if(status) {
							turnOff();
						}
						else {
							turnOn();
						}
					}
						
				}
				
			}
		}

	}

	@Override
	public boolean testObject() {
		if(isConnectionStatus()) {
			SmartObjectToString();
			turnOn();
			turnOff();
			System.out.println("Test completed for SmartPlug. ");
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
	
}
