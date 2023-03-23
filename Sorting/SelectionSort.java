import java.util.Arrays;

public class Selection_Sort {
	public static void selectionSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {

			System.out.println("Start of Iteration (i = " + i + ") " + Arrays.toString(numbers));
			int indexSmallest = i;
			System.out.println("Smallest Index (i = " + i + "): " + i + ", " + numbers[i]);
			int j;
			for (j = i + 1; j < numbers.length; j++) {

				if (numbers[j] < numbers[indexSmallest]) {
					indexSmallest = j;

				}
				System.out.println("Smallest Index (j = " + j + "): " + indexSmallest + ", " + numbers[indexSmallest]);
			}

			int temp = numbers[i];
			numbers[i] = numbers[indexSmallest];
			numbers[indexSmallest] = temp;

			System.out.println("End of Iteration (i = " + i + ") " + Arrays.toString(numbers));

			System.out.println("\n\n");
		}
	}

	public static void main(String[] args) {

		int[] numbers = { 93, 87, 68, 55, 49, 42, 30, 11 };

		System.out.println("Before Sort: " + Arrays.toString(numbers));

		System.out.println("\n\n");

		selectionSort(numbers);

		System.out.println("After Sort: " + Arrays.toString(numbers));
	}
}
