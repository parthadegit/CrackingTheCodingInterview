/*
 * Question: 
 * 			Write a method to shuffle a deck of cards. It must be a perfect shuffle—in other words, each of the 52! permutations of the deck has to be equally likely. Assume that you are given a random number generator which is perfect.
*/


package chapter_18_Hard;

import java.util.Random;

public class ShuffleDeckOfCardIterative {

	public static void main(String[] args) {
		//Let us assume that we have an array of the cards of size n
		//Instead of card it can be any data type
		int[] deckOfCards = new int[52];
		//Extra function just to initialize the array
		for(int i=0;i<deckOfCards.length;i++){
			deckOfCards[i]=i+1;
		}
		System.out.println("Cards before shuffling are sequenced in the following order:");
		printCardSequence(deckOfCards);
		shuffleCardsIter(deckOfCards);
		System.out.println("Cards after shuffling are sequenced in the following order:");
		printCardSequence(deckOfCards);
	}

	private static void shuffleCardsIter(int[] deckOfCards) {
		Random rand= new Random();
		for(int i=1;i<deckOfCards.length-1;i++){
			int loc = rand.nextInt(i);
			swap(deckOfCards,loc,i+1);
		}
		
	}

	private static void printCardSequence(int[] deckOfCards) {
		for(int i=0;i<deckOfCards.length;i++){
			System.out.print(deckOfCards[i]+",");
		}
		System.out.println();
	}
	
	private static void swap(int[] deckOfCards, int loc, int length) {
		int temp = deckOfCards[loc];
		deckOfCards[loc] = deckOfCards[length];
		deckOfCards[length]=temp;
	}

}
