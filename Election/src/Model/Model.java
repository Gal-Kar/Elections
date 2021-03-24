package Model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;


public class Model {
	private AdministrativeDepartment ad;
	

	public Model() {
		this.ad=CreatingAD.NewAD();
	}
	
	public boolean addBallot(Ballot b){
		ad.addBallot(b);
		return true;
	}
	
	public List<Ballot> getBallot(){
		return ad.getBallots();
	}

	public List<PoliticalParty> getParty(){
		return ad.getPoliticalParties();
	}

	public Set<Citizen> getCitizen(){
		return ad.getCitizens();
	}
	
	//citizen adding
	public String addCitizen(String name,String id,LocalDate date,int ballot,boolean insulation) {
		String checkResult=new String();
		checkResult=idcheck(id);
		if(!checkResult.equals("OK"))
			return checkResult;
		if(Period.between(date, LocalDate.now()).getYears()<18)
			return "Error: You must be 18 in order to vote";
		checkResult=ad.getBallotBynum(ballot).getBallotType();
		Citizen newCitizen;

		if(Period.between(date, LocalDate.now()).getYears()<21&&insulation==true) //corona+army
			if(checkResult.equals("ARMYCORONA")) {
				newCitizen=new CoronaPatientSoldier(name,id,date,ballot);
				ad.addCitizen(newCitizen);
				return "Soldier with corona "+name+" had been added";
			}

		if(Period.between(date, LocalDate.now()).getYears()<21&&insulation==false)//army
			if(checkResult.equals("ARMY")) {
				newCitizen=new Soldier(name,id,date,ballot);
				ad.addCitizen(newCitizen);
				return "Soldier "+name+" had been added";

			}
		if(!(Period.between(date, LocalDate.now()).getYears()<21)&&insulation==true)//corona
			if(checkResult.equals("CORONA")) {
				newCitizen=new CoronaPatient(name,id,date,ballot);
				ad.addCitizen(newCitizen);
				return "Citizen with corona "+name+" had been added";

			}
		if(!(Period.between(date, LocalDate.now()).getYears()<21)&&insulation==false)//normal
			if(checkResult.equals("REGULAR")) {
				newCitizen=new Citizen(name,id,date,ballot);
				ad.addCitizen(newCitizen);
				return "Citizen "+name+" had been added";

			}
		return "Error: You cant choose this ballot";
	}
	
	public String idcheck(String id) {
		if(ad.getCitizens().exsistID(id)) {
			return "Error: This ID already exsist!";
		}
		String numbers="1234567890";
		if(id.length()!=9) {
			return "Error: ID need to contain 9 digits";
		}
		for(int i=0;i<id.length();i++) {
			if(!numbers.contains(id.subSequence(i, i+1))) {
				return "Error: Invalid ID";
			}
		}
		return "OK";
	}

	//party member adding
	public String addPartyMember(String name,String id,LocalDate date,int ballot,boolean insulation,PoliticalParty politicalParty,String position) {	
		String numbers="1234567890";
		for(int i=0;i<position.length();i++) {
			if(!numbers.contains(position.subSequence(i, i+1))) {
				return "Error: Invalid position";
			}
		}
		int pos=Integer.parseInt(position);
		String checkResult=new String();
		checkResult=idcheck(id);
		if(!checkResult.equals("OK"))
			return checkResult;
		if(Period.between(date, LocalDate.now()).getYears()<23)
			return "Error: You must be 23 in order to be party member";
		checkResult=ad.getBallotBynum(ballot).getBallotType();
		PartyMember newMember;
		if(insulation==true)//corona
			if(checkResult.equals("CORONA")) {
				newMember=new CoronaPartyMember(name,id,date,ballot,politicalParty);
				ad.addPartyMember(newMember, pos, politicalParty);
				ad.addCitizen(newMember);
				return "Party member with corona "+name+" had been added";
			}
		if(insulation==false)//normal
			if(checkResult.equals("REGULAR")) {
				newMember=new PartyMember(name,id,date,ballot,politicalParty);
				ad.addPartyMember(newMember, pos, politicalParty);
				ad.addCitizen(newMember);
				return "Party member "+name+" had been added";
			}
		return "Error: You cant choose this ballot";
	}

	//party adding
	public boolean addParty(PoliticalParty Party) {
		ad.addPoliticalParty(Party);;
		return true;
	}
	
	public PoliticalParty getPartyByName(String name) {
		return ad.getPoliticalPartyByName(name);
	}

	public String ballotsString() {
		return ad.ballotsShow();
	}
	
	public String CitizenString() {
		return ad.citizensShow();
	}
	
	public String PartiesString() {
		return ad.partiesShow();
	}

	public void addVotesToParty(String partyName,int add) {
		ad.getPoliticalPartyByName(partyName).addVotes(add);
	}
	
	public void addVotesToBallot(int ballotNum,int add) {
		ad.getBallotBynum(ballotNum).setVotesCount(add);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
