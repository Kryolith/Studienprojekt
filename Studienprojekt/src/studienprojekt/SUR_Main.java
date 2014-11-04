package studienprojekt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xml.sax.SAXException;
import studienprojekt.osm.OSMCoordinate;
import studienprojekt.osm.OSMMap;
import studienprojekt.osm.OSMParser;

public class SUR_Main {
    public static void main(String[] args)
    {
    	OSMParser osmParser = new OSMParser();
    	OSMCoordinate surCoordinate = new OSMCoordinate(5.34174, 50.9325);
    	OSMMap areaToCheck = null;
	    try
	    {
	    	areaToCheck = osmParser.getOSMMap(surCoordinate, 0.0002);
	    }
	    
	    catch (ParserConfigurationException pce)
	    {
	    	System.out.println(pce);
	    }
	    catch (SAXException saxe)
	    {
	    	System.out.println(saxe);
	    }
	    catch (IOException ioe)
	    {
	    	System.out.println(ioe);
	    }
	    
	    System.out.println("TESTAUSGABE: auslesen des Inhalts des generierten OSMMap-Objekts:");
	    System.out.print(areaToCheck);
    /*	
    String iterations;
    String data = "";	
    FileReader fr = new FileReader("Data.txt");
    BufferedReader br = new BufferedReader(fr);
    iterations = br.readLine();
    int n = Integer.parseInt(iterations);
    System.out.print(data);
    
    for (int i = 0;  i < n; i++)
    {
    	data += br.readLine() + "\n" ;
    }
    //System.out.print(data);
    
    StringTokenizer st1 = new StringTokenizer(data, "\n");
    StringTokenizer st2 = null;
    
    String[] datensaetze = new String[n];
    
    for (int i = 0;  i < n; i++)
    {
    	if(!(st1.hasMoreTokens()))
    		break;
    	datensaetze[i] = st1.nextToken();
    }
    
    ArrayList<Double> longitudes = new ArrayList<Double>();
    ArrayList<Double> latitudes = new ArrayList<Double>();
    
    String latitudeStr = "";
    String longitudeStr = "";
    
    String locIdentifierOld = "0000";
    String locIdentifierNew = "";
    for (int i = 0;  i < n; i++)
    {
    	//System.out.println(datensaetze[i]);
    	st2 = new StringTokenizer(datensaetze[i], ", ");
    	locIdentifierNew = st2.nextToken();
    	
    	if (locIdentifierNew.equals(locIdentifierOld))
    		continue;
    	
    	locIdentifierOld = locIdentifierNew;
    	
    	latitudeStr = st2.nextToken();
    	longitudeStr = st2.nextToken();
    	
    	latitudes.add(new Double(latitudeStr));
    	longitudes.add(new Double(longitudeStr));
    }
    
    HttpClient client = new DefaultHttpClient();
    
    for(int i = 0; i < longitudes.size(); i++)
    {	
	    double left, bottom, right, top;
	    left = Math.rint(((longitudes.get(i) - 0.0002) * 100000)) / 100000;
	    bottom = Math.rint(((latitudes.get(i) - 0.0002) * 100000)) / 100000;
	    right = Math.rint(((longitudes.get(i) + 0.0002) * 100000)) / 100000;
	    top = Math.rint(((latitudes.get(i) + 0.0002) * 100000)) / 100000;
	    
	    System.out.println(left + ", " + bottom + ", " + right + ", " + top); 
	    String url = "http://api.openstreetmap.org/api/0.6/map?bbox="+left+","+bottom+","+right+","+top;
	    System.out.println(url); 
	    
	    //HttpGet request = new HttpGet("http://api.openstreetmap.org/api/0.6/map?bbox=5.3390,50.9300,5.3490,50.9400");
	    //HttpGet request = new HttpGet("http://api.openstreetmap.org/api/0.6/map?bbox=50.9104,5.3190,50.9504,5.35901");
	    HttpGet request = new HttpGet(url);
	    HttpResponse response = client.execute(request);
	    BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
	    String line = "";
	        
	    try {
	        	File file = new File ("ApSegment_" + i + ".osm");
	        	file.createNewFile();
	        	FileWriter writer = new FileWriter (file , true);        	
	            while ((line = rd.readLine()) != null) {
	                writer.write(line);
	                writer.write("\n");
	            }    
	        	writer.flush ();
	        	writer.close ();
	    	}
	    
	    	catch (IOException e) {
	    		e.printStackTrace ();
	    	}
    }
    */
  }   
}