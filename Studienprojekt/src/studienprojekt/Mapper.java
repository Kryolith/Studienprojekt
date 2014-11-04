/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studienprojekt;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import studienprojekt.osm.OSMCoordinate;
import studienprojekt.osm.OSMMap;
import studienprojekt.osm.OSMParser;

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
    
    public void run() {
        // Initialisiere InfileHandler mit Dateipfad des Testdatensatz aaa
        InfileHandler ifh = new InfileHandler("Testdatensatz/Data.txt");
        
        // Initialisiere OutfileHandler mit Dateipfad des Ausgabeordners
        //OutfileHandler ofh = new OutfileHandler("Ausgabe0001/");
        
        // Lade erste Zeile um die Anzahl der Datensätze zu ermitteln
        int datacount = Integer.parseInt(ifh.getNextLineArray().get(0));
        
        // Rufe nächste Zeile vom Infilehandler ab
        List<String> line = ifh.getNextLineArray();
        
    	/* Ab hier Martins Teil */
        // OSMParser erzeugen
        OSMParser osmParser = new OSMParser();
        
        // Lege OSMCoordinate aus den Daten der Textfile an
    	OSMCoordinate surCoordinate = new OSMCoordinate(Double.parseDouble(line.get(1)), Double.parseDouble(line.get(2)));
        
        System.out.println(surCoordinate);
        
    	OSMMap areaToCheck = null;
        
        try {
            areaToCheck = osmParser.getOSMMap(surCoordinate, 0.1);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex);
        }

        System.out.println("TESTAUSGABE: auslesen des Inhalts des generierten OSMMap-Objekts:");
        System.out.print(areaToCheck);
        /* Martins Teil Ende */
    }
}