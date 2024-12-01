// Following code is logic for reversing a string
// Here, 2 solutions are provided for this problem

---------------------------------------------------

// 1. 1st solution involves iterating the given string in a reverse order and printing each character in a new string
public static String reverseString(String str) {
  String reversedString = "";
  for(int i = str.length-1; i >= 0; i--) {
    reversedString += str.charAt(i);
  }
  return reversedString;
}

// Time Complexity: O(n)
// Space Complexity: O(n^2)
// Bug: String concatenations result in creating multiple string objects everytime a character is concatenated, since String is immutable

______________________________________________________________________________________________________________________________________________________

// 2. 2nd solutions involves using a StringBuilder object to avoid creating multiple unwanted string objects
public static String reverseString(String str) {
  StringBuilder sb = new StringBuilder(str);
  return sb.reverse().toString();
}

// Time Complexity: O(n)
// Space Complexity: O(n)

------------------------------------------------------

/* Dry run yourself
  str = "Hello World"  
*/
