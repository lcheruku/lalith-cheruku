// Following is the Java program for Optimal Page Replacement
/* Simple problem to explain how MRU works

  Consider {7,0,1,2,0,3,0,4,2,3,0,3,2,3} with frame size as 4
  Adding 7 to the List : List ( , , , 7) : 1 Page Fault
  Adding 0 to the List : List ( , , 0, 7) : 2 Page Faults
  Adding 1 to the List : List ( , 1, 0, 7) : 3 Page Faults
  Adding 2 to the List : List (2, 1, 0, 7) : 4 Page Faults
  Adding 0 to the List : List (2, 1, 0, 7) : No Page Fault
  Adding 3 to the List : List (2, 1, 0, 3) : 5 Page Faults
  Adding 0 to the List : List (2, 1, 0, 3) : No Page Fault
  Adding 4 to the List : List (2, 4, 0, 3) : 6 Page Faults
  Adding 2 to the List : List (2, 4, 0, 3) : No Page Fault
  Adding 3 to the List : List (2, 4, 0, 3) : No Page Fault
  Adding 0 to the List : List (2, 4, 0, 3) : No Page Fault
  Adding 3 to the List : List (2, 4, 0, 3) : No Page Fault
  Adding 2 to the List : List (2, 4, 0, 3) : No Page Fault
  Adding 3 to the List : List (2, 4, 0, 3) : No Page Fault

  Total page faults: 6
*/

public class MRU {
  public static int pageFaults(int[] page, int frameSize) {
    // Stack to represent the frames in memory
    Stack<Integer> stack = new Stack<>();
    int pageFaults = 0; // Page faults initialized to 0 and incremented by 1 everytime a page fault occurs 

      for (int page : page) {
          // If the page is not in the stack
          if (!stack.contains(page)) {
             pageFaults++; // Increment page fault by 1

             // If the stack is full, remove the most recently used page
             if (stack.size() == frameSize) {
                stack.pop(page);
              }
          } else {
              // If the page is already in the stack, remove it to be readded again as recently used page
              stack.removeElement(page);
          }
        // Adding the page to the stack
        stack.push(page);
       }
    
      return pageFaults; // Returns number of page faults
    }
}

/* Dry run yourself
    {1,2,3,4,1,2,5,1,2,3,4,5}, Frame size = 3
    Clue: Total page faults are 7
*/
