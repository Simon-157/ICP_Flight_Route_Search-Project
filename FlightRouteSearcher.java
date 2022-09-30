import java.util.ArrayList;

/**
 * // Java
 * public class FlightRouteSearcher {
 *     // Searches for flight routes.
 * }
 */
public class FlightRouteSearcher {
    private String startCity;
    private String startCountry;
    private String endCity;
    private String endCountry;
    private Airport homeAirport;
    private ArrayList<Route> routesToDestination;

    // A constructor.
    public FlightRouteSearcher() {
        this.startCity = "";
        this.startCountry = "";
        this.endCountry = "";
        this.endCity = "";
        this.routesToDestination = new ArrayList<Route>();
        this.homeAirport = new Airport(startCity, startCountry);
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


    public ArrayList<Route> getRoutesToDestination() {
        return this.routesToDestination;
    }

    public void setRoutesToDestination(ArrayList<Route> routesToDestination) {
        this.routesToDestination = routesToDestination;
    }


    public boolean destinationTest(Airport destination) {
        return this.endCountry == destination.getCountry() && this.endCity == destination.getCity();
    }

}
