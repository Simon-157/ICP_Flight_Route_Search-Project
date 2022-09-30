import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Vertex{
    /** The vertex itself. */
    private Airport currentVertex;
    private Vertex previous;
    private Route route;
    private double distance;

    public Vertex(Airport curVertex, Vertex prev, Route route) throws NullPointerException {
        // if (curVertex == null) {
        // throw new NullPointerException("Argument must not be null");
        // }
        this.currentVertex = curVertex;
        this.previous = prev;
        this.route = route;
        this.distance = 0.0;
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

    public void setDistance(double dist) {
        this.distance = dist;
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
        Vertex CurrentVertex = new Vertex(this.currentVertex, this.previous, this.route);
        // CurrentVertex.setDistance();
        while (CurrentVertex != null) {
            deque.addFirst((CurrentVertex.route));
            CurrentVertex = CurrentVertex.previous;
        }
        // deque.addFirst(CurrentVertex.route);
        return deque;
    }

    /**
     * It writes the output of the program to a file
     * 
     * @param inputFileName the name of the file that contains the flight routes
     */
    public void writeOutputPathToFile(String inputFileName) throws IOException {

        String outPutFileName = String.format("%s_output.txt",
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
        f_writer.write("Total Flights: " + (this.getPathToDestination().size()-1) + "\n");
        f_writer.write("Total additional stops: "  + this.route.getStops());
        // System.out.print(text);
         System.out.print(
                "File is created successfully with the content.");
        f_writer.close();
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
            result += " previous= " + this.previous;
        }
        result += " distance= " + this.distance;
        

        return result + this.currentVertex.getAirportName();
    }

}