package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class CreatingAD {
	private static List <Ballot> allBallots=new ArrayList<>();
	private static Set <Citizen> allCitizens=new Set<Citizen>();
	private static List<PoliticalParty> allPoliticalsPartyies=new ArrayList<PoliticalParty>();
	
	
	public static AdministrativeDepartment NewAD(){		
		allBallots.add(new Ballot("Rosh haHayin","REGULAR"));//1
		allBallots.add(new Ballot("Ramela","REGULAR"));//2
		allBallots.add(new Ballot("Nevatim-Air Base","ARMY"));//3
		allBallots.add(new Ballot("Tel Aviv-Corona","CORONA"));//4
		allBallots.add(new Ballot("Tel Aviv","ARMYCORONA"));//5
		
		LocalDate D1=LocalDate.of(2000,10,29);//soldier
		LocalDate D2=LocalDate.of(2001,10,23);//soldier
		LocalDate D3=LocalDate.of(1970,11,29);
		LocalDate D4=LocalDate.of(1990,8,29);
		LocalDate D5=LocalDate.of(1999,1,9);
		LocalDate D6=LocalDate.of(1996,11,23);
		
		allCitizens.add(new Soldier("c1","000000001",D1,3));
		allCitizens.add(new CoronaPatientSoldier("c2","000000002",D2,5));
		allCitizens.add(new Soldier("c3","000000003",D1,3));
		allCitizens.add(new Soldier("c4","000000004",D1,3));
		allCitizens.add(new CoronaPatient("c5","000000005",D3,4));
		allCitizens.add(new Citizen("c6","000000006",D3,1));
		allCitizens.add(new Citizen("c7","000000007",D6,2));
		allCitizens.add(new Citizen("c8","000000008",D4,2));
		allCitizens.add(new CoronaPatient("c9","000000009",D5,4));
		allCitizens.add(new Citizen("c10","000000010",D3,2));
		allCitizens.add(new Citizen("c11","000000011",D4,1));
		
		
		
		PoliticalParty likod=new PoliticalParty("Likod", "right", D1);
		allPoliticalsPartyies.add(likod);
		PoliticalParty avoda=new PoliticalParty("Avoda", "left", D2);
		allPoliticalsPartyies.add(avoda);
		PoliticalParty meretz=new PoliticalParty("Meretz", "left", D3);
		allPoliticalsPartyies.add(meretz);
		PoliticalParty hosen=new PoliticalParty("Hosen leisrael", "middle", D4);
		allPoliticalsPartyies.add(hosen);
		CoronaPartyMember bibi=new CoronaPartyMember("Bibi","000000012",D3,4,allPoliticalsPartyies.get(allPoliticalsPartyies.indexOf(likod)));
		allCitizens.add(bibi);
		allPoliticalsPartyies.get(allPoliticalsPartyies.indexOf(likod)).addMember(bibi, 0);
		PartyMember peretz=new PartyMember("Peretz","000000013", D4, 1,allPoliticalsPartyies.get(allPoliticalsPartyies.indexOf(avoda)));
		allCitizens.add(peretz);
		allPoliticalsPartyies.get(allPoliticalsPartyies.indexOf(avoda)).addMember(peretz, 0);

		PartyMember zandberg=new PartyMember("Zandberg","000000014", D5, 2,allPoliticalsPartyies.get(allPoliticalsPartyies.indexOf(meretz)));
		allCitizens.add(zandberg);
		allPoliticalsPartyies.get(allPoliticalsPartyies.indexOf(meretz)).addMember(zandberg, 0);

		CoronaPartyMember gantz=new CoronaPartyMember("Gantz","000000015", D6, 4,allPoliticalsPartyies.get(allPoliticalsPartyies.indexOf(hosen)));
		allCitizens.add(gantz);
		allPoliticalsPartyies.get(allPoliticalsPartyies.indexOf(hosen)).addMember(gantz, 0);
		
		addCitizenToBllot();
		addPartiesToBallot();
		AdministrativeDepartment admin=new AdministrativeDepartment(allCitizens, allPoliticalsPartyies,allBallots);
		return admin;
		
	}
	
	public static void addCitizenToBllot() {
		for(int i=0;i<allCitizens.size();i++) {
			allBallots.get(allCitizens.get(i).getBallotNum()-1).addCitizen(allCitizens.get(i));
		}
	}
	public static void addPartiesToBallot() {
		for(int i=0;i<allBallots.size();i++) {
			allBallots.get(i).setAllParties(allPoliticalsPartyies);
		}
	}
	
	
	
}




