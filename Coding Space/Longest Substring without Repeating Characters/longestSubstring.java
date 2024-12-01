// Given a String s, find the length oflongest substring without the occurence of a repeated character
// Ex: "abcabcbb"
// Longest substring without repeated character is abc. Hence, the answer is 3 
// Here, the problem is solved using Sliding Window technique
// Sliding Window: It is an algorithm where a range is defined, operation is performed on that range and is further moved across the array
/* Ex: array = [1,2,3,4,5,6]
    
    left = 0, right = 2
    1st range: [1,2,3], left++ & right++

    left = 1, right = 3
    2nd range: [2,3,4], left++ & right++

    left = 2, right = 4
    3rd range: [3,4,5], left++ & right++

    left = 3, right = 5
    last range: [4,5,6], left++ & right++
    
*/

public static int lengthOfLongestSubstring(String str) {
  int longestSubstring = 0;
  int left = 0; // Sliding window starting from 0
  HashSet<Character> set = new HashSet<>(); // Using HashSet for caching

  for (int right = 0; right < str.length(); right++) {
    
    while (set.contains(str.charAt(right))) {
      set.remove(str.charAt(left)); // Removing repeated character from the set
      left++;
    }
    
    set.add(str.charAt(right)); // Adding the current character to the set, if unique
    
    maxLength = Math.max(longestSubstring, right - left + 1); // Updating the length of longest substring without repeated characters
  }
  return longestSubstring;
}

// Time Complexity: O(n)
// Space Complexity: O(k)

/* Dry run yourself
    str = "pwwkew"
*/
