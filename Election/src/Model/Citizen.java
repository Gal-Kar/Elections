package Model;

import java.time.LocalDate;
import java.time.Period;

public class Citizen {
	private String name;
	private String id;
	private LocalDate dateOfBirth;
	private int ballot;

	public Citizen(String name, String id, LocalDate dateOfBirth, int ballot) {
		this.name = name;
		this.id=id;
		this.dateOfBirth=dateOfBirth;
		this.ballot = ballot;
	}

	public String getName() {
		return name;
	}

	public boolean checkIfCanVote() {
		return true;
	}
	
	public String getID() {
		return id;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public int getBallotNum() {
		return ballot;
	}

	public boolean canVote() {
		LocalDate current=LocalDate.now();
		if(Period.between(dateOfBirth, current).getYears()>=18) {
			return true;
		}
		return false;
	}

	public boolean equals(Citizen c) {
		if(c.id==id) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "name: "+name+" ,id "+id+" ,date of birth: "+dateOfBirth+" ,ballot: "+ballot+"\n";
	}	
}


