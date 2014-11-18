package studienprojekt;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import studienprojekt.osm.OSMCoordinate;
import studienprojekt.osm.OSMMap;
import studienprojekt.osm.OSMParser;
import studienprojekt.rules.SmokingRule;

public class Main {
    
    public static void main(String[] args) {
     /*  
    	OSMParser osmParser = new OSMParser();
    	OSMCoordinate surCoordinate = new OSMCoordinate(5.33901, 50.9304);
    	OSMMap areaToCheck = null;
	    try
	    {
	    	areaToCheck = osmParser.getOSMMap(surCoordinate, 0.0003);
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
	    
	//    System.out.println("TESTAUSGABE: auslesen des Inhalts des generierten OSMMap-Objekts:");
	//    System.out.print(areaToCheck);
        SpaceUsageRule sur = new SpaceUsageRule("smoking", "no");    
        SmokingRule noSmoke = new SmokingRule();
        noSmoke.handle(areaToCheck, surCoordinate, sur);
    */    
     

// Construct and initialize the main object
        Mapper mapper = new Mapper();
        mapper.initialize();
        
        // Run the main algorithm
        mapper.run();
        
        //test
     
    } 
}
