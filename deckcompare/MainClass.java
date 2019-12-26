package deckcompare;

import java.util.ArrayList;

public class MainClass {
	
	public static void main(String[] args) {
		
		String deckCode = "AAECAaoICP4Figfv9wKZ+wLLhQPFmQPjtAPTwAMLnAKBBP8Fsgaw8ALPpQO3rQO5rQP+rgOqrwPQrwMA";
		
		byte[] decodedString = DeckcodeHelper.decodeToBytes(deckCode);
		
		int[] intList = DeckcodeHelper.bytesToIntegers(decodedString);
		
		String[] byteList = DeckcodeHelper.cleanBytes(intList);
		
		ArrayList<Integer> deckList = DeckcodeHelper.stitchVarints(byteList);
		
		System.out.println(deckList);
		
	}
	
}