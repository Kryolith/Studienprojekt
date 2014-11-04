/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studienprojekt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

/**
 *
 * @author Sebastian
 */
public class MapHandler {
    
    // Konstanten für den API-Zugriff
    public static final String apiVersion = "0.6";
    public static final String apiMapDataUrl = "map?bbox=%.5f,%.5f,%.5f,%.5f";
    
    // Membervariable für die API url
    private String apiUrl;
    
    // Constructor
    public MapHandler(String apiUrl) {
        this.apiUrl = apiUrl;        
    }
    
    // Setter    
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    
    // Getter
    public String getApiUrl() {
        return this.apiUrl;
    }
    
    // Funktion um Mapdaten in einem bestimmten Radius um einen Punkt abzufragen
    public String getMapDataRadius(double lat, double lon, double radius) {
        double lat_min = lat - (radius / 2);
        double lat_max = lat + (radius / 2);
        double lon_min = lon - radius;
        double lon_max = lon + radius;
        
        return this.getMapDataByBounds(lat_min, lon_min, lat_max, lon_max);
    }
    
    public String getMapDataByBounds(double lat_min, double lon_min, double lat_max, double lon_max) {
        String finalUrl = this.apiUrl + "/" + 
                                MapHandler.apiVersion + "/" + 
                                String.format(Locale.US, MapHandler.apiMapDataUrl, lat_min, lon_min, lat_max, lon_max);
        System.out.println(finalUrl);
        return this.getHtml(finalUrl);
    }
    
    public String getHtml(String urlToRead) {
      URL url;
      HttpURLConnection conn;
      BufferedReader rd;
      String line;
      String result = "";
      try {
         url = new URL(urlToRead);
         conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         while ((line = rd.readLine()) != null) {
            result += line;
         }
         rd.close();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return result;
    } 
}
