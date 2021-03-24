package Model;
import java.util.List;



public class AdministrativeDepartment {
	private Set<Citizen> citizens;
	private List<PoliticalParty>politicalPartys;
	private List<Ballot>ballots; 

	public AdministrativeDepartment(Set<Citizen> citizen,List<PoliticalParty>politicalPartys, List<Ballot>ballots) {
		this.citizens=citizen;
		this.politicalPartys=politicalPartys;
		this.ballots=ballots;
	}

	public void addCitizen(Citizen c) {
		if(citizens.add(c)) {
			//System.out.println(c.getName()+" had been added");
			sortByBallot(c);
			}
		else
			System.out.println("Citizen with this ID already exist");
	}

	public void sortByBallot(Citizen c) {
		getBallotBynum(c.getBallotNum()).addCitizen(c);
	}
	
	public Ballot getBallotBynum(int num){
		return ballots.get(num);		
	}

	public void addPoliticalParty(PoliticalParty p) {
		politicalPartys.add(p);
		for(int i=0;i<ballots.size();i++) {
			ballots.get(i).addPoliticalParty(p);
		}
	}

	public void addBallot(Ballot b) {
		ballots.add(b);
		ballots.get(b.getBallotNum()-1).setAllParties(politicalPartys);
	}

	public void addPartyMember(PartyMember pm,int pos,PoliticalParty pp) {
		politicalPartys.remove(pp);
		pp.addMember(pm, pos);
		politicalPartys.add(pp);
	}

	public PoliticalParty getPoliticalPartyByName(String name) {
		for(int i=0;i<politicalPartys.size();i++){
			if(politicalPartys.get(i).getPoliticalPartyName().toLowerCase().equals(name.toLowerCase()))
				return politicalPartys.get(i);
		}
		return null;
	}

	public List<PoliticalParty> getPoliticalParties() {
		return politicalPartys;
	}

	public List<Ballot> getBallots() {
		return ballots;
	}

	public Set<Citizen> getCitizens(){
		return citizens;
	}
	
	public String ballotsShow() {
		String sb=new String();
		for(int i=0;i<ballots.size();i++)
		sb+="\n\n"+ballots.get(i).ballotShow();
		return sb.toString();
	}

	public String citizensShow() {
		return citizens.printList();
	}

	public String partiesShow() {
		String sb=new String();
		for(int i=0;i<politicalPartys.size();i++) {
				sb+=politicalPartys.get(i)+"\n\n";
		}
		return sb.toString();
	}
}

