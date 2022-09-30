import java.util.ArrayList;

/**
 * The Airport class is a Java class that represents an airport.
 */
public class Airport {
    private String airportId;
    private String airportName;
    private String city;
    private String country;
    private String IATACdode;
    private String ICAOCode;
    private double latitude;
    private double longitutde;
    private double altitude;
    private ArrayList<Route> connectedRoutes;
    private ArrayList<Airport> neighboringAirports;

    public Airport(String startCity, String startCountry) {
    }

    public Airport(String airportId, String airportName, String city, String country, String iatacdode, String icaoCode,
            double lat, double longi, double alt) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
        this.IATACdode = iatacdode;
        this.ICAOCode = icaoCode;
        this.latitude = lat;
        this.longitutde = longi;
        this.altitude = alt;
    }

    public void addEdgeRoute(Route route) {
        connectedRoutes.add(route);

    }

    public void addNeighborAirport(Airport neighbor) {
        neighboringAirports.add(neighbor);
    }

    public String toString() {
        return "AirportId: " + this.airportId + " ,AirportIATACode: " + this.IATACdode + " ,City: " + this.city
                + " ,Country: " + this.country + ", "
                + this.latitude + " ," + this.longitutde;
    }

    public String getAirportId() {
        return this.airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return this.airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIATACdode() {
        return this.IATACdode;
    }

    public void setIATACdode(String IATACdode) {
        this.IATACdode = IATACdode;
    }

    public String getICAOCode() {
        return this.ICAOCode;
    }

    public void setICAOCode(String ICAOCode) {
        this.ICAOCode = ICAOCode;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public double getLongitutde() {
        return this.longitutde;
    }

    public void setLongitutde(int longitutde) {
        this.longitutde = longitutde;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    /**
     * If the object is compared with itself then return true
     * 
     * @param obj The object to be compared.
     * @return The method is returning a boolean value.
     */
    @Override
    public boolean equals(Object obj) {

        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Airport)) {
            return false;
        }

        // typecast o to Airport so that we can compare data members
        Airport c = (Airport) obj;

        // Compare the data members and return accordingly
        return this.altitude == getAltitude()
                && this.airportName == c.getAirportName()
                && this.airportId == c.getAirportId()
                && this.IATACdode == c.getIATACdode()
                && this.ICAOCode == c.getICAOCode()
                && this.latitude == c.getLatitude()
                && this.longitutde == c.getLongitutde();
    }

}
