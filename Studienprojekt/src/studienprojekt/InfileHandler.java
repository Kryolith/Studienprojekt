/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studienprojekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class InfileHandler {
    
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    
    public InfileHandler(String filePath) {
        try {
            this.fileReader = new FileReader(filePath);
            this.bufferedReader = new BufferedReader(this.fileReader);
        } catch(FileNotFoundException ex) {
            Logger.getLogger(InfileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getNextLine() {
        String line = "";
        try {
            line = this.bufferedReader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(InfileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(line != null) {
            return line;
        }else{
            
            try {
                this.bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(InfileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return "";
        }
    }       
    
    public List<String> getNextLineArray() {
        List<String> result = new ArrayList();
        
        String current = this.getNextLine();
        
        if(!current.isEmpty())
            result.addAll(Arrays.asList(current.split(", ")));
        
        return result;
    }
}
