/**
 * 
 * 
 * @author Simon Junior Boateng
 * 
 * @since Version 1.1
 *
 */


public class FlightRouteSearcher {
    private String startCity;
    private String startCountry;
    private String endCity;
    private String endCountry;
    private Airport homeAirport;
    private Airport destinationAirport;
    private double totalSearchDistance;


    // A constructor.
    public FlightRouteSearcher() {
        this.startCity = null;
        this.startCountry = null;
        this.endCountry = null;
        this.endCity = null;
        this.homeAirport = null;
        destinationAirport = null;
    }

    public String getStartCity() {
        return this.startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    // A getter and setter method.
    public String getStartCountry() {
        return this.startCountry;
    }

    public void setStartCountry(String startCountry) {
        this.startCountry = startCountry;
    }

    public String getEndCity() {
        return this.endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public String getEndCountry() {
        return this.endCountry;
    }

    public void setEndCountry(String endCountry) {
        this.endCountry = endCountry;
    }


    public Airport getHomeAirport() {
        return this.homeAirport;
    }

    public void setHomeAirport(Airport homeAirport) {
        this.homeAirport = homeAirport;
    }


    public Airport getDestinationAirport() {
        return this.destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }


    public double getTotalSearchDistance() {
        return this.totalSearchDistance;
    }

    public void setTotalSearchDistance(double totalSearchDistance) {
        this.totalSearchDistance = totalSearchDistance;
    }
 


    public boolean destinationTest(Airport destination) {
        return this.endCountry == destination.getCountry() && this.endCity == destination.getCity();
    }

}
