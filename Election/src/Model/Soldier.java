package Model;

import java.time.LocalDate;
import java.util.Scanner;

public class Soldier extends Citizen {

	public Soldier(String name, String id, LocalDate dateOfBirth, int ballot) {
		super(name, id, dateOfBirth, ballot);
	}
	public boolean checkIfCanVote() {
		Scanner input=new Scanner(System.in);
		int ans;
		System.out.println("are you carring wepon? (1-no, 2-yes)");
		while(true) {
			try{
				ans=input.nextInt();
				if(ans==1)
					return true;
				if(ans==2)
					return false;
				else
					System.out.println("invalid input try again");

			}catch(Exception e) {
				System.out.println("eror in input:"+e.getMessage());
			}
		}
	}
	
	public String toString() {
		return"Soldier "+super.toString();
		
	}
}
