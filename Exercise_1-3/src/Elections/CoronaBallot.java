package Elections;

import java.time.LocalDate;
import java.util.Scanner;
public class CoronaBallot extends Ballot {
	public CoronaBallot(String add,Citizen[] associatedCitizen,PoliticalParty[] parties) {
		super(add,associatedCitizen,parties);
	}

	public void vote() {
		Scanner input =new Scanner(System.in);
		int voteInput;
		for(int i=0;i<ballotAssociatedCitizen.length;i++) {
			if(ballotAssociatedCitizen[i].UseProtectiveClothing()) {
				System.out.println("hello "+ballotAssociatedCitizen[i].getName()
						+" how would you like to vote?");
				System.out.println("if you dont want to vote press 0");
				for(int j=0;j<votes.length;j++) {
					System.out.println("for "+findPartyByNum(j).getPoliticalPartyName()+" press: "+(j+1));
				}
				voteInput=input.nextInt();
				if(voteInput!=0&&voteInput<=votes.length) {
					votesCount++;
					votes[voteInput-1][1]++;
				}
			}
			else
				System.out.println("you cant vote without protective clothing");	
		}
	}
}

