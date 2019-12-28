package com.deckcompare;

public class MainClass {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		String deckStringA = "AAECAR8I0wGvBKCAA+OLA6SlA66xA9iyA5+3AwuXCNsJoIUDx50D5KQDu6UD8qUDmKkDjq0D+K8DgrEDAA==";
		String deckStringB = "AAECAR8MrwSrBoyAA6CAA+OLA9ePA6SlA/SnA4ewA66xA9iyA5+3AwnbCaCFA8edA+SkA7ulA5ipA46tA/ivA4KxAwA=";
				
		//ArrayList<Integer> deckA = DeckcodeHelper.Decode(deckStringA);
		//ArrayList<Integer> deckB = DeckcodeHelper.Decode(deckStringB);
				
		DeckComparer deckComparer = new DeckComparer(deckStringA, deckStringB);
		deckComparer.compare();
		CardList justA = deckComparer.getCardsJustInA();
		
		CardList justB = deckComparer.getCardsJustInB();
		
		CardList inBoth = deckComparer.getCardsInBoth();

	}
	
};