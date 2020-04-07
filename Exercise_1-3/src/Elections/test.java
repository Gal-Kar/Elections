package Elections;

import java.time.LocalDate;
import java.time.Month;

public class test {

	public static void main(String[] args) {
		
		
		Ballot B1=new Ballot("Rosh haHayin")
		
		LocalDate D1=LocalDate.of(2000,10,29);
		LocalDate D2=LocalDate.of(2001,10,23);
		LocalDate D3=LocalDate.of(2005,11,29);
		LocalDate D4=LocalDate.of(1990,8,29);
		LocalDate D5=LocalDate.of(1999,1,9);
		LocalDate D6=LocalDate.of(1996,11,23);
		
		Citizen C1=new Citizen("c1",000000001,D1,9,false);
		Citizen C2=new Citizen("c2",000000002,D2,9,false);
		Citizen C3=new Citizen("c3",000000003,D3,9,false);
		Citizen C4=new Citizen("c4",000000004,D1,9,true);
		Citizen C5=new Citizen("c5",000000005,D6,9,false);
		Citizen C6=new Citizen("c6",000000006,D1,9,false);
		Citizen C7=new Citizen("c7",000000007,D2,9,false);
		Citizen C7=new Citizen("c8",000000008,D4,9,false);
		Citizen C8=new Citizen("c9",000000009,D5,9,true);
		Citizen C9=new Citizen("c10",000000010,D3,9,false);
		Citizen C10=new Citizen("c11",000000011,D1,9,false);

		
		System.out.println(naor.canVote());
		System.out.println(naor.toString());

	}

}

