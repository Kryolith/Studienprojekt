package studienprojekt;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import studienprojekt.osm.OSMCoordinate;
import studienprojekt.osm.OSMMap;
import studienprojekt.osm.OSMParser;

public class Mapper {    
    
    Configuration config;
    RuleManager ruleManager;
    
    public Mapper() {
        this.config = new Configuration();
        this.ruleManager = new RuleManager();
    }
    
    public void initialize() {
        // Lade Configuration
        loadConfiguration();
        
        // Adde zum testen ein paar rules ( eine )
        // this.ruleManager.registerRule(new DefaultRule());
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
        
        //Initialisiere OutfileHandler mit Dateipfad des Ausgabeordners
        OutfileHandler ofh = new OutfileHandler("result/");
        
        // Lade erste Zeile um die Anzahl der Datensätze zu ermitteln
        int datacount = Integer.parseInt(ifh.getNextLineArray().get(0));
        
        // Limitiere datacount für Testzwecke
        datacount = datacount > 1 ? 1 : datacount;
        
        // OSMParser-Objekt erzeugen, damit mit der Map-API kommuniziert werden kann
        OSMParser osmParser = new OSMParser();
        
        // Iteriere durch alle Zeilen der Eingabedatei und behandel die eingetragenen SURs
        for(int i = 0; i < datacount; i++) {
            
            // Erstelle und initialisiere ein Result-Objekt für das Ergebnis dieser Zeile
            Result result = new Result();
            
            // Lade nächste Zeile aus dem Infilehandler als String-Array
            List<String> line = ifh.getNextLineArray();
            
            // Setze name im Ergebnisobjekt (Name Feld 0 der Zeile)
            result.setName(line.get(0));
            
            // Erstelle ein OSMCoordinate-Objekt mit den Koordinaten aus der Zeile
            OSMCoordinate surCoordinate = new OSMCoordinate(Double.parseDouble(line.get(2)), Double.parseDouble(line.get(1)));
            
            // Setze Koordinaten im Ergebnisobjekt
            result.setOSMCoordinate(surCoordinate);
            
            // Parse die SpaceUsageRule aus Feld 3 der Zeile
            SpaceUsageRule currentSur = SpaceUsageRule.parseSpaceUsageRule(line.get(3));
            
            // AUch zum Ergebnis-Objekt hinzufügen
            result.setSpaceUsageRule(currentSur);
            
            // Erstelle OSMMap-Objekt, dass die Gegend um die Koordinaten beschreibt
            OSMMap areaToCheck = null;
                        
            // Füllen der Map mit Daten
            try {
                areaToCheck = osmParser.getOSMMap(surCoordinate, 0.001);
            } catch (ParserConfigurationException | SAXException | IOException ex) {
                System.out.println(ex);
            }
            
            // Falls erfolgreich weiter (ansonsten sollte eh ein Fehler ausgegeben worden sein, evtl ist die Bedingung hier überflüssig?!?)
            if(areaToCheck != null) {
                try {
                    // Gib die aktuellen Daten an den RegelManager weiter und speicher die Rückgabe im result-Objekt
                    result.setOSMWays(this.ruleManager.handle(areaToCheck, surCoordinate, currentSur));
                } catch (Exception ex) {
                    Logger.getLogger(Mapper.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                // Schlussendlich wird das Ergebnis noch abgespeichert über den OutfileHandler
                ofh.saveData(result);
            }
        }        
    }
}