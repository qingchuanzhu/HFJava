import java.io.*;

class GameHelper {
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) {
				return null;
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}

		return inputLine;
	}
}

public class SimpleDotComGame {
	public static void main(String[] args) {
		int numOfGuesses = 0;

		GameHelper helper = new GameHelper();
		SimpleDotCom dot = new SimpleDotCom();

		int randomNum = (int) (Math.random() * 5);

		int[] locations = {randomNum, randomNum + 1, randomNum + 2};

		dot.setLocationCells(locations);

		boolean isAlive = true;

		while(isAlive) {
			String guess = helper.getUserInput("enter a number");
			String result = dot.checkYourself(guess);
			numOfGuesses++;
			if (result.equals("kill")) {
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
		}
	}
}