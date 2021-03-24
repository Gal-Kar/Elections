package Model;

import java.time.LocalDate;
import java.util.Scanner;

public class CoronaPatient extends Citizen {

	public CoronaPatient(String name, String id, LocalDate dateOfBirth, int ballot) {
		super(name, id, dateOfBirth, ballot);
	}
	
	public boolean checkIfCanVote() {
		Scanner input=new Scanner(System.in);
		int ans;
		System.out.println("for how long have you been in Insulation?");
		while(true) {
			try{
				ans=input.nextInt();
				if(ans<14) {
					System.out.println("sorry you havent been long enaf in insulation");
					return false;
					}
				else
					return true;

			}catch(Exception e) {
				System.out.println("eror in input:"+e.getMessage());
			}
		}
	}
	
	public String toString() {
		return"Corona patient "+super.toString();
		
	}
}
