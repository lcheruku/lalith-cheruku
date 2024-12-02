// Merge sort: Divide and conquer paradigm where each array is divided into individual subarrays and merged in a sorted manner
// Best time complexity assured
/*
    Ex: [38,27,43,10]
        1st division: [38,27],[43,10]
        2nd division: [38],[27],[43],[10]

        1st merge: [27,38],[10,43]
        2nd merge: [10,27,38,43]
*/

public static void mergeSort(int[] array, int left, int right) {
  if (left < right) {
            
    int mid = left + (right - left) / 2;
  
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
  
    merge(array, left, mid, right);
  }
}

public static void merge(int[] array, int left, int mid, int right) {
  int num1 = mid - left + 1;
  int num2 = right - mid;

  int[] leftSubrray = new int[num1];
  int[] rightSubarray = new int[num2];

  for (int i = 0; i < num1; i++)
    leftSubarray[i] = array[left + i];
  for (int j = 0; j < num2; j++)
    rightSubarray[j] = array[mid + 1 + j];

  int i = 0, j = 0;
  int k = left;

  while (i < num1 && j < num2) {
    if (leftSubarray[i] <= rightSubarray[j]) {
      array[k] = leftSubarray[i];
      i++;
    } else {
        array[k] = rightSubarray[j];
        j++;
      }
      k++;
    }

    while (i < num1) {
      array[k] = leftSubarray[i];
      i++;
      k++;
    }

    while (j < num2) {
      array[k] = rightSubarray[j];
      j++;
      k++;
    }
}

// Time complexity: O(nlogn)
// Space complexity: O(n + logn) with O(n) being auxilary

/* Dry run yourself
    [12, 11, 13, 5, 6, 7]
*/
