// Binary Search: Searching algorithm that efficiently searches for the target element in a sorted array. Suitable only for sorted arrays
// To perform binary search on an unsorted array, first the array needs to be sorted and then the binary search is performed
/* Find the rules below for Binary Search,
    1. left = first index, right = last index
    2. mid = left + (right-left)/2
    3. If array[mid] = target, then target is found in the middle of an array
    4. If array[mid] < target, then traverse the right half to find the target
    5. If array[mid] > target, then traverse the left half to find the target
*/

public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2; // Finding the mid element
        if (array[mid] == target) { // Target found at mid element
          return mid; // Returning the target element after found
        }
        if (array[mid] < target) {
          left = mid + 1; // Traverse the right half for target
        } else {
          right = mid - 1; // Traverse the left half for target
        }
    }
    return -1; // Returning -1 if not found
}

// Time Complexity: O(logn)
// Space Complexity: O(1)

/* Dry run yourself
    array=[-3,-2,-1,0,1,2,3,4,5,6,7,8,9], target=4
*/
