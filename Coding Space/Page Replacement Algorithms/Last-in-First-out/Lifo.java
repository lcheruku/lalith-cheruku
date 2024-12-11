// Following is the Java program for LIFO
/* Simple problem to explain how LIFO works

  Consider {3,1,2,1,5,4,1,3} with frame size as 3
  Adding 3 to the Stack : Stack ( , , 3) : 1 Page Fault
  Adding 1 to the Stack : Stack ( , 1, 3) : 2 Page Faults
  Adding 2 to the Stack : Stack (2, 1, 3) : 3 Page Faults
  Adding 1 to the Stack : Stack (2, 1, 3) : No page Fault
  Adding 5 to the Stack : Stack (5, 1, 3) : 4 Page Faults
  Adding 4 to the Stack : Stack (4, 1, 3) : 5 Page Faults
  Adding 1 to the Stack : Stack (4, 1, 3) : No Page Fault
  Adding 3 to the Stack : Stack (4, 1, 3) : No Page Faults

  Total page faults: 5
*/

public class LIFO {
  public static int pageFaults(int[] page, int frameSize) {
    // Stack to represent the frames in memory
    Stack<Integer> stack = new Stack<>();
    int pageFaults = 0; // Page faults initialized to 0 and incremented by 1 everytime a page fault occurs 

      for (int page : page) {
          // If the page is not in the queue
          if (!stack.contains(page)) {
             pageFaults++; // Increment page fault by 1

             // If the queue is full, remove the newest page
             if (stack.size() == frameSize) {
                stack.pop();
             }

             // Replace the newest page 
             stack.push(page);
          }
       }
    
      return pageFaults; // Returns number of page faults
    }
}

/* Dry run yourself
    {1,2,3,4,1,2,5,1,2,3,4,5}, Frame size = 3
    Clue: Total page faults are 12
*/
