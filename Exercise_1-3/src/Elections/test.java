package Elections;

import java.time.LocalDate;
import java.time.Month;

public class test {

	public static void main(String[] args) {
		LocalDate myBirth=LocalDate.of(2002,Month.MARCH,29);
		Citizen naor=new Citizen("naor",208412601,myBirth,9,false);
		System.out.println(naor.canVote());
		System.out.println(naor.toString());

	}

}

