package day_4;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int deck[] = { 2, 12, 98, 45, 23, 78, 13 };
		int n = deck.length;

		for (int cardIndex = 1; cardIndex < n; cardIndex++) {
			int cardToPlace = deck[cardIndex];
			int position = cardIndex - 1;// scan backward

			while (position >= 0 && deck[position] > cardToPlace) {

				deck[position + 1] = deck[position];

				position--;// go backwards
			}
			deck[position + 1] = cardToPlace;
		}
		
		System.out.println(Arrays.toString(deck));

	}

}
