package Elections;

import java.time.LocalDate;

public class PoliticalParty {
	private String politicalPartyName;
	private String politicalStream;
	private PartyMember[] politicalPartyMembers;
	private LocalDate establishmentDay;
	private static int politicalPartyCounter=0;
	private int PoliticalPartyNumber;

	public int getPoliticalPartyNumber() {
		return PoliticalPartyNumber;
	}

	public PoliticalParty(String name,String stram,LocalDate date) {
		politicalPartyName=name;
		politicalStream=stram;
		politicalPartyMembers=new PartyMember[120];
		establishmentDay=date;
		PoliticalPartyNumber=politicalPartyCounter++;
	}

	public String getPoliticalPartyName() {
		return politicalPartyName;
	}

	public boolean addMember(PartyMember newMember,int position){
		if(membersCount()>=politicalPartyMembers.length) {
			System.out.println("we can't add new members (we are full)");
			return false;
		}
		if(position==0) {//add to the first available position
			for(int i=0;i<politicalPartyMembers.length;i++) {
				if(politicalPartyMembers[i]==null) {
					System.out.println("you have benn added to the "+(i+1)+" spot");
					politicalPartyMembers[i]=newMember;
					return true;
				}
			}
		}
		for(int i=politicalPartyMembers.length;i>=position;i--) //moving all members one spot
			if(politicalPartyMembers[i]!=null) 
				politicalPartyMembers[i+1]=politicalPartyMembers[i];
		politicalPartyMembers[position-1]=newMember;
		System.out.println("all members from position "+position+"mover one position higher and "
				+PartyMember.getName()+" entered the "+position+" position");
	}

	public int membersCount() {
		int count=0;
		for(int i=0;i<politicalPartyMembers.length;i++) {
			if(politicalPartyMembers[i]!=null)
				count++;
		}
		return count;
	}



}
