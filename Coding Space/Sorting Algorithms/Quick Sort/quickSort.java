// Quick sort: Highly efficient algorithm that works for larger data sets. Implements Divide and Conquer
// Here, a pivot element is chosen and the array is divided between elements less than pivot and elements greater than pivot
// Choice of pivot can be first element, last element, any random element, or median
// Time complexity varies depending on choice of pivot
// This program chooses last element as pivot element
/* 
  Ex: array = [1,2,5,9,7]
        pivot = 7
        Left array = [1,2,5] -> sorted
        Right array = [9] -> sorted
        Sorted array: [1,2,5,7,9]
*/

public static void quickSort(int[] array, int low, int high) {
    if (low < high) {
    // Partitioning the array to get the pivot index
    int pivotIndex = partition(array, low, high);

    // Recursively sorting the left and right subarrays
    quickSort(array, low, pivotIndex - 1);
    quickSort(array, pivotIndex + 1, high);
   }

public static int partition(int[] array, int low, int high) {
    int pivot = array[high]; // Choosing the last element as the pivot
    int i = low - 1; // Index for smaller element

    for (int j = low; j < high; j++) {
        // If current element is less than or equal to the pivot
        if (array[j] <= pivot) {
          i++;
          // Swap array[i] and array[j]
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
    }
  
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    return i + 1; // Return the pivot index
}

// Time complexity: Best - O(nlogn), Worst - O(n^2)
// Space Complexity: Auxilary O(n)

/* Dry run yourself
    array = [10,80,30,90,40]
*/
