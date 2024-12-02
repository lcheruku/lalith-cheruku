// Depth First Search(DFS): Graph Traversal algorithm that traverses closest vertices one by one instead of neighbors in BFS. 
// Unlike in BFS where we use Queue, we use Stack for DFS
/*
  Ex: 
      0
    /   \
   1     2
   |     |
   3     4

Path: 0,1,3,2,4
*/

public static void dfs(Map<Integer, List<Integer>> graph, int vertex) {
        
        Stack<Integer> stack = new Stack<>(); // Creating a stack
        // Set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>(); // Visited to keep track of visited nodes

        stack.push(vertex); // Push the vertex into stack

        while (!stack.isEmpty()) {
          int currentNode = stack.pop();
          // If the node hasn't been visited
          if (!visited.contains(currentNode)) {
              visited.add(currentNode);
              // Pushing all unvisited neighbors onto the stack
              for (int neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                  if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                  }
              }
          }
        }
    
}

// Time complexity: O(V + E)
// Space complexity: O(V)

/* Dry run yourself
    use above test case
*/
