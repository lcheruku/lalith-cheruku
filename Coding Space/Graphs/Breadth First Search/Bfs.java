// Breadth First Search(BFS): BFS is a graph traversal algorithm that finds the shortest path in an uweighted graph
// It uses a Queue and a Visited Set for traversal
/*
  Ex: 
      0
    /   \
   1     2
   |     |
   3     4

Path: 0,1,2,3,4
*/

public static void bfs(Map<Integer, List<Integer>> graph, int vertex) {
      
        Queue<Integer> queue = new LinkedList<>(); // creating a queue 
        Set<Integer> visited = new HashSet<>(); // visited to keep track of visited nodes

        queue.add(vertex); // add the vertex
        visited.add(vertex); // mark as visited

        while (!queue.isEmpty()) {
          // Removing vertex from the queue  
          int currentNode = queue.poll();

          // Get all neighbours of vertex
          List<Integer> neighbors = graph.getOrDefault(currentNode, new ArrayList<>());

          for (int neighbor : neighbors) {
              // If neighbor is not visited, add it to the queue first  
              if (!visited.contains(neighbor)) {
                  queue.add(neighbor);
                  visited.add(neighbor);
              }
          }
        }
    
}

// Time complexity: O(V + E)
// Space complexity: O(V)

/* Dry run yourself
    use the above test case
*/
