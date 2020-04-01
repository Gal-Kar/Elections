package Elections;

import java.time.LocalDate;

public class AdministrativeDepartment {
	private Citizen []Citizens;
	private PoliticalParty[]politicalPartys;
	private Ballot[]ballots;
	private LocalDate date;
	
	public AdministrativeDepartment(int citizensNum, int politicalPartysNum, int ballotsNum, LocalDate date) {
		Citizens =new Citizen[citizensNum];
		politicalPartys = new PoliticalParty[politicalPartysNum];
		//ballots =new Ballot();
		this.date = date;
	}
	
	
	
	
	
	
	

}

