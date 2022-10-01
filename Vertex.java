/**
 * 
 * 
 * @author Simon Junior Boateng
 * 
 * @since Version 1.1
 *
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Vertex{
    /** The vertex itself. */
    private Airport currentVertex;
    private Vertex previous;
    private Route route;
    private int stops;
    private double distance;

   // A constructor that takes in an airport, a vertex, a route, and an integer and sets the current
   // vertex to the airport, the previous vertex to the vertex, the route to the route, the stops to
   // the integer, and the distance to 0.0.
    public Vertex(Airport curVertex, Vertex prev, Route route) throws NullPointerException {
        // if (curVertex == null) {
        // throw new NullPointerException("Argument must not be null");
        // }
        this.currentVertex = curVertex;
        this.previous = prev;
        this.route = route;
        this.stops = 0;
        this.distance = 0.0;
        // this.clear();
    }

// A constructor that takes in an airport and sets the current vertex to the airport and the previous
// vertex to null.
    public Vertex(Airport startAirport) {
        this.currentVertex = startAirport;
        this.previous = null;
    }


    // A getter and setter method.
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

    public int getStops() {
        return this.stops;
    }

    public void setStops(int stops) {
        this.stops += stops;
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
            if(CurrentVertex.route !=null)
                this.setStops(Integer.parseInt(CurrentVertex.route.getStops()));
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
        int i = 1;
        for (Route route : this.getPathToDestination()) {

            try {
                f_writer.write(i + ". "+ route.toString() + "\n");
                i++;

            } catch (NullPointerException n) {
                n.getMessage();

            } finally {
                System.out.println("a route is null");
            }
            
        }
        f_writer.write("Total Flights: " + (this.getPathToDestination().size()-1) + "\n");
        f_writer.write("Total additional stops: "  + this.route.getStops() + "\n");
        f_writer.write("Total distance: "  + this.getDistance() + "\n");
        f_writer.write("Optimality criteria:  distance in km");


        // System.out.print(text);
         System.out.print(
                "File is created successfully with the valid optimal route.");
        f_writer.close();
    }


    public void writeOutputPathToFileForBFS(String inputFileName) throws IOException {

        String outPutFileName = String.format("%s_output.txt",
                inputFileName);

        BufferedWriter f_writer = new BufferedWriter(new FileWriter(outPutFileName));

        int i = 1;
        for (Route route : this.getPathToDestination()) {
            try {
                f_writer.write(i + ". " + route.toString() + "\n");
                ++i;
                

            } catch (NullPointerException n) {
                n.getMessage();

            } finally {
                System.out.println("a route is null");
            }
            
        }
        f_writer.write("Total Flights: " + (this.getPathToDestination().size()-1) + "\n");
        f_writer.write("Total additional stops: "  + this.route.getStops() + "\n");
        f_writer.write("Optimality criteria:  number of flights");


        // System.out.print(text);
         System.out.print(
                "File is created successfully with the valid optimal route.");
        f_writer.close();
    }



   
    @Override
    public int hashCode() {
        return Objects.hash(this.getCurrentVertex());
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