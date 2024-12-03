// Lab 7 - Graph Implementation
// Name: Manbir S Kheira

public class Edge {
  int u; // Starting vertex
  int v; // Ending vertex

  // Constructor to initialize an edge
  public Edge(int u, int v) {
      this.u = u;
      this.v = v;
  }

  @Override // Test if two edges are identical
  public boolean equals(Object o) {
      if (!(o instanceof Edge)) return false;
      Edge edge = (Edge) o;
      return u == edge.u && v == edge.v;
  }
}
