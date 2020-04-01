package Elections;

import java.time.LocalDate;

public class PartyMember extends Citizen {
	private String politicalParty;
	
	public PartyMember(String politicalParty) {
		super("",111111,LocalDate.now(),0,false);
		politicalPartyCheck(politicalParty);	
	}

	public PartyMember(String name, int id, LocalDate dateOfBirth, int ballot, boolean inInsulation,String politicalParty) {
		super(name, id, dateOfBirth, ballot, inInsulation);
		politicalPartyCheck(politicalParty);	
	}
	
	private void politicalPartyCheck(String politicalParty) { //אם היה שייך כבר למפלגה אז לא יתבצע שינוי מפלגה
		if(politicalParty==null) 
			this.politicalParty=politicalParty;	
	}
	
	public String toString() {
		return super.toString()+" , a Party member in: "+politicalParty;
	}

}

