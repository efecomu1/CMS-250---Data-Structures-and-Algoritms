import java.util.Arrays;

public class Bubble_Sort {
	
	public static void BubbleSort(int []numbers) {
		   for (int i = 0; i < numbers.length - 1; i++) {
			   
			  System.out.println("Start of Iteration: (i = " + i + ") " + Arrays.toString(numbers));
		      for (int j = 0; j < numbers.length - i - 1; j++) {
		         if (numbers[j] > numbers[j+1]) {
		            int temp = numbers[j];
		            numbers[j] = numbers[j + 1];
		            numbers[j + 1] = temp;
		            
		            System.out.printf("Swap (j = %d, j+1 = %d): " + Arrays.toString(numbers) + "\n", j, (j + 1));
		         }
		        
		      }
		      
		     System.out.println("End of Iteration (i = " + i + ") " + Arrays.toString(numbers));

			 System.out.println("\n\n");
		   }
		}



public static void main(String[] args) {

	int[] numbers = { 87, 93, 68, 55, 49, 42, 30, 11 };

	System.out.println("Before Sort: " + Arrays.toString(numbers));

	System.out.println("\n\n");

	BubbleSort(numbers);

	System.out.println("After Sort: " + Arrays.toString(numbers));
}
}
