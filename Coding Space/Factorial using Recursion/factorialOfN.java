// Factorial: Factorial is a mathematical function that multiplies a number with all it's subsequent numbers in the decreasing order
// Factorial is denoted by !
// Ex: 5! = 5 x 4 x 3 x 2 x 1 = 120
// By default, 0! and 1! gives 1

// Here, factorial problem is solved using recursion
// Recursion: A function calling itself

public static long factorial(int n) {
  if (n == 0 || n == 1) { // indicates 0! and 1! i.e., equal to 1
    return 1; // Returns 1 if n = 0 or 1 
  }
  return n * factorial(n - 1); // Here, factorial() is calling itself, ensuring Recursion
}

// Time Complexity: O(n)
// Space Complexity: O(n)

/* Dry run yourself
    n = 7
  */
