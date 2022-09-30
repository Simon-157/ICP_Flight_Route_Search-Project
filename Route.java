/**
 * The Route class is a POJO that contains the data for a single route.
 */
public class Route {
    // Defining the variables that will be used in the class.
    private String airlineCode;
    private String airlineId;
    private String sourceAirport;
    private String sourceAirportId;
    private String destinationAirport;
    private String destinationAirportId;
    private String codeShare;
    private String stops;
    private Airport source;
    private Airport destination;
    private double routecost;

    // A constructor.
    public Route(String airlineCode, String airlineId, String sourceAirport, String sourceAirportId,
            String destinationAirport, String destinationAirportId, String codeShare, String stops) {
        this.airlineCode = airlineCode;
        this.airlineId = airlineId;
        this.sourceAirport = sourceAirport;
        this.sourceAirportId = sourceAirportId;
        this.destinationAirport = destinationAirport;
        this.destinationAirportId = destinationAirportId;
        this.codeShare = codeShare;
        this.stops = stops;
        this.source = null;
        this.destination = null;

    }

    /**
     * The function takes the source and destination coordinates of a route and
     * calculates the cost of, cost here is taken as the distance
     * the route using the Haversine formula
     * 
     * @return The cost of the route
     */
    public double calRouteCost() throws NullPointerException{
        double lon1 = Math.toRadians(this.source.getLongitutde());
        double lon2 = Math.toRadians(this.destination.getLongitutde());
        double lat1 = Math.toRadians(this.source.getLatitude());
        double lat2 = Math.toRadians(this.destination.getLatitude());

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                        * Math.pow(Math.sin(dlon / 2), 2);

        double cost = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double radius = 6371;

        // calculate the result
        this.setRoutecost(cost * radius);
        return (cost * radius);

    }

   /**
    * The function takes in a string and returns a string
    * 
    * @return The airline code, the source airport, the destination airport, and the number of stops.
    */
    @Override
    public String toString() {
        return this.airlineCode +" from " + this.source.getIATACdode() + " to " + this.destination.getIATACdode() + " " + this.stops + " stops";
    }

    public double getRoutecost() {
        return this.routecost;
    }

    public void setRoutecost(double routecost) {
        this.routecost = routecost;
    }

    public Airport getSource() {
        return this.source;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public Airport getDestination() {
        return this.destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    /**
     * This function returns the airline code of the flight
     * 
     * @return The airline code.
     */
    public String getAirlineCode() {
        return this.airlineCode;
    }

    /**
     * This function sets the airline code
     * 
     * @param airlineCode The airline code of the airline you want to search for.
     */
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    /**
     * This function returns the airlineId of the airline
     * 
     * @return The airlineId is being returned.
     */
    public String getAirlineId() {
        return this.airlineId;
    }

    /**
     * This function sets the airlineId of the object to the value of the parameter
     * airlineId
     * 
     * @param airlineId The airline's unique identifier
     */
    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    /**
     * This function returns the source airport of the flight
     * 
     * @return The sourceAirport variable is being returned.
     */
    public String getSourceAirport() {
        return this.sourceAirport;
    }

    /**
     * This function sets the source airport of the flight
     * 
     * @param sourceAirport The airport code of the source airport.
     */
    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    /**
     * This function returns the source airport id
     * 
     * @return The sourceAirportId
     */
    public String getSourceAirportId() {
        return this.sourceAirportId;
    }

    /**
     * This function sets the sourceAirportId to the value of the parameter
     * sourceAirportId
     * 
     * @param sourceAirportId The airport code of the source airport.
     */
    public void setSourceAirportId(String sourceAirportId) {
        this.sourceAirportId = sourceAirportId;
    }

    /**
     * This function returns the destination airport of the flight
     * 
     * @return The destination airport.
     */
    public String getDestinationAirport() {
        return this.destinationAirport;
    }

    /**
     * This function sets the destination airport of the flight
     * 
     * @param destinationAirport The airport code of the destination airport.
     */
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    /**
     * This function returns the destination airport id.
     * 
     * @return The destinationAirportId
     */
    public String getDestinationAirportId() {
        return this.destinationAirportId;
    }

    /**
     * This function sets the destination airport id
     * 
     * @param destinationAirportId The airport code of the destination airport.
     */
    public void setDestinationAirportId(String destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    /**
     * This function returns the code share of the flight
     * 
     * @return The codeShare variable is being returned.
     */
    public String getCodeShare() {
        return this.codeShare;
    }

    /**
     * // Java
     * public void setCodeShare(String codeShare) {
     * this.codeShare = codeShare;
     * }
     * 
     * @param codeShare The code share is the code that is used to identify the
     *                  flight.
     */
    public void setCodeShare(String codeShare) {
        this.codeShare = codeShare;
    }

    /**
     * This function returns the number of stops in the route
     * 
     * @return The number of stops.
     */
    public String getStops() {
        return this.stops;
    }

    /**
     * This function sets the number of stops for the bus
     * 
     * @param stops The number of stops the train has to make.
     */
    public void setStops(String stops) {
        this.stops = stops;
    }

}