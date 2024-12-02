// Insertion sort: A simple sorting technique where the second element in the array is the key and compared with its predecessor for sorting
// This process of exchanging keys and comparisons with predecessors continues until the array is sorted
// Here, the first element in the array is not key because of an assumption that it is already sorted
// Not suitable for larger data sets because of its time complexity
/* Ex: Consider array = [2,7,1,5,4]
          key = array[2] = 7
          7 > 2, array = [2,7,1,5,4]
          key = array[3] = 1
          1 < 7 & 1 < 2, array = [1,2,7,5,4]
          key = array[4] = 5
          5 < 7, array = [1,2,5,7,4]
          key = array[5] = 4
          4 < 7 & 4 < 5, array = [1,2,4,5,7] -> sorted
*/  

public static void insertionSort(int[] array) {

  for (int i = 1; i < array.length; i++) {
      int key = array[i]; // array[1] is inserted in key for first iteration
      int j = i - 1; // j = 0 in first iteration

      while (j >= 0 && array[j] > key) { // In first iteration, if j >= 0 & array[0] > key
         array[j + 1] = array[j]; // array[0] value is assigned to array[1] value
         j--; // j value will be -1
      }
      array[j + 1] = key; // Inserting key into array[0]
  }
}

// Time complexity: O(n^2)
// Space complexity: O(1)

/* Dry run yourself
    array = [3,6,31,5,7,42,1,146,9]
*/
