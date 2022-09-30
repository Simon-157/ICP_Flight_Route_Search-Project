import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Vertex implements Comparable<Vertex> {
    /** The vertex itself. */
    private Airport currentVertex;
    private Vertex previous;
    private Route route;
    private double distance;

    public Vertex(Airport curVertex, Vertex prev, Route route, double distance) throws NullPointerException {
        // if (curVertex == null) {
        // throw new NullPointerException("Argument must not be null");
        // }
        this.currentVertex = curVertex;
        this.previous = prev;
        this.route = route;
        this.distance = distance;
        // this.clear();
    }

    public Vertex(Airport startAirport) {
        this.currentVertex = startAirport;
        this.previous = null;
    }

    public Airport getCurrentVertex() {
        return this.currentVertex;
    }

    public void setCurrentVertex(Airport currentVertex) {
        this.currentVertex = currentVertex;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance() {
        this.distance = this.route.getRoutecost();
    }

    /**
     * This function returns a deque of routes that are the shortest path from the
     * source to the
     * destination
     * 
     * @return A deque of routes.
     */
    public Deque<Route> getPathToDestination() {
        Deque<Route> deque = new LinkedList<>();
        Vertex CurrentVertex = new Vertex(this.currentVertex, this.previous, this.route, this.distance);
        while (CurrentVertex.previous != null) {
            deque.addFirst((CurrentVertex.route));
            CurrentVertex = CurrentVertex.previous;
        }
        deque.addFirst(CurrentVertex.route);
        for (Route route : deque) {
            System.out.println(route);
            System.out.println();
        }
        return deque;
    }

    /**
     * It writes the output of the program to a file
     * 
     * @param inputFileName the name of the file that contains the flight routes
     */
    public void writeOutputPathToFile(String inputFileName) throws IOException {

        String outPutFileName = String.format("C:/Users/simon/Desktop/flight-route-finding/%s_output.txt",
                inputFileName);

        BufferedWriter f_writer = new BufferedWriter(new FileWriter(outPutFileName));

        for (Route route : this.getPathToDestination()) {

            try {
                f_writer.write(route.toString() + "\n");
            } catch (NullPointerException n) {
                n.getMessage();

            } finally {
                System.out.println("a route is null");
            }
        }
        // System.out.print(text);
        System.out.print(
                "File is created successfully with the content.");
        f_writer.close();
    }

    public void clear() {
        this.previous = null;
        this.distance = RouteGraph.MAX_DISTANCE;
    }

    /**
     * The function returns a string that contains the IATA code of the current
     * vertex, the previous
     * vertex, and the distance from the source vertex
     * 
     * @return The IATA code of the current vertex, the previous vertex, and the
     *         distance.
     */
    @Override
    public String toString() {
        String result = this.currentVertex.getIATACdode();
        if (this.previous != null) {
            result += "previous=" + this.previous;
        }
        if (this.distance < RouteGraph.MAX_DISTANCE) {
            result += "distance=" + this.distance;
        }

        return result + this.currentVertex.getAirportName();
    }

    /**
     * It compares the distance of the current vertex to the distance of the vertex
     * passed in as a
     * parameter.
     * 
     * @param o The vertex to compare to
     * @return The distance between the two vertices.
     */
    @Override
    public int compareTo(Vertex o) {
        if (this.distance < o.distance) {
            return -1;
        }

        else if (this.distance > o.distance) {
            return 1;
        }
        return 0;
    }
}