/**
 * This class is used to store the data of an airline
 */
public class Airline {
    private int airlineId;
    private String airlineName;
    private String alias;
    private String IATACode;
    private String ICAOCode;
    private String callSign;
    private String Country;
    private String active;

// This is a constructor.
    public Airline(int airlineId, String airlineName, String alias, String iatacode, String icacode, String ICAOCode,
            String callSign, String Country, String active) {

        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.alias = alias;
        this.IATACode = iatacode;
        this.ICAOCode = icacode;

    }
/**
 * This function returns the airlineId of the current object
 * 
 * @return The airlineId
 */

    public int getAirlineId() {
        return this.airlineId;
    }

    /**
     * This function sets the airlineId of the object to the value of the parameter airlineId
     * 
     * @param airlineId The airline's unique identifier
     */
    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    /**
     * This function returns the name of the airline
     * 
     * @return The airline name.
     */
    public String getAirlineName() {
        return this.airlineName;
    }

    /**
     * This function sets the airline name
     * 
     * @param airlineName The name of the airline.
     */
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    /**
     * This function returns the alias of the current object
     * 
     * @return The alias of the object.
     */
    public String getAlias() {
        return this.alias;
    }

    /**
     * This function sets the alias of the user
     * 
     * @param alias The alias of the user.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * This function returns the IATA code of the airport
     * 
     * @return The IATACode of the airport.
     */
    public String getIATACode() {
        return this.IATACode;
    }

    /**
     * This function sets the IATA code of the airport
     * 
     * @param IATACode The IATA code of the airport.
     */
    public void setIATACode(String IATACode) {
        this.IATACode = IATACode;
    }

    /**
     * This function returns the ICAO code of the airport
     * 
     * @return The ICAOCode of the airport.
     */
    public String getICAOCode() {
        return this.ICAOCode;
    }

    /**
     * This function sets the ICAO code of the airport
     * 
     * @param ICAOCode The ICAO code of the airport.
     */
    public void setICAOCode(String ICAOCode) {
        this.ICAOCode = ICAOCode;
    }

    /**
     * This function returns the call sign of the aircraft
     * 
     * @return The call sign of the aircraft.
     */
    public String getCallSign() {
        return this.callSign;
    }

    /**
     * This function sets the call sign of the aircraft
     * 
     * @param callSign The callsign of the station you want to get the data for.
     */
    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    /**
     * This function returns the country of the user
     * 
     * @return The country of the person.
     */
    public String getCountry() {
        return this.Country;
    }

    /**
     * This function sets the country of the user
     * 
     * @param Country The country you want to search for.
     */
    public void setCountry(String Country) {
        this.Country = Country;
    }

    /**
     * This function returns the value of the active variable
     * 
     * @return The active variable is being returned.
     */
    public String getActive() {
        return this.active;
    }

    /**
     * This function sets the active variable to the value of the active parameter
     * 
     * @param active This is the active status of the user.
     */
    public void setActive(String active) {
        this.active = active;
    }

}