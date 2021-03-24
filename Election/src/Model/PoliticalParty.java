package Model;

import java.time.LocalDate;

public class PoliticalParty {
	private String politicalPartyName;
	private String politicalStream;
	private PartyMember[] politicalPartyMembers;
	private LocalDate establishmentDay;
	private int votes=0;

	public void addVotes(int add) {
		votes+=add;
	}

	public int getVotes() {
		return votes;
	}

	public PoliticalParty(String name,String stram,LocalDate date) {
		politicalPartyName=name;
		politicalStream=stram;
		politicalPartyMembers=new PartyMember[120];
		establishmentDay=date;
	}

	public String getPoliticalPartyName() {
		return politicalPartyName;
	}

	public String showResults() {
		return "\nParty Name:"+politicalPartyName+" got "+votes+" votes";
	}

	public boolean addMember(PartyMember newMember,int position){
		if(membersCount()>=politicalPartyMembers.length) {
			System.out.println("we can't add new members (we are full)");
			return false;
		}
		if(position==0) {//add to the first available position
			for(int i=0;i<politicalPartyMembers.length;i++) {
				if(politicalPartyMembers[i]==null) {
					politicalPartyMembers[i]=newMember;
					return true;
				}
			}
		}
		for(int i=politicalPartyMembers.length-2;i>=position-1;i--) {//moving all members one spot
			if(politicalPartyMembers[i]!=null) {
				politicalPartyMembers[i+1]=politicalPartyMembers[i];
				politicalPartyMembers[i]=null;
			}
		}
		politicalPartyMembers[position-1]=newMember;
		System.out.println("all members from position "+position+" moved one position higher and "
				+newMember.getName()+" entered the "+position+" position");
		return true;
	}

	public int membersCount() {
		int count=0;
		for(int i=0;i<politicalPartyMembers.length;i++) {
			if(politicalPartyMembers[i]!=null)
				count++;
		}
		return count;
	}

	public boolean equals(PoliticalParty p2) {
		if(p2.establishmentDay.isEqual(establishmentDay)&&p2.votes==this.votes&&p2.politicalPartyName==politicalPartyName) {
			return true;
		}
		return false;
	}


	public String toString() {
		String info= "Political party "+ politicalPartyName + ", that belong to the" + politicalStream
				+ " political stream, with the members:\n";
		for(int i=0;i<politicalPartyMembers.length;i++) {
			if(politicalPartyMembers[i]!=null)
				info+=politicalPartyMembers[i].getName()+", ";
		}
		info+="\nwas establised on:"+ establishmentDay +",has "+votes+" votes\n";
		return info;
	}



}
