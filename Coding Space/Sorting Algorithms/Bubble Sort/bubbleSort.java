// Bubble sort: A simplest sorting algorithm that works by swapping adjacent elements one by one until the array is sorted
// Bubble sort is generally used for small data sets because it is inefficient for large data sets due to its time complexity
// If the left element is greater than the right element, their places are swapped. Else, they remain same
/* Ex: [5,1,4,8]
    Pass 1: 
      5 > 1, [1,5,4,8] -> Swapped
      5 > 4, [1,4,5,8] -> Swapped
      5 < 8, [1,4,5,8] -> Not swapped
    Now, the arrau is sorted
*/

public static void bubbleSort(int array[]){
  int temp;
  boolean swap;

  // Consider first iteration in the above test case i.e., [5,1,4,8]
  for (i = 0; i < array.length - 1; i++) {
    
    swap = false; // swap is initialized to false
    
    for (j = 0; j < array.length - i - 1; j++) {
      if (array[j] > array[j + 1]) { // Comparison between array[j] and it's adjacent element array[j+1] i.e., 5 > 1(T) 
        temp = array[j]; // If greater, current value is assigned to temp i.e., temp = 5
        array[j] = array[j + 1]; // swapping happens, lowest value adjacent to current value is assigned to array[j] i.e., array[j] = 1
        array[j + 1] = temp; // temp is assigned as next element i.e., array[j+1] = 5
        swap = true; // swap returns true, the process continues
      }
    }
    
     if (swap == false) { // If the array is sorted completely, swap returns false and breaks out of for loop
       break;
     }
    
  }
}

// Time complexity: O(n^2)
// Space complexity: O(1)

/* Dry run yourself
    array = [2,5,3,9,21,19,11,8,4]
*/
