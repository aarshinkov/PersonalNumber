package main;

import egn.EGN;

public class EgnMain {

	public static void main(String[] args) throws Exception {
		EGN egn = new EGN(""); 
		
		System.out.println("Person with EGN: " + egn.getEgn());
		System.out.println("Gender: " + egn.getGender().getDisplayText());
		System.out.println("Born in: " + egn.getRegion().getRegionName());
	}

}
