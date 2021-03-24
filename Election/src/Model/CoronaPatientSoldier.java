package Model;

import java.time.LocalDate;
import java.util.Scanner;

public class CoronaPatientSoldier extends Soldier {

	public CoronaPatientSoldier(String name, String id, LocalDate dateOfBirth, int ballot) {
		super(name, id, dateOfBirth, ballot);
	}
	
	public boolean checkIfCanVote() {
		Scanner input=new Scanner(System.in);
		int ans;
		System.out.println("for how long have you been in insulation?");
		while(true) {
			try{
				ans=input.nextInt();
				if(ans<14) {
					System.out.println("sorry you havent been long enaf in insulation");
					return false;
				}
				else
					break;

			}catch(Exception e) {
				System.out.println("eror in input:"+e.getMessage());
			}
		}
		return super.checkIfCanVote();
	}
	
	public String toString() {
		return"Corona patient  "+super.toString();
	}
}


