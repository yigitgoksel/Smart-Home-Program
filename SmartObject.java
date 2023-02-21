import java.util.Calendar;
import java.util.GregorianCalendar;
 //Yiðit Göksel 150119053
public abstract class SmartObject {
	
	private String alias;
	private String macId;
	private String IP;
	private boolean connectionStatus=false;
	
	public SmartObject() {
	}
	
	public boolean connect(String IP) {
		this.IP=IP;
		connectionStatus=true;
		System.out.println(alias+ " connection established");
		return true;
	}
	public boolean disconnect() {
	
		connectionStatus=false;
		IP=null;
		return true;
	}
	public void SmartObjectToString() {
		System.out.println("This is " +getClass().getSimpleName()+ " device " + alias ); //ekleme gerek smarcamera fln
		System.out.println("MacId: "+ macId);
		System.out.println("IP: " + IP);
		
	}
	
	public boolean controlConnection() {
		if(connectionStatus=false) {
			System.out.println("This device is not connected. "+getClass().getSimpleName()+ " -> "+ alias); //ekleme gerek smarcamera fln
			return false;
		}
		else
			return true;
	}	
	public abstract boolean testObject();
	
	public abstract boolean shutDownObject();

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	public String getStringTime() {
		Calendar currentTime = new GregorianCalendar();
		return String.format("Current Time: %d:%d:%d)", currentTime.get(Calendar.HOUR_OF_DAY),
				currentTime.get(Calendar.MINUTE), currentTime.get(Calendar.SECOND));
	}
	public String getStringTime(Calendar currentTime) {
		return String.format("Current Time: %d:%d:%d)", currentTime.get(Calendar.HOUR_OF_DAY),
				currentTime.get(Calendar.MINUTE), currentTime.get(Calendar.SECOND));
	}

	
	
}
