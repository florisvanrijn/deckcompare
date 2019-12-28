package com.deckcompare;

import java.util.ArrayList;
import java.util.List;

public class CardList {
	
	private List<Integer> singles;
	private List<Integer> doubles;
	private Integer size;
	
	
	//Constructor for empty CardList
	public CardList() {
		singles = new ArrayList<Integer>();
		doubles = new ArrayList<Integer>();
	}
	//Constructor for given list of singles and doubles
	public CardList(List<Integer> singles, List<Integer> doubles) {
		this.singles = singles;
		this.doubles = doubles;
		size = singles.size() + doubles.size();
	}
	
	//Constructor for given deck code
	public CardList(String deckCode) {
		ArrayList<Integer> deck = DeckcodeHelper.Decode(deckCode);
		singles = setSinglesFromDeck(deck);
		doubles = setDoublesFromDeck(deck);
		size = singles.size() + doubles.size();
	}
	
	public List<Integer> getSingles() {
		return singles;
	}
	
	public List<Integer> getDoubles() {
		return doubles;
	}
	
	public void appendSingles(int card) {
		singles.add(card);
	}
	
	public void appendDoubles(int card) {
		doubles.add(card);
	}
	
	public List<Integer> getAllCards() {
		List<Integer> allCards = new ArrayList<Integer>();
		
		for (int i = 0; i < singles.size(); i++) {
			allCards.add(singles.get(i));
		}
		
		for (int i = 0; i < doubles.size(); i++) {
			allCards.add(doubles.get(i));
		}
		
		return allCards;
		
	}
	
	public int size() {
		return size;
	}
	
	private List<Integer> setSinglesFromDeck(ArrayList<Integer> deck) {
		int fromIndex = 5;
		//int toIndex = 5 + deck.get(5);
		int toIndex = fromIndex + deck.get(4);
		
		return deck.subList(fromIndex, toIndex);
	}
	
	private List<Integer> setDoublesFromDeck(ArrayList<Integer> deck) {
		
		int doublesSizeIndex = 5 + deck.get(4);
		int fromIndex = doublesSizeIndex + 1;
		int toIndex = fromIndex + deck.get(doublesSizeIndex);
		
		return deck.subList(fromIndex, toIndex);
	}
}
