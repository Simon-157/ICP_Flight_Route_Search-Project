import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RouteGraph implements Graphable {

    public static final int DEFAULT_EDGE_WEIGHT = 1;
    public static final int MAX_DISTANCE = Integer.MAX_VALUE;

    protected final Map<Vertex, Map<Vertex, Edge>> adjacencyMap;
    protected final Map<Airport, Vertex> vertexInfo;
    protected final List<Edge> edgeList;

    public RouteGraph() {
        this.adjacencyMap = new HashMap<Vertex, Map<Vertex, Edge>>();
        this.vertexInfo = new HashMap<Airport, Vertex>();
        this.edgeList = new ArrayList<Edge>();
    }

    public final Collection<Edge> edges() {
        return Collections.unmodifiableList(this.edgeList);
    }

    public String toString() {
        String result = "Graph {\n";
        for (Vertex v : this.vertices()) {
            result += "  vertex: " + this.vertexInfo.get((Vertex)v) + " -> " + this.neighbors(v) + "\n";
        }
        result += "  edges: " + this.edges() + "\n";
        result += "}";
        return result;
    }

    public final Set<Vertex> vertices() {
        return Collections.unmodifiableSet(this.adjacencyMap.keySet());
    }

    protected void checkForNull(Object arg) {
        if (arg == null) {
            throw new NullPointerException("Argument must not be null");
        }
    }

    protected void checkVertex(Vertex v) {
        this.checkForNull(v);
        if (!this.containsVertex(v)) {
            throw new IllegalArgumentException("Vertex not found in graph: " + v);
        }
    }

    protected void checkVertices(Vertex v1, Vertex v2) {
        this.checkForNull(v1);
        this.checkForNull(v2);
        if (!this.containsVertex(v1)) {
            throw new IllegalArgumentException("Vertex not found in graph: " + v1);
        }
        if (!this.containsVertex(v2)) {
            throw new IllegalArgumentException("Vertex not found in graph: " + v2);
        }
    }

    protected void clearVertexInfo() {
        for (Vertex info : this.vertexInfo.values()) {
            info.clear();
        }
    }

    @Override
    public void addVertex(Vertex v) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean containsVertex(Vertex v) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Collection<Vertex> neighbors(Vertex v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addEdge(Vertex srcVertex, Vertex destVertex, Edge route) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addEdge(Vertex srcVertex, Vertex destVertex, Edge route, double weight) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean containsEdge(Vertex v1, Vertex v2) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Edge edge(Vertex v1, Vertex v2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int edgeWeight(Vertex v1, Vertex v2) {
        // TODO Auto-generated method stub
        return 0;
    }
}




















// public Vertex breadthFirstSearch() throws IOException {

//     Airport startAirport = getStartEndAirport()[0];
//     Airport endAirport = getStartEndAirport()[1];
//     Vertex node = new Vertex(startAirport, null, null, 0);
//     if (startAirport.getCity().equals(endAirport.getCity())) {
//         System.out.println("Found solution !!");
//         return node;
//     }
//     Queue<Vertex> frontier = new LinkedList<Vertex>();
//     frontier.add(node);
//     // System.out.println("frontier, " + frontier);
//     Set<Vertex> explored = new HashSet<Vertex>();

//     while (!frontier.isEmpty()) {
//         node = frontier.poll();
//         System.out.println("Popped: " + node);
//         explored.add(node);
//         // System.out.println("Explored: " + explored);
//         HashMap<Route, Airport> results = getAirportNeighbors(node.getCurrentVertex());
//         for (Route route : results.keySet()) {
//             // Airport airport = results.get(route);
//             // System.out.println(airport);

//             Vertex neighbor = new Vertex(results.get(route), node, route, node.getDistance());
//             // System.out.println("neighbor: " + neighbor.currentVertex);
//             if (neighbor.getCurrentVertex() == null) {
//                 System.out.println("Sorry there was no route for the given start city and destination city");
//                 // return null;
//             }
//             if (neighbor.getCurrentVertex() != null && !explored.contains(neighbor) && !frontier.contains(neighbor)) {
//                 if (neighbor.getCurrentVertex().getCity().equals(endAirport.getCity())) {
//                     System.out.println("Found solution !!");
//                     neighbor.getPathToDestination();
//                     return neighbor;
//                 }
//                 // System.out.println(frontier);
//                 frontier.add(neighbor);
//             }
//         }
//     }

//     return null;

// }