package com.deckcompare;

import java.util.List;

public class DeckComparer {

	private CardList deckA;
	private CardList deckB;
	private List<Integer> cardPool;
	private CardList cardsJustInA = new CardList();
	private CardList cardsJustInB = new CardList();
	private CardList cardsInBoth = new CardList();
	
	public CardList getCardsJustInA() {
		return cardsJustInA;
	}

	public CardList getCardsJustInB() {
		return cardsJustInB;
	}

	public CardList getCardsInBoth() {
		return cardsInBoth;
	}

	public DeckComparer(String deckCodeA, String deckCodeB) {
		deckA = new CardList(deckCodeA);
		deckB = new CardList(deckCodeB);
		
		cardPool = deckA.getAllCards();		
		List<Integer> allCardsB = deckB.getAllCards();
		for (int i = 0; i < deckB.size(); i++) {
			if (!cardPool.contains(allCardsB.get(i))) {
				cardPool.add(allCardsB.get(i));
			}
		}
	}
	
	public void compare() {
		
		
		for (int i = 0; i < cardPool.size(); i++) {
			
			int card = cardPool.get(i);
			
			if (deckA.getSingles().contains(card)) {
				
				if (deckB.getSingles().contains(card)) {
					// 1 in A, 1 in B
					cardsInBoth.appendSingles(card);
				} 
				
				else if (deckB.getDoubles().contains(card)) {
					// 1 in A, 2 in B
					cardsInBoth.appendSingles(card);
					cardsJustInB.appendSingles(card);
				}
				
				else {
					// 1 in A, 0 in B
					cardsJustInA.appendSingles(card);
				}
				
			}
			
			else if (deckA.getDoubles().contains(card)) {
				
				if (deckB.getSingles().contains(card)) {
					// 2 in A, 1 in B
					cardsJustInA.appendSingles(card);
					cardsInBoth.appendSingles(card);
				}
				
				else if (deckB.getDoubles().contains(card)) {
					// 2 in A, 2 in B
					cardsInBoth.appendDoubles(card);
				}
				
				else {
					// 2 in A, 0 in B
					cardsJustInA.appendDoubles(card);
				}
				
			}
			
			else {
				
				if (deckB.getSingles().contains(card)) {
					// 0 in A, 1 in B
					cardsJustInB.appendSingles(card);
				}
				
				else if (deckB.getDoubles().contains(card)) {
					// 0 in A, 2 in B
					cardsJustInB.appendDoubles(card);
				}
				
				else {
					// 0 in A, 0 in B (something went wrong)
					System.out.println("oopsy woopsy");
				}
			}
			
		}

	}
	
}