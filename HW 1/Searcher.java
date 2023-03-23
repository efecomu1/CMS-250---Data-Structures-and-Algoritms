
public class Searcher {
	
	//linearSearch method declaration with 2 given inputs
	public static int linearSearch(int[]array, int x) {
		
		//for loop to iterate through the elements of the array until the find the target value
		for (int i = 0; i < array.length; i++) {
	         if (array[i] == x) {
	            return i;
	         }
	      }
		//return -1 if the target value is not found
		return -1;
	}
	//binarySearch method declaration with 2 given inputs
	public static int binarySearch(int[]array, int x) {
		
		//declare low, mid, and high indices with the first, middle, and last elements of the array
		int low_index = 0;
	    int mid_index = array.length / 2;
	    int high_index = array.length - 1;
	    
	    //while loop that iterates until high index is less than the low index
	    while (high_index >= low_index) {
	         // calculate the middle index
	         mid_index = (high_index + low_index) / 2;

	         // Cut the range to either the left or right half, unless we get to the mid index 
	         if (array[mid_index] < x) {
	            low_index = mid_index + 1;
	         }
	         else if (array[mid_index] > x) {
	            high_index = mid_index - 1;
	         }
	         else {
	            return mid_index;
	         }
	      }
	    //return -1 if the target value is not found
		return -1;
	}
	//linearSearchCount method declaration with 2 given inputs
	public static int linearSearchCount(int[]array, int x) {
		
		//initialize the count variable to keep track of the number of iterations
		int count = 0;
		
		//for loop to count the iterations until the target value is found
		for (int i = 0; i < array.length; i++) {
			
			count++;
	        
			if (array[i] == x) {
	            return count;
	         }
	      }
		return count;
	}
	//binarySearchCount method declaration with 2 given inputs
	public static int binarySearchCount(int[]array, int x) {
		
		int count = 0;
		
		int low_index = 0;
	    int mid_index = array.length / 2;
	    int high_index = array.length - 1;
	    
	    while (high_index >= low_index) {
	    	
	    	//increment the count variable by one in every iteration
	    	count++;
	        
	        mid_index = (high_index + low_index) / 2;

	        
	        if (array[mid_index] < x) {
	           low_index = mid_index + 1;
	        }
	        else if (array[mid_index] > x) {
	           high_index = mid_index - 1;
	        }
	        else {
	        	 return count;
            }
	           
	    }
		return count;
	    
	}
	
	public static void main(String[] args) {
		
		//declare the first array with size 10
		int[]numbers1 = new int[10];
		
		//assign the multiples of 6 to the elements of the first array
		for(int i = 0; i < numbers1.length; i++) {
			numbers1[i] = 6 * i;
			}
		//declare the second array with size 1000
		int[]numbers2 = new int[1000];
		
		//assign the consecutive numbers starting from 3 to the elements of the second array
		for(int j = 0; j < numbers2.length; j++) {
			numbers2[j] = j + 3;
		}
		int x; 
		
		//for loop to iterate through all 4 methods
		for (int i = 0; i < 4; i ++) {
			int[] array;
			
			//assign the first array and 2 values accordingly if it's the first or the second iteration
			if (i == 0 || i == 1) {
				array = numbers1;
				if (i == 0) {
					x = 0;
				}
				else {
					x = 41;
				}
				
			}
			//assign the second array and 2 values accordingly if it's the third or the fourth iteration
			else {
				array = numbers2;
				if (i == 2) {
					x = 445;
				}
				else {
					x = 1903;
				}
				
			}
			//check if the value is found or not found in the array, print out the result and the number of comparisons it took using linear search
			if (linearSearch(array, x) == -1) {
				System.out.printf("linearSearch did not find %d, index = %d.\n\n", x, linearSearch(array, x));
			}
			else {

				System.out.printf("linearSearch found value %d at index %d.\n\n", x, linearSearch(array, x));
			}
			
			System.out.printf("linearSearchCount performed %d comparisons.\n\n", linearSearchCount(array, x));
			
			//check if the value is found or not found in the array, print out the result and the number of comparisons it took using binary search
			if (binarySearch(array, x) == -1) {
				System.out.printf("binarySearch did not find %d, index = %d.\n\n", x, binarySearch(array, x));
			}
			else {

				System.out.printf("binarySearch found value %d at index %d.\n\n", x, binarySearch(array, x));
			}
			
			System.out.printf("binarySearchCount performed %d comparisons.\n\n", binarySearchCount(array, x));


		}
	}
}
