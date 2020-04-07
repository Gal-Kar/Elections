package Elections;
import java.util.Scanner;

public abstract class Ballot {
	protected static int ballotNumberCounter=1;
	protected int ballotNumber;
	protected String ballotAddress;
	protected Citizen[] ballotAssociatedCitizen;
	protected PoliticalParty[] allParties;
	protected int[][] votes;
	protected int votesCount=0;

	public Ballot(String add,Citizen[] associatedCitizen,PoliticalParty[] parties) {
		ballotNumber=ballotNumberCounter++;
		ballotAddress=add;
		allParties=parties;
		votes=new int[allParties.length][2];
		for(int i=0;i<allParties.length;i++) {
			votes[i][0]=allParties[i].getPoliticalPartyNumber();
			votes[i][1]=0;
		}
		ballotAssociatedCitizen=associatedCitizen;
	}
	
	public Ballot(String add) {//building a ballot with no parties and citizens
		ballotNumber=ballotNumberCounter++;
		ballotAddress=add;
		allParties=new PoliticalParty[0];
		votes=new int[allParties.length][2];
		ballotAssociatedCitizen=new Citizen[0];
	}

	public PoliticalParty findPartyByNum(int num) {
		for(int i=0;i<allParties.length;i++) {
			if(allParties[i].getPoliticalPartyNumber()==num)
				return allParties[i];
		}
		return null;
	}

	public void addCitizen(Citizen newCitizen) {
		largerCitizenArr();
		ballotAssociatedCitizen[ballotAssociatedCitizen.length-1]=newCitizen;
	}

	public void largerCitizenArr() {
		Citizen[] newArr=new Citizen[ballotAssociatedCitizen.length+1];
		for(int i=0;i<ballotAssociatedCitizen.length;i++) {
			newArr[i]=ballotAssociatedCitizen[i];
		}
		ballotAssociatedCitizen=newArr;
	}

	public void addPoliticalParty(PoliticalParty newPoliticalParty) {
		largerPoliticalParty();
		votes[votes.length-1][0]=newPoliticalParty.getPoliticalPartyNumber();
		allParties[allParties.length-1]=newPoliticalParty;
	}

	public void largerPoliticalParty() {
		int[][] newArr=new int[votes.length+1][2];
		PoliticalParty[] parties=new PoliticalParty[allParties.length+1];
		for(int i=0;i<votes.length;i++) {
			newArr[i][0]=votes[i][0];
			newArr[i][1]=votes[i][1];
			parties[i]=allParties[i];
		}
		allParties=parties;
		votes=newArr;
	}

	public void vote() {
		Scanner input =new Scanner(System.in);
		int voteInput;
		for(int i=0;i<ballotAssociatedCitizen.length;i++) {
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
	}

	public double votingPercentage() {
		return (double)(votesCount/ballotAssociatedCitizen.length);
	}
	
	public boolean equals(Ballot b) {
		if(b.ballotAddress==ballotAddress && b.ballotNumber==ballotNumber) {
			for(int i=0;i<ballotAssociatedCitizen.leanth;i++) {
				if(b.ballotAssociatedCitizen[i]==null||b.ballotAssociatedCitizen[i]!=ballotAssociatedCitizen[i])
					return false;
			}
			return true;
			}
		}
		return false;
	}

	public String toString() {
		String ballotInfo=new String();
		ballotInfo= "Ballot Number=" + ballotNumber + ", Address=" + ballotAddress+"\nAssociated citizen:";
		for(int i=0;i<ballotAssociatedCitizen.length;i++)
			ballotInfo+=ballotAssociatedCitizen[i].toString()+"\n";
		for(int i=0;i<votes.length;i++)
			ballotInfo+=findPartyByNum(i).getPoliticalPartyName()+" have "+votes[i][1]+"\n";
		ballotInfo+=votesCount +" votes Counted and its "+votingPercentage()+" voting percentage";
		return ballotInfo.toString();
	}
}
