package Model;

public class CitizenExcption extends Exception {
	private String msg;
	
	public CitizenExcption(String msg) {
		this.msg=msg;
	}
	
	public String getMessage() {
		return msg;
	} 

}

