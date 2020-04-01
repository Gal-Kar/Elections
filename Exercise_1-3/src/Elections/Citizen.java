package Elections;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Citizen {
	private String name;
	private int id;
	private LocalDate dateOfBirth;
	private int ballot;
	private boolean inInsulation;
	private boolean ispoliticalParty;
	private boolean isProtected;
	private boolean isSoldier;
	
	public Citizen(String name, int id, LocalDate dateOfBirth, int ballot, boolean inInsulation) {
		this.name = name;
		idCheck(id);
		this.dateOfBirth = dateOfBirth;
		this.ballot = ballot;
		this.inInsulation = inInsulation;
	}

	public boolean UseProtectiveClothing() {
		Scanner input=new Scanner(System.in);
		System.out.println("are you with protective clothing? (yes/no)");
		isProtected=input.hasNext();
		return isProtected;
	}
	
	public boolean IsSoldier() {
		LocalDate current=LocalDate.now();
		if(Period.between(dateOfBirth, current).getYears()>=18 && Period.between(dateOfBirth, current).getYears()<=21) {
			return true;
		}
		return false;
	}

	private void idCheck(int id) {
		if(1000000<=id || id<=100000000) 
			this.id=id;
		else this.id=1111111;
	}

	public boolean getInInsulation() {
		return inInsulation;
	}

	public String getName() {
		return name;
	}

	public boolean canVote() {
		LocalDate current=LocalDate.now();
		if(Period.between(dateOfBirth, current).getYears()>=18) {
			return true;
		}
		return false;
	}

	public boolean equals(Citizen c) {
		if(c.id==id && c.name.equals(name)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Citizen name: "+name+" ,id "+id+" ,date of birth: "+dateOfBirth+" ,ballot: "+ballot+" ,insulation status: "+inInsulation;
	}
	
	
	

}

