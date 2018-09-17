class QuizCardBuilder {
	void go {
		// build and display gui
	}

	// Inner class for next card button 
	class NextCardListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
		// add the current card to the list and clear the text areas
		}
	}

	class SaveMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
		// bring up a file dialog box, let the user name and save the set
		}
	}

	class NewMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
		// clear out the card list, and clear out the text area
		}
	}

	private void saveFile(File file) {
		// iterate through the list of cards, and write each one out to a text file
	}
}