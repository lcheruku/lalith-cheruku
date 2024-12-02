// Selection Sort: A comparison based algorithm where smallest element in an unsorted portion is replaced with the first element
// The smallest element is in correct position now. The process continues to second and its subsequent smallest elements
// Inefficient for larger data sets due to bigger time complexity
/*
  Ex: array[3,2,6,1,5]
        Iteration 1: [1,2,6,3,5] 3 is swapped with 1
        Iteration 2: [1,2,6,3,5] 2 is already sorted 
        Iteration 3: [1,2,3,6,5] 6 is swapped with 3
        Iteration 4: [1,2,3,6,5] 6 is swapped with 5
        Sorted array: [1,2,3,5,6]
*/
public static void selectionSort(int[] array) {

    for (int i = 0; i < array.length - 1; i++) {
      // Finding the index of the minimum element in the unsorted portion
      int minIndex = i;
      
      for (int j = i + 1; j < array.length; j++) {
          if (array[j] < array[minIndex]) {
            minIndex = j;
          }
      }
      // Swapping the found minimum element with the first element of the unsorted portion
      int temp = array[minIndex];
      array[minIndex] = array[i];
      array[i] = temp;
    }
}

// Time complexity: O(n^2)
// Space complexity: O(1)

/* Dry run yourself
    array = [23,2,4,7,56]
*/
