class QuizCard {
	private String question;
	private String answer;

	QuizCard(String q, String a) {
		question = q;
		answer = a;
	}

	String getQuestion() {
		return question;
	}

	String getAnswer() {
		return answer;
	}
}