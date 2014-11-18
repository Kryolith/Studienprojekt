package studienprojekt;

import studienprojekt.osm.OSMCoordinate;

public class Main {
    
    public static void main(String[] args) {
        /*
        // Construct and initialize the main object
        Mapper mapper = new Mapper();
        mapper.initialize();
        
        // Run the main algorithm
        mapper.run();
        
        //test
                */
        
        OSMCoordinate c1 = new OSMCoordinate(51.482903f,7.211810f);
        OSMCoordinate c2 = new OSMCoordinate(52.523403f,13.411400f);
        
        System.out.println("1: " + c1.distanceTo(c2));
    } 
}
