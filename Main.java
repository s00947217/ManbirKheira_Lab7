// Lab 7 - Graph Implementation
// Name: Manbir S Kheira

public class Main {
  public static void main(String[] args) {
      // Step 1: Define the vertices
      String[] vertices = {
          "Liberal Arts", 
          "Student Services", 
          "Health Careers & Sciences", 
          "Health Technologies Center", 
          "Recreation Center", 
          "Technology Learning Center", 
          "Business & Technology", 
          "Theatre"
      };

      // Step 2: Define the edges based on the campus map
      int[][] edges = {
          {0, 1}, // Liberal Arts -> Student Services
          {1, 2}, // Student Services -> Health Careers & Sciences
          {1, 5}, // Student Services -> Technology Learning Center
          {2, 3}, // Health Careers & Sciences -> Health Technologies Center
          {3, 4}, // Health Technologies Center -> Recreation Center
          {5, 6}, // Technology Learning Center -> Business & Technology
          {6, 7}, // Business & Technology -> Theatre
          {7, 0}  // Theatre -> Liberal Arts
      };

      // Step 3: Create the graph
      Graph<String> graph = new UnweightedGraph<>(vertices, edges);

      // Step 4: Perform DFS starting from "Business & Technology"
      UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology"));

      // Step 5: Display the DFS order
      java.util.List<Integer> searchOrders = dfs.getSearchOrder();
      System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
      for (int i = 0; i < searchOrders.size(); i++) {
          System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
      }
      System.out.println();

      // Step 6: Display parent-child relationships
      for (int i = 0; i < searchOrders.size(); i++) {
          if (dfs.getParent(i) != -1) {
              System.out.println("Parent of " + graph.getVertex(i) +
                  " is " + graph.getVertex(dfs.getParent(i)));
          }
      }

      // Step 7: Display paths from "Business & Technology" to specific locations
      System.out.println();
      dfs.printPath(graph.getIndex("Health Technologies Center"));
      System.out.println();
      dfs.printPath(graph.getIndex("Student Services"));
      System.out.println();
      dfs.printPath(graph.getIndex("Recreation Center"));
      System.out.println();

      // Step 8: Display the entire DFS tree
      dfs.printTree();
  }
}
