package egn;

public class EGN {

	private String egn;
	private Integer[] egnArray = new Integer[10];

	private Gender gender = new Gender();

	private Region region = new Region();

	private Integer controlNumber;

	public EGN(String egn) throws Exception {
		super();
		this.egn = egn;
		createEgnArray();
		if (!isControlNumberValid()) {
			throw new Exception("This EGN is not valid. Control number does not match!");
		}

		defineRegion();
		defineGender();
	}

	private void createEgnArray() {
		String[] egnArr = egn.split("");
		for (int i = 0; i < egnArr.length; i++) {
			Integer number = Integer.parseInt(egnArr[i]);
			egnArray[i] = number;
		}
	}

	private boolean isControlNumberValid() {
		int sum = 0;
		for (int i = 0; i < egnArray.length; i++) {
			switch (i) {
			case 0:
				sum += egnArray[i] * 2;
				break;
			case 1:
				sum += egnArray[i] * 4;
				break;
			case 2:
				sum += egnArray[i] * 8;
				break;
			case 3:
				sum += egnArray[i] * 5;
				break;
			case 4:
				sum += egnArray[i] * 10;
				break;
			case 5:
				sum += egnArray[i] * 9;
				break;
			case 6:
				sum += egnArray[i] * 7;
				break;
			case 7:
				sum += egnArray[i] * 3;
				break;
			case 8:
				sum += egnArray[i] * 6;
				break;
			}
		}
		controlNumber = sum % 11;
		
		if (controlNumber == 10) {
			controlNumber = 0;
		}
		return controlNumber == egnArray[9];
	}

	private void defineRegion() {
		Integer result = egnArray[6] * 100 + egnArray[7] * 10 + egnArray[8];

		if (result >= 0 && result <= 43) {
			region.setRegionName("Blagoevgrad");
		} else if (result >= 44 && result <= 93) {
			region.setRegionName("Burgas");
		} else if (result >= 94 && result <= 139) {
			region.setRegionName("Varna");
		} else if (result >= 140 && result <= 169) {
			region.setRegionName("Veliko Tarnovo");
		} else if (result >= 170 && result <= 183) {
			region.setRegionName("Vidin");
		} else if (result >= 184 && result <= 217) {
			region.setRegionName("Vratsa");
		} else if (result >= 218 && result <= 233) {
			region.setRegionName("Gabrovo");
		} else if (result >= 234 && result <= 281) {
			region.setRegionName("Kardzhali");
		} else if (result >= 282 && result <= 301) {
			region.setRegionName("Kiustendil");
		} else if (result >= 302 && result <= 319) {
			region.setRegionName("Lovech");
		} else if (result >= 320 && result <= 341) {
			region.setRegionName("Montana");
		} else if (result >= 342 && result <= 377) {
			region.setRegionName("Pazardzhik");
		} else if (result >= 378 && result <= 395) {
			region.setRegionName("Pernik");
		} else if (result >= 396 && result <= 435) {
			region.setRegionName("Pleven");
		} else if (result >= 436 && result <= 501) {
			region.setRegionName("Plovdiv");
		} else if (result >= 502 && result <= 527) {
			region.setRegionName("Razgrad");
		} else if (result >= 528 && result <= 555) {
			region.setRegionName("Ruse");
		} else if (result >= 556 && result <= 575) {
			region.setRegionName("Silistra");
		} else if (result >= 576 && result <= 601) {
			region.setRegionName("Sliven");
		} else if (result >= 602 && result <= 623) {
			region.setRegionName("Smolian");
		} else if (result >= 623 && result <= 721) {
			region.setRegionName("Sofia - grad");
		} else if (result >= 722 && result <= 751) {
			region.setRegionName("Sofia - okrag");
		} else if (result >= 752 && result <= 789) {
			region.setRegionName("Stara zagora");
		} else if (result >= 790 && result <= 821) {
			region.setRegionName("Dobrich");
		} else if (result >= 822 && result <= 843) {
			region.setRegionName("Targovishte");
		} else if (result >= 844 && result <= 871) {
			region.setRegionName("Haskovo");
		} else if (result >= 872 && result <= 903) {
			region.setRegionName("Shumen");
		} else if (result >= 904 && result <= 925) {
			region.setRegionName("Qmbol");
		} else if (result >= 926 && result <= 999) {
			region.setRegionName("Drug...");
		}
	}
	
	public void defineGender() {
		if (egnArray[8] % 2 == 0) {
			gender.setGender('m');
			gender.setDisplayText("Male");
		} else {
			gender.setGender('f');
			gender.setDisplayText("Female");
		}
	}

	public String getEgn() {
		return egn;
	}

	public void setEgn(String egn) {
		this.egn = egn;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Integer getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(Integer controlNumber) {
		this.controlNumber = controlNumber;
	}
}
