// TwoSum - Given an array and an integer target, return the indices of the two numbers that add up to target
// I can use two for-loops to traverse the array twice, take two numbers from each for-loop, and add them to reach target
// This approach brings the runtime complexity to O(n^2) which is additional overhead
// To reduce the burden, I would use a caching strategy called HashMap
// I would need only a single for-loop to store the numbers and their indices in a HashMap in the form of Key-Value pairs
// Then, I would substract first element in the HashMap from the target and store it in an integer complement
// If I find complement equal to any one from the remaining elements, I would return their Keys i.e., indices
// If I do not find, I would store the first element and its index in the Mapcontinue substracting subsequent second, third elements and so on
// If two indices leading up to target are not found, I would return -1 to indicate "Solution not found"
// Thus code doesn't mention main method. However, you can assume having a main method

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Creating a HashMap for caching
        Map<Integer, Integer> numMap = new HashMap<>();
        
        // Iterating through nums[]
        for (int i = 0; i < nums.length; i++) {
            // Finding the complement
            int complement = target - nums[i];
            
            // Checking for complement in the map
            if (numMap.containsKey(complement)) {
                // returning the indices if complement is found
                return new int[] { numMap.get(complement), i };
            }
            
            // storing the element and its index if complement is not found
            numMap.put(nums[i], i);
        }
        
        // Solution not found. I can also throw an IllegalArgumentException
        return -1;
    }

}

// Time Complexity: O(n)
// Space Complexity: O(n)

/* Dry run yourself 
    nums[] = {2, 7, 11, 15}
    target = 9
  */
