import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class PathFinder {
    private File inputFile;
    private FlightRouteSearcher routeSearcher;

    public PathFinder(String fileLocation) {
        this.inputFile = new File(fileLocation);
        this.routeSearcher = new FlightRouteSearcher();
    }

    /**
     * It reads a file and sets the start and end cities and countries
     */
    public void readInputFile() {

        Scanner sc;
        try {
            sc = new Scanner(this.inputFile);
            String[] lines = new String[4];
            int i = 0;
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().trim().split(",");
                lines[i] = line[0].trim();
                i++;
                lines[i] = line[1].trim();
                ++i;
            }
            this.routeSearcher.setStartCity(lines[0]);
            this.routeSearcher.setStartCountry(lines[1]);
            this.routeSearcher.setEndCity(lines[2]);
            this.routeSearcher.setEndCountry(lines[3]);
            // System.out.println(routeSearcher.getStartCountry());

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * It reads a csv file and returns an array of two objects of type Airport
     * 
     * @return An array of Airport objects.
     */
    public Airport[] getStartEndAirport() throws IOException {
        Airport startAirport = null;
        Airport destinationAirport = null;
        BufferedReader reader = new BufferedReader(new FileReader("airports.csv"));
        String row;
        // Reading the csv file and checking if the a line has city and country the same
        // as the ones in the
        // input file.
        while ((row = reader.readLine()) != null) {
            String[] data = row.split(",");
            // System.out.println(data[2].trim());
            if (data[2].trim().equals(this.routeSearcher.getStartCity())
                    && data[3].trim().equals(this.routeSearcher.getStartCountry())) {
                // System.out.println("hit");
                startAirport = new Airport(data[0], data[1], data[2], data[3], data[4], data[5],
                        Double.parseDouble(data[6]), Double.parseDouble(data[7]), Double.parseDouble(data[8]));

                routeSearcher.setHomeAirport(startAirport);
            }

            if (data[2].trim().equals(this.routeSearcher.getEndCity())
                    && data[3].trim().equals(this.routeSearcher.getEndCountry())) {
                // System.out.println("hit");
                destinationAirport = new Airport(data[0], data[1], data[2], data[3], data[4], data[5],
                        Double.parseDouble(data[6]), Double.parseDouble(data[7]), Double.parseDouble(data[8]));

                routeSearcher.setDestinationAirport(destinationAirport);
            }

        }
        reader.close();
        // System.out.println(startAirport.getIATACdode());
        Airport[] startEndDetails = { startAirport, destinationAirport };
        // System.out.println(startEndDetails[1].getIATACdode());
        return startEndDetails;
    }

    /**
     * 
     * 
     * 
     * @param airportId The airport's unique identifier
     * @param IATACode  The IATA code of the airport
     * @return The method is returning an Airport object.
     */
    public Airport generateAirportByIATAC(String airportId, String IATACode) throws NumberFormatException, IOException {
        // Airport newAirport;

        try (BufferedReader reader = new BufferedReader(new FileReader("airports.csv"))) {
            String row;
            // Reading the csv file and checking if the a line has city and country the same
            // as the ones in the
            // input file.
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(",");

                if ((airportId.equals(data[0]) && (IATACode.equals(data[5])
                        || IATACode.equals(data[4])))) {
                    Airport newAirport = new Airport(data[0], data[1], data[2], data[3], data[4], data[5],
                            Double.parseDouble(data[6]), Double.parseDouble(data[7]), Double.parseDouble(data[8]));
                    // System.out.println("Hit hit hit ");
                    return newAirport;
                }

            }
            // System.out.println(newAirport);
            reader.close();
        }
        return null;
    }

    /**
     * This function takes an airport object and returns a hashmap of routes and
     * airports that are
     * neighbors of the airport
     * 
     * @param airport The airport that we want to find the neighbors of
     * @return A HashMap of Routes and Airports
     */
    public HashMap<Route, Airport> getAirportNeighbors(Airport airport) throws IOException {
        // ArrayList<Airport> neighborAirports = new ArrayList<Airport>();
        ArrayList<Route> routes = new ArrayList<Route>();
        HashMap<Route, Airport> neighbors = new HashMap<Route, Airport>();
        BufferedReader reader = new BufferedReader(new FileReader("routes.csv"));
        String row;

        while ((row = reader.readLine()) != null) {
            String[] data = row.split(",");

            if (data[3].equals(airport.getAirportId()) && (data[2].equals(airport.getIATACdode())
                    || data[2].equals(airport.getICAOCode()))) {
                Route newRoute = new Route(data[0], data[1], data[2], data[3], data[4], data[5],
                        data[6], data[7]);
                routes.add(newRoute);
                Airport generatedAirport = this.generateAirportByIATAC(newRoute.getDestinationAirportId(),
                        newRoute.getDestinationAirport());
                Airport sourceAirport = this.generateAirportByIATAC(newRoute.getSourceAirportId(),
                        newRoute.getSourceAirport());
                newRoute.setDestination(generatedAirport);
                newRoute.setSource(sourceAirport);
                try {

                    newRoute.calRouteCost();
                } catch (NullPointerException e) {
                    e.getMessage();

                }
                // neighborAirports.add(this.generateAirportByIATAC(newRoute));
                neighbors.put(newRoute, generatedAirport);
            }

        }
        reader.close();
        // System.out.println(neighbors.size());
        return neighbors;

    }



    private double calcDistance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == 'K') {
            dist = dist * 1.609344;
        } else if (unit == 'N') {
            dist = dist * 0.8684;
        }
        return (dist);
    }


    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

   

    public Vertex optimalPathSearchByAstar() throws IOException {

        Airport endAirport = this.routeSearcher.getDestinationAirport();
        Vertex node = new Vertex(this.routeSearcher.getHomeAirport(), null, null, 0);
        System.out.println(this.routeSearcher.getTotalSearchDistance());
        PriorityQueue<Vertex> frontier = new PriorityQueue<Vertex>(new VertexComparator());
        frontier.add(node);
        HashSet<Integer> explored = new HashSet<Integer>();

        while (!frontier.isEmpty()) {
            node = frontier.poll();
            System.out.println(node.getDistance());
            if (node.getCurrentVertex().getAirportId().equals(endAirport.getAirportId())) {
                System.out.println("Found solution !!");
                node.getPathToDestination();
                node.writeOutputPathToFile(
                        this.inputFile.getName().substring(0, this.inputFile.getName().lastIndexOf('.')));
                return node;
            }

            explored.add(Integer.parseInt(node.getCurrentVertex().getAirportId()));
            // System.out.println("Explored: " + explored);
            HashMap<Route, Airport> results = getAirportNeighbors(node.getCurrentVertex());
            for (Route route : results.keySet()) {

                Double pathcost = calcDistance(results.get(route).getLatitude(), results.get(route).getLongitutde(),node.getCurrentVertex().getLatitude(), node.getCurrentVertex().getLongitutde(), 'K') + calcDistance(node.getCurrentVertex().getLatitude(), node.getCurrentVertex().getLongitutde(), results.get(route).getLatitude(), results.get(route).getLongitutde(),'K');
                // Double neighborCost = pathcost + 
                Vertex neighbor = new Vertex(results.get(route), node, route);
                neighbor.setDistance(pathcost + node.getDistance());

                if (neighbor.getCurrentVertex() != null
                        && !explored.contains(Integer.parseInt(neighbor.getCurrentVertex().getAirportId()))) {
                    frontier.add(neighbor);
                }

            }
        }

        return null;

    }

    public Vertex breadthFirstSearch() throws IOException {

        Airport startAirport = getStartEndAirport()[0];
        Airport endAirport = getStartEndAirport()[1];
        Vertex node = new Vertex(startAirport, null, null, 0);
        if (startAirport.getCity().equals(endAirport.getCity())) {
            System.out.println("Found solution !!");
            return node;
        }
        Queue<Vertex> frontier = new LinkedList<Vertex>();
        frontier.add(node);
        // System.out.println("frontier, " + frontier);
        Set<Vertex> explored = new HashSet<Vertex>();

        while (!frontier.isEmpty()) {
            node = frontier.poll();
            // System.out.println("Popped: " + node);
            explored.add(node);
            // System.out.println("Explored: " + explored);
            HashMap<Route, Airport> results = getAirportNeighbors(node.getCurrentVertex());
            for (Route route : results.keySet()) {
                // Airport airport = results.get(route);
                // System.out.println(airport);

                Vertex neighbor = new Vertex(results.get(route), node, route,
                        node.getDistance() + route.getRoutecost()); // System.out.println("neighbor: " +
                                                                    // neighbor.currentVertex);
                // if (neighbor.getCurrentVertex() == null) {
                // System.out.println("Sorry there was no route for the given start city and
                // destination city");
                // // return null;
                // }
                if (neighbor.getCurrentVertex() != null && !explored.contains(neighbor)
                        && !frontier.contains(neighbor)) {
                    if (neighbor.getCurrentVertex().getCity().equals(endAirport.getCity())) {
                        System.out.println("Found solution !!");
                        neighbor.getPathToDestination();
                        neighbor.writeOutputPathToFile(
                                this.inputFile.getName().substring(0, this.inputFile.getName().lastIndexOf('.')));

                        return neighbor;
                    }
                    // System.out.println(frontier);
                    frontier.add(neighbor);
                }
            }
        }

        return null;

    }

    public static void main(String[] args) {
        PathFinder test1 = new PathFinder("accra-winnepeg.txt");
        test1.readInputFile();
        try {
            test1.getStartEndAirport();
            test1.optimalPathSearchByAstar();
            test1.breadthFirstSearch();
            // writeOutputPathToFile(test1.inputFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

// else if (neighbor.getCurrentVertex() != null && frontier.contains(neighbor))
// {
// Iterator<Vertex> it = frontier.iterator();

// while (it.hasNext()) {
// Vertex front = it.next();
// if (front.equals(neighbor)
// && neighbor.compareTo(front) > 0) {
// frontier.remove(front);
// frontier.add(neighbor);
// System.out.println("hit");
// return front;

// // System.out.println("Value: " + it.next());

// }
// }
// }