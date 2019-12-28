package com.deckcompare;

import java.util.ArrayList;
import java.util.Base64;

public class DeckcodeHelper {
	
	public static ArrayList<Integer> Decode(String deckCode) {
		
		byte[] decodedString = decodeToBytes(deckCode);
		
		int[] intList = bytesToIntegers(decodedString);
		
		String[] byteList = cleanBytes(intList);
		
		ArrayList<Integer> deckList = stitchVarints(byteList);
		
		return deckList;
	}
	
	private static byte[] decodeToBytes(String deckCode) {;
		
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decoded = decoder.decode(deckCode);
		
		return decoded;
	
	}
	
	private static int[] bytesToIntegers(byte[] byteList) {
		
		int[] intList = new int[byteList.length];
		
		for (int i = 0; i < byteList.length; i++) {
			if (byteList[i] < 0) {
				// make positive
				intList[i] = byteList[i] + 256;
			}
			else {
				//keep the same
				intList[i] = byteList[i];
			}
		}
		
		return intList;
	}
	
	private static String[] cleanBytes(int[] intList) {
		String[] binaryRep = new String[intList.length];
		
		for (int i = 0; i < intList.length; i++) {
			binaryRep[i] = Integer.toBinaryString(intList[i]);
		}
		
		for (int i = 0; i < binaryRep.length; i++) {
			while (binaryRep[i].length() < 8) {
				binaryRep[i] = "0" + binaryRep[i];
			}
		}
		
		
		return binaryRep;
	}
	
	private static ArrayList<Integer> stitchVarints(String[] byteStrings) {
		
		ArrayList<ArrayList<String>> byteGroups = new ArrayList<ArrayList<String>>();

		for (int i = byteStrings.length - 1; i > 0; i--) {
			if (byteStrings[i].charAt(0) == '0') {
				//starts with a 0
				ArrayList<String> newGroup = new ArrayList<String>();
				byteGroups.add(0, newGroup);
			}

			byteGroups.get(0).add(byteStrings[i].substring(1));
			
		}
		
		ArrayList<Integer> concatenatedList = new ArrayList<Integer>();
		
		for (int i = 0; i < byteGroups.size(); i++) {

			String concatenated = String.join("", byteGroups.get(i));
			concatenatedList.add(Integer.parseInt(concatenated, 2));
			
		}
		
		return concatenatedList;
		
	}
	
}