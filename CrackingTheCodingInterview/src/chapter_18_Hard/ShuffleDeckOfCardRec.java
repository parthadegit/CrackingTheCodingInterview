/*
 * Question: 
 * 			Write a method to shuffle a deck of cards. It must be a perfect shuffle—in other words, each of the 52! permutations of the deck has to be equally likely. Assume that you are given a random number generator which is perfect.
*/

package chapter_18_Hard;

import java.util.Random;

public class ShuffleDeckOfCardRec {

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
		shuffleCardsRec(deckOfCards);
		System.out.println("Cards after shuffling are sequenced in the following order:");
		printCardSequence(deckOfCards);
	}

	private static void printCardSequence(int[] deckOfCards) {
		for(int i=0;i<deckOfCards.length;i++){
			System.out.print(deckOfCards[i]+",");
		}
		System.out.println();
	}

	private static void shuffleCardsRec(int[] deckOfCards) {
		if(deckOfCards.length>=2){
			shuffleCardsRecUtil(deckOfCards, deckOfCards.length);
		}
	}

	private static void shuffleCardsRecUtil(int[] deckOfCards, int length) {
		if(length == 2){
			swap(deckOfCards,0,1);
			return;
		}
		shuffleCardsRecUtil(deckOfCards,length-1);
		Random rand = new Random();
		int loc = rand.nextInt(length-2);
		swap(deckOfCards,loc,length-1);
	}

	private static void swap(int[] deckOfCards, int loc, int length) {
		int temp = deckOfCards[loc];
		deckOfCards[loc] = deckOfCards[length];
		deckOfCards[length]=temp;
	}
}
