// Linear Search: Searching algorithm that sequentially traverses an array of elements to find the given target element
// Output will be the index of the target element in that array

/* Ex: array = [1,2,3,4,5], target = 4
    1) array[0] = target (False)
    2) array[1] = target (False)
    3) array[2] = target (False)
    4) array[3] = target (True)
  Hence, output is 3
*/

public static int linearSearch(int[] array, int target) {
 for (int i = 0; i < array.length; i++) { // Iterating through the array
    if (array[i] == target) { // Comparing each element from the array with the target
          return i; // Returns the index of the target if found
    }
 }
 return -1; // Return -1 if not found
}

/* Time Complexity: O(n)
    Best Case: O(1)
    Average Case: O(n)
    Worst Case: O(n)
*/
// Space Complexity: O(1)

/* Dry run yourself
    array[] = {1,2,4,6,3,2,5,10,11}, target = 5
*/
