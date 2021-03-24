package Model;

import java.time.LocalDate;

public class PartyMember extends Citizen {
	private PoliticalParty politicalParty;

	public PartyMember(String name, String id, LocalDate dateOfBirth, int ballot,PoliticalParty politicalParty) {
		super(name, id, dateOfBirth, ballot);
		this.politicalParty=politicalParty;
	}
	
	public PoliticalParty getParty() {
		return politicalParty;
	}

	public String toString() {
		return "Party member a member in "+politicalParty.getPoliticalPartyName()+" "+super.toString();
	}
}

