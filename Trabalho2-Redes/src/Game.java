
public class Game {
	String[] cards;
	String[] currentCards;
	
	public Game() {
		cards = new String[10];
		
		cards[0] = "A";
		cards[1] = "B";
		cards[2] = "D";
		cards[3] = "D";
		cards[4] = "C";
		cards[5] = "B";
		cards[6] = "A";
		cards[7] = "E";
		cards[8] = "C";
		cards[9] = "E";
		
		currentCards = new String[10];
		for(int i = 0; i < currentCards.length; i++) {
			currentCards[i] = Integer.toString(i);
		}
	}
	
	public boolean checkPair(int f, int l) {
		if(currentCards[f].equals(currentCards[l])) {
			return true;
		} else {
			return false;
		}
	}
	
	public void drawCard(int p) {
		currentCards[p] = cards[p];
	}
	
	public void resetCard(int f, int l) {
		currentCards[f] = Integer.toString(f);
		currentCards[l] = Integer.toString(l);
	}
	
	public String[] getCards() {
		return cards;
	}
	
	
	public String[] getCurrentCards() {
		return currentCards;
	}
}
