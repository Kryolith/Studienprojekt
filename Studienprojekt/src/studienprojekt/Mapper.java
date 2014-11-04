/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studienprojekt;

/**
 *
 * @author Sebastian
 */
public class Mapper {    
    
    Configuration config;
    
    public Mapper() {
        this.config = new Configuration();
    }
    
    public void initialize() {
        loadConfiguration();
    }
    
    public void loadConfiguration() {
        // if file exists lastest.properties
        // load latest.properties
        // else
        // generate default configuration
    }
}