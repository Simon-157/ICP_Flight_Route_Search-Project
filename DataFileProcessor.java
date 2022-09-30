import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DataFileProcessor {

    protected static ArrayList<HashMap<String, String>> allAirlines = new ArrayList<HashMap<String, String>>();
    protected static ArrayList<HashMap<String, String>> allAirports = new ArrayList<HashMap<String, String>>();
    protected static ArrayList<HashMap<String, String>> allRoutes = new ArrayList<HashMap<String, String>>();

    public DataFileProcessor() {
        allAirlines = new ArrayList<HashMap<String, String>>();
        allAirports = new ArrayList<HashMap<String, String>>();
        allRoutes = new ArrayList<HashMap<String, String>>();
    }

    public static void populateAirlinesData(String string) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(string));
        String line;
        List<List<String>> data = new ArrayList<List<String>>();
        line = reader.readLine();
        while ( line!= null) {
            List<String> lineData = Arrays.asList(line.split(","));
            data.add(lineData);
            line = reader.readLine();

        }
        for (List<String> lineData : data) {
            HashMap<String, String> airlinesData = new HashMap<String, String>();
            airlinesData.put("AirlineId", lineData.get(0));
            airlinesData.put("AirlineName", lineData.get(1));
            airlinesData.put("Allias", lineData.get(2));
            airlinesData.put("IATACode", lineData.get(3));
            airlinesData.put("ICAOCode", lineData.get(4));
            airlinesData.put("CallSign", lineData.get(5));
            airlinesData.put("Country", lineData.get(6));
            airlinesData.put("Active", lineData.get(7));

            allAirlines.add(airlinesData);
        }

        reader.close();
    }


    public static void populateAirportsData(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        List<List<String>> data = new ArrayList<List<String>>();
        line = reader.readLine();
        while ( line!= null) {
            List<String> lineData = Arrays.asList(line.split(","));
            data.add(lineData);
            line = reader.readLine();

        }

        // System.out.println(data);
        
        for (List<String> lineData : data) {
            HashMap<String, String> airportsData = new HashMap<String, String>();
            airportsData.put("AirportId", lineData.get(0).trim());
            airportsData.put("AirportName", lineData.get(1).trim());
            airportsData.put("City", lineData.get(2).trim());
            airportsData.put("Country", lineData.get(3).trim());
            airportsData.put("IATACode", lineData.get(4).trim());
            airportsData.put("ICAOCode", lineData.get(5).trim());
            airportsData.put("Latitude", lineData.get(6).trim());
            airportsData.put("Longitude", lineData.get(7).trim());
            airportsData.put("Altitude", lineData.get(8).trim());
            allAirports.add(airportsData);
            // System.out.println(airportsData);
            // airportsData.clear();
        }
        reader.close();
    }


    public static void populateRoutesData(String string) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(string));
        String line;
        List<List<String>> data = new ArrayList<List<String>>();
        line = reader.readLine();
        while ( line!= null) {
            List<String> lineData = Arrays.asList(line.split(","));
            data.add(lineData);
            line = reader.readLine();

        }
        for (List<String> lineData : data) {
            HashMap<String, String> routesData = new HashMap<String, String>();
     
            routesData.put("Airline", lineData.get(0));
            routesData.put("AirlineId", lineData.get(1));
            routesData.put("SourceAirport", lineData.get(2));
            routesData.put("SourceAirportId", lineData.get(3));
            routesData.put("DestinationAirport", lineData.get(4));
            routesData.put("DestinationAirportId", lineData.get(5));
            routesData.put("CodeShare", lineData.get(6));
            routesData.put("Stops", lineData.get(7));
            // routesData.put("Equipment", values[8]);
            allRoutes.add(routesData);
        }
        reader.close();
    }

    public static void printData() {
        // System.out.println(allAirports.size());
    }

    public static void processFiles() throws IOException {

        // DataFilesProcessor instance = new DataFilesProcessor();
            DataFileProcessor.populateAirlinesData("airlines.csv");
            DataFileProcessor.populateAirportsData("airports.csv");
            DataFileProcessor.populateRoutesData("routes.csv");
            DataFileProcessor.printData();
        
     
    }

    public static void main(String[] args) {
        try {
            DataFileProcessor.processFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}