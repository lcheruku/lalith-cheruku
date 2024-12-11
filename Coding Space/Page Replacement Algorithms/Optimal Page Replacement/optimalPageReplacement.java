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
  public static int optimalPageReplacement(int capacity, int[] page) {
        List<Integer> list = new ArrayList<>(capacity);
        int pageFaults = 0;

        for (int i = 0; i < page.length; i++) {
            int page = page[i];

            boolean isPageInFrame = lost.contains(page);
            if (!isPageInFrame) {
                if (list.size() < capacity) {
                    list.add(page);
                } else {
                    
                    int farthestDistance = i;
                    int farthestPage = -1;

                    for (int frame : list) {
                        int nextUsage = -1;
                        for (int j = i + 1; j < page.length; j++) {
                            if (page[j] == frame) {
                                nextUsage = j;
                                break;
                            }
                        }

                        if (nextUsage == -1) {
                            farthestPage = frame;
                            break;
                        }

                        if (nextUsage > farthestDistance) {
                            farthestDistance = nextUsage;
                            farthestPage = frame;
                        }
                    }

                    list.set(list.indexOf(farthestPage), page);
                }
                pageFaults++;
            }

        }

        return pageFaults;
    }
}

/* Dry run yourself
    {1,2,3,4,1,2,5,1,2,3,4,5}, Frame size = 3
    Clue: Total page faults are 8
*/
