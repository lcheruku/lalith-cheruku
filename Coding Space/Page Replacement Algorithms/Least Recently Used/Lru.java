// Following is the Java program for LRU
/* Simple problem to explain how LRU works

  Consider {7,0,1,2,0,3,0,4,2,3,0,3,2,3} with frame size as 4
  Adding 7 to the Set : Set ( , , , 7) : 1 Page Fault
  Adding 0 to the Set : Set ( , , 0, 7) : 2 Page Faults
  Adding 1 to the Set : Set ( , 1, 0, 7) : 3 Page Faults
  Adding 2 to the Set : Set (2, 1, 0, 7) : 4 Page Faults
  Adding 0 to the Set : Set (2, 1, 0, 7) : No Page Fault
  Adding 3 to the Set : Set (2, 1, 0, 3) : 5 Page Faults
  Adding 0 to the Set : Set (2, 1, 0, 3) : No Page Fault
  Adding 4 to the Set : Set (2, 4, 0, 3) : 6 Page Faults
  Adding 2 to the Set : Set (2, 4, 0, 3) : No Page Fault
  Adding 3 to the Set : Set (2, 4, 0, 3) : No Page Fault
  Adding 0 to the Set : Set (2, 4, 0, 3) : No Page Fault
  Adding 3 to the Set : Set (2, 4, 0, 3) : No Page Fault
  Adding 2 to the Set : Set (2, 4, 0, 3) : No Page Fault
  Adding 3 to the Set : Set (2, 4, 0, 3) : No Page Fault

  Total page faults: 6
*/

public class LRU {
  public static int pageFaults(int[] page, int frameSize) {
    // Stack to represent the frames in memory
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    int pageFaults = 0; // Page faults initialized to 0 and incremented by 1 everytime a page fault occurs 

      for (int page : page) {
          // If the page is not in the set
          if (!set.contains(page)) {
             pageFaults++; // Increment page fault by 1

             // If the set is full, remove the least recently used page
             if (set.size() == frameSize) {
                Iterator<Integer> iterator = frameSet.iterator();
                    if (iterator.hasNext()) {
                        iterator.next();
                        iterator.remove();
                    }
              }
          } else {
              // If the page is already in the set, remove it to be readded again as recently used page
              set.remove(page);
          }
        // Adding the page to the set
        set.add(page);
       }
    
      return pageFaults; // Returns number of page faults
    }
}

/* Dry run yourself
    {1,2,3,4,1,2,5,1,2,3,4,5}, Frame size = 3
    Clue: Total page faults are 9
*/
