package studienprojekt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OutfileHandler {
    
    private String path;
    private File dir;
    
    public OutfileHandler(String path) {
        this.path = path;
        this.dir = new File(this.path);
        
        if(!this.dir.exists()) {
            this.dir.mkdir();
        }
    }    
    
    public void saveData(String data, String filename) {
        File outfile = new File(this.path + File.separator + filename);
        FileWriter outfileWriter;
        
        try {
            outfileWriter = new FileWriter(outfile);
            outfileWriter.write(data);
            outfileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(OutfileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
