class SimpleDotCom {
	private int[] locationCells;
	private int numOfHits = 0;

	public String checkYourself(String stringGuess) {
		int guess = Integer.parseInt(stringGuess);
		String result = "miss";

		for (int cell : locationCells ) {
			if (cell == guess) {
				result = "hit";
				numOfHits++;
				break;
			}
		}

		if (numOfHits == locationCells.length) {
			result = "kill";
		}

		System.out.println(result);

		return result;
	}

	public void setLocationCells(int[] cellLocations){
		locationCells = cellLocations;
	}
}

public class SimpleDotComTestDrive {
	public static void main(String[] args) {
		SimpleDotCom dot = new SimpleDotCom();
		int[] locations = {1, 2, 3};

		dot.setLocationCells(locations);

		String userGuess = "2";
		String result = dot.checkYourself(userGuess);
		String testResult = "failed";
		if (result.equals("hit")) {
			testResult = "passed";
		}
		System.out.println(testResult);
	}
}