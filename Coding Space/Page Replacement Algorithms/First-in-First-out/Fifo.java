// Following is the Java program for FIFO
/* Simple problem to explain how FIFO works

  Consider {1,3,0,3,5,6,3} with frame size as 3
  Adding 1 to the Queue : Queue ( , , 1) : 1 Page Fault
  Adding 3 to the Queue : Queue ( , 3, 1) : 2 Page Faults
  Adding 0 to the Queue : Queue (0, 3, 1) : 3 Page Faults
  Adding 3 to the Queue : Queue (0, 3, 1) : No page Fault
  Adding 5 to the Queue : Queue (0, 3, 5) : 4 Page Faults
  Adding 6 to the Queue : Queue (0, 6, 5) : 5 Page Faults
  Adding 3 to the Queue : Queue (3, 6, 5) : 6 Page Faults

  Total page faults: 6
*/

public class FIFO {
  public static int pageFaults(int[] page, int frameSize) {
    // Queue to represent the frames in memory
    Queue<Integer> queue = new LinkedList<>();
    int pageFaults = 0; // Page faults initialized to 0 and incremented by 1 everytime a page fault occurs 

      for (int page : page) {
          // If the page is not in the queue
          if (!queue.contains(page)) {
             pageFaults++; // Increment page fault by 1

             // If the queue is full, remove the oldest page
             if (queue.size() == frameSize) {
                queue.poll();
             }

             // Replace the oldest page with the new page
             queue.add(page);
          }
       }
    
      return pageFaults; // Returns number of page faults
    }
}

/* Dry run yourself
    {1,2,3,4,1,2,5,1,2,3,4,5}
    Clue: Total page faults are 9
*/
