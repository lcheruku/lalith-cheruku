// Following code is logic palindrome problem
// A string is called a palindrome if a word is spelled same when it is reversed. Ex: Radar, Level, Madam, Racecar etc. 
// Here, 2 solutions are provided for this problem

---------------------------------------------------

// 1. 1st solution involves iterating 
public static boolean isPalindrome(String str) {
  for (int i = 0; i < str.length()/ 2; i++) {
    // Compares starting character with ending character 
    // Starting char is incremented and Ending char is decremented subsequently upon further iterations until the "if" condition evaluates to true 
    if (str.charAt(i) != str.charAt(str.length() - i - 1)) {  
      return false; // Returns false if str is not a palindrome
    }
  }
  return true; // Returns true if str is a valid palindrome
}

// Time Complexity: O(n)
// Space Complexity: O(1)

______________________________________________________________________________________________________________________________________________________

// 2. 2nd solutions involves using a StringBuilder object and reverse() utility method
public static boolean isPalindrome(String str) {
  StringBuilder sb = new StringBuilder(str).reverse().toString();
  return str.equals(sb); // Returns true if current string is equal to the reversed string
}

// Time Complexity: O(n)
// Space Complexity: O(n)
