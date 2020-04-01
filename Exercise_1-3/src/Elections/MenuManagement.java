package Elections;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuManagement {
	Scanner input=new Scanner(System.in);

	public void addBallot() {
		// TODO Auto-generated method stub
		
	}

	public void addCitizen() {
		// TODO Auto-generated method stub
		
	}
	String name,String stram,LocalDate date
	public void addParty() {
		System.out.println("what is the party name?");
		String name=input.next();
		System.out.println("what is the party stram?");
		String stram=input.next();
		System.out.println("what is the establishment date?");
		int day=input.nextInt();
		int mon=input.nextInt();
		int year=input.nextInt();
		LocalDate date=LocalDate.of(year, mon, day);
	}

	public void addPartyMember() {
		// TODO Auto-generated method stub
		
	}

	public char[] boolotsShow() {
		// TODO Auto-generated method stub
		return null;
	}

	public char[] citizensShow() {
		// TODO Auto-generated method stub
		return null;
	}

	public char[] partiesShow() {
		// TODO Auto-generated method stub
		return null;
	}

	public void elections() {
		// TODO Auto-generated method stub
		
	}

	public String electionsResults() {
		// TODO Auto-generated method stub
		
	}
	
	

}

