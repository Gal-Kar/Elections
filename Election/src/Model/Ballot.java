package Model;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Ballot {
	private enum eBallotType {REGULAR,ARMY,CORONA,ARMYCORONA}
	private eBallotType ballotType;
	private static int ballotNumberCounter=1;
	private int ballotNumber;
	private String ballotAddress;
	private List<Citizen> ballotAssociatedCitizen;
	private List<PoliticalParty> allParties;
	private List<Integer> allVotes;
	private int votesCount=0;


	public Ballot(String add,List<Citizen> associatedCitizen,List<PoliticalParty> parties,String strBallotType) {
		this.ballotType=eBallotType.valueOf(strBallotType);
		ballotNumber=ballotNumberCounter++;
		ballotAddress=add;
		allParties.addAll(parties);
		ballotAssociatedCitizen=associatedCitizen;
	}

	public Ballot(String add,String strBallotType) {//building a ballot with no parties and citizens
		ballotNumber=ballotNumberCounter++;
		ballotAddress=add;
		allParties=new ArrayList<PoliticalParty>();
		allParties=new ArrayList<PoliticalParty>();
		ballotAssociatedCitizen=new ArrayList<Citizen>();
		allVotes=new ArrayList<Integer>();
		ballotType=eBallotType.valueOf(strBallotType);
	}

	public List<Citizen> gerBallotAssociatedCitizen(){
		return ballotAssociatedCitizen;
	}

	public void setVotesCount(int count) {
		votesCount=count;
	}

	public String getBallotAdd() {
		return ballotAddress+" "+getBallotType();
	}
	
	public void setAllParties(List<PoliticalParty> lp) {
		allParties.clear();
		allParties.addAll(lp);
	}
	
	public int getBallotNum() {
		return ballotNumber;
	}

	public void addCitizen(Citizen newCitizen) {
		ballotAssociatedCitizen.add(newCitizen);
	}

	public void addPoliticalParty(PoliticalParty newPoliticalParty) {
		allParties.add(newPoliticalParty);
	}

	public void vote(Scanner input) {	//start the elections-send all the assosiated citizens to vote
		resetVoteList();
		for(int i=0;i<ballotAssociatedCitizen.size();i++) {
			System.out.println("hello "+ballotAssociatedCitizen.get(i).getName());
			if(ballotAssociatedCitizen.get(i).checkIfCanVote()) {
				canVote(input);
				}
		}
	}

	public void canVote(Scanner input) {    //all persons that are able to vote will be sent here
		boolean validVote=false;
		int voteInput;
		System.out.println("if you dont want to vote press 0");
		printPartiesName();
		while(!validVote) {
			try {
				voteInput=input.nextInt();
				if(voteInput==0) 
					break;
				allVotes.set(voteInput-1, allVotes.get(voteInput-1)+1);
				validVote=true;
				votesCount++;
			}catch(Exception e) {
				System.out.println("Invalid Input:"+e.getMessage());
				System.out.println("try again");
				input.nextLine();
			}
		}
	}

	public void resetVoteList(){
		for(int i=0;i<allParties.size();i++) {
			allVotes.add(0);
		}
	}

	public void printPartiesName() {
		for(int i=0;i<allParties.size();i++) {
			System.out.println("for "+allParties.get(i).getPoliticalPartyName()+" prees-"+(i+1));
		}
	}

	public int getPartyVotes(PoliticalParty party) {
		int spot= allParties.indexOf(party);
		return allVotes.get(spot);
	}

	public List<Citizen> getBallotAssociatedCitizen(){
		return ballotAssociatedCitizen;
	}
	
	public List<PoliticalParty> getAllParties(){
		return allParties;
	}

	public String getBallotType() {
		return ballotType.name();
	}

	public double votingPercentage() {
		
		try {
			return (double)100*votesCount/(ballotAssociatedCitizen.size());
		}
		catch(Exception e) {
			return 0;
		}
	}

	public boolean equals(Ballot b) {
		if(ballotAddress==b.ballotAddress||ballotNumber==b.ballotNumber)
			return true;
		return false;
	}

	public String votesPreform() {
		String ballotInfo=new String();
		ballotInfo= "\nBallot Number=" + ballotNumber + ", Address=" + ballotAddress+"\n";
		ballotInfo+="\nAnd to the results!";
		for(int i=0;i<allParties.size();i++) {
			ballotInfo+="\n"+allParties.get(i).getPoliticalPartyName()+" have "+getPartyVotes(allParties.get(i));
			allParties.get(i).addVotes(getPartyVotes(allParties.get(i)));
		}
		ballotInfo+="\nvotes Counted:"+ votesCount +" and its "+votingPercentage()+" voting percentage";
		return ballotInfo.toString();
	}

	public String ballotShow() {
		return "Ballot location: "+ballotAddress+" ballot number: "+ballotNumber+" ballot type "+ballotType;
	}

	public String toString() {
		String ballotInfo=new String();
		ballotInfo=ballotShow()+"\nAssociated citizen:\n";
		for(int i=0;i<ballotAssociatedCitizen.size();i++) {
			ballotInfo+=ballotAssociatedCitizen.get(i).toString()+"\n";
		}
		ballotInfo+=votesPreform();
		return ballotInfo.toString();
	}
}
