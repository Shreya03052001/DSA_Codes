package day_3;
//Selection sort:
import java.util.Arrays;

public class Selection_Sort {

	public static void main(String[] args) {
		int[] arr = { 11,25,12,22,64,90 };
		int n = arr.length;
		// no of missions
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i; // here i =0;

			// Need to find the index of smallest
			for (int j = i + 1; j < n; j++) {
				// found an index containing smaller element
				if (arr[j] < arr[minIndex]) {

					minIndex = j;

				}
			}
			// Swap array [i] with arr[minIndex]
			if (i != minIndex) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
	}

}
