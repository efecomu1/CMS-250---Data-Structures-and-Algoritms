import java.util.Arrays;

public class Insertion_Sort{
   public static void insertionSort(int[] numbers) {
      for (int i = 1; i < numbers.length; i++) {
    	 System.out.println("Start of Iteration: (i = " + i + ") " + Arrays.toString(numbers));
         int j = i;
         while (j >= 1 && numbers[j] < numbers[j - 1]) {
            
            int temp = numbers[j];
            numbers[j] = numbers[j - 1];
            numbers[j - 1] = temp;
            j--;
            System.out.printf("Shift (j = %d): " + Arrays.toString(numbers) + "\n", j);
            
         }
         System.out.println("End of Iteration (i = " + i + ") " + Arrays.toString(numbers));

		 System.out.println("\n\n");
      }
   }

   public static void main(String[] args) {
      
      int[] numbers = { 93, 87, 68, 55, 49, 42, 30, 11 };
      
      
      System.out.println("Before Sort: " + Arrays.toString(numbers));
      
      
      insertionSort(numbers);
      
      
      System.out.println("After Sort: " + Arrays.toString(numbers));
   }
}
