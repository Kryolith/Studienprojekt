package studienprojekt;

import java.util.List;

/**
 *
 * @author Sebastian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Construct and initialize the main object
        Mapper mapper = new Mapper();
        mapper.initialize();
        
        // Run the main algorithm
        mapper.run();
    } 
}
