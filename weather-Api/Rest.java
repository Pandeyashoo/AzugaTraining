import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.log4j.Logger;

/**
 * This class provides the weather data of all the countries which are there in the array
 */
public class Rest{

    static final Logger logger = Logger.getLogger(Rest.class);
    public static String url = "http://api.weatherapi.com/v1/current.json?key=0d891b92703446aa93720945220510&q=";

    public static void main(String[] args) throws IOException, InterruptedException, JSONException {

       logger.info("Data is fetched from weather using url "+url);
        String[] cities = {"india","madrid","china","bangladesh","japan","australia"};

        String sb3;
        StringBuilder stbr = new StringBuilder();
        stbr.append("[");

         logger.warn("waiting for http response");
        for (String city : cities) {
            // passing the weather API
            var urls = url + city + "&aqi=yes";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(urls)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.debug(urls);

            String sb = response.body();

            //logger.debug("Object Data "+response.body());

            String sb1 = sb.replace("{\"location\":{", "");
            String sb2 = sb1.replace("\"current\":{", "");

            String sb4 = sb2.replace("{", "\"\",");

            sb3 = sb4.replace("}", "");

            stbr.append("{");
            stbr.append(sb3);
            stbr.append("},");
        }
        stbr.append("]");

        //Write all the data in the JSON file
       try (FileWriter fw = new FileWriter("/Users/azuga/Desktop/weather.json")) {
            fw.write(stbr.toString());
            logger.info("writing response to weather.json file");
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
            System.out.println("an error occurred while creating or writing to the file");
        }
        InputStream is = new FileInputStream("/Users/azuga/Desktop/weather.json");
        System.out.println(is.toString());
        JSONTokener tokener = new JSONTokener(is.toString());
        logger.info("writing json data to  weather1.csv file");
        System.out.println(tokener);//break a string into tokens
        JSONArray jsonArray = new JSONArray(tokener);        // convert that to jsonArray
        StringBuilder csv = new StringBuilder();
        csv.append(CDL.toString(jsonArray));
        try {
            // Convert JSONArray into csv and save the file
            Files.write(Path.of("/Users/azuga/Desktop/weather1.csv"), csv.toString().getBytes());
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
        }
        System.out.println("completed");

    }
}