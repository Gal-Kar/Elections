package Elections;

import java.util.Scanner;

public class MainProgram {
	
	public static int Menu() {
		Scanner input=new Scanner(System.in);
		System.out.println("this is the interactive menu.\nwhat would you like to do?");
		System.out.println("1-add ballot\n2-add citizen");
		System.out.println("3-add add party\n4-add citizen as candidate for particular party");
		System.out.println("5-view all the bollots\n6-view all citizens");
		System.out.println("7-view all parties\n8-Elections");
		System.out.println("9-elections results\n10-exit");
		return input.nextInt();
	}

	public static void main(String[] args) {
		MenuManagement n=new MenuManagement();
		int choise=Menu();	
		do {
			switch(choise) {
			case 1:
				n.addBallot();
				break;
			case 2:
				n.addCitizen();
				break;
			case 3:
				n.addParty();
				break;
			case 4:
				n.addPartyMember();
				break;
			case 5:
				System.out.println(n.boolotsShow());
				break;
			case 6:
				System.out.println(n.citizensShow());
				break;
			case 7:
				System.out.println(n.partiesShow());
				break;
			case 8:
				n.elections();
				break;
			case 9:
				System.out.println(n.electionsResults());
				break;
			case 10:
				System.out.println("Thank you and goodbye");
				break;
			default: System.out.println("invaild selection");
			}
		}while(choise>10);
	}

}

