/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studienprojekt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class Configuration {
    
    Properties properties;
    
    public Configuration(String filepath) {
        properties = new Properties();
        load(filepath);
    }
    
    public Configuration() {
        properties = new Properties();
    }
    
    
    public void load(String filepath) {
        BufferedInputStream stream;
        try {
            stream = new BufferedInputStream(new FileInputStream(filepath));
            properties.load(stream);
            stream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Mapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object get(Object key) {
        return this.properties.get(key);
    }
    
    public Object get(Object key, Object defaultObject) {
        return this.properties.getOrDefault(key, defaultObject);
    }
    
}
