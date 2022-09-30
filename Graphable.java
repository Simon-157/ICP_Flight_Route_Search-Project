import java.util.*;
public interface Graphable {
    // vertex-related methods
    public void addVertex(Vertex v);
    public boolean containsVertex(Vertex v);
    public Collection<Vertex> neighbors(Vertex v);
    public Collection<Vertex> vertices();

    // edge-related methods
    public void addEdge(Vertex srcVertex, Vertex destVertex, Edge route);
    public void addEdge(Vertex srcVertex, Vertex destVertex, Edge route, double weight);
    public boolean containsEdge(Vertex v1, Vertex v2);
    public Edge edge(Vertex v1, Vertex v2);
    public Collection<Edge> edges();
    public int edgeWeight(Vertex v1, Vertex v2);

}
