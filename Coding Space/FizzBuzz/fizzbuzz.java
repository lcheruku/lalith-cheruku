/* FizzBuzz: FizzBuzz is a programming challenge that takes a positive non-zero integer, iterates the integer and applies following rules,
  
    1. For multiples of 3, print "Fizz"
    2. For multiples of 5, print "Buzz"
    3. For multiples of both 3 and 5, print "FizzBuzz"
    4. Prints the number if neither multiple of 3 nor multiple of 5

*/

// Ex: n = 3, 
/* Output: 
    1
    2
    Fizz
*/

public static void fizzBuzz(int n) {
  for (int i = 1; i <= n; i++) {  // Iterates given number n
    if (i % 3 == 0 && i % 5 == 0) { // Printing FizzBuzz if i is multiple of both 3 and 5
      System.out.println("FizzBuzz");
    } else if (i % 3 == 0) { // Printing Fizz if i is multiple of 3
      System.out.println("Fizz");
      } else if (i % 5 == 0) { // Printing Buzz if i is multiple of 5
        System.out.println("Buzz");
        } else { // Prints i if neither multiple of 3 nor multiple of 5
          System.out.println(i);
          }
  }

}

// Time Complexity: O(n)
// Space Complexity: O(1)

/* Dry run yourself
  n = 10
*/
