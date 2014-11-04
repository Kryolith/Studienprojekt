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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Suchradius
        double radius = 0.001f;
        
        // Initialisiere MapHandler mit Api-Link
        // MapHandler mh = new MapHandler("http://openstreetmap.org/api");
        
        // Initialisiere InfileHandler mit Dateipfad des Testdatensatz
        InfileHandler ifh = new InfileHandler("Testdatensatz/Data.txt");
        
        // Initialisiere OutfileHandler mit Dateipfad des Ausgabeordners
        // OutfileHandler ofh = new OutfileHandler("Ausgabe0001/");
        
        // Lade erste Zeile um die Anzahl der Datensätze zu ermitteln
        int datacount = Integer.parseInt(ifh.getNextLineArray().get(0));

        // Durchlaufe Datensätze und lege Map-Data-Files an
        // int lastLineId = 0;
        
        for(int i = 0; i < datacount; i++) {
            
            // Rufe nächste Zeile vom Infilehandler ab
            List<String> line = ifh.getNextLineArray();
            
            // Parse Id aus String
            int currentLineId = Integer.parseInt(line.get(0));
            
             /*
            
            // Falls es sich um eine neue Id (Neuer Mappunkt) handelt...
            if(currentLineId != lastLineId) {
                
                // Lade Mapdaten im Umkreis um den Punkt runter
                String mapdata = mh.getMapDataRadius(Double.parseDouble(line.get(2)), Double.parseDouble(line.get(1)), radius);
                
                // Und mithilfe des Outfilehandlers in einer eigenen Datei speichern
                ofh.saveData(mapdata, line.get(0) + ".mapdata.xml");
                
                // Update auf neuste Id
                lastLineId = currentLineId;
            }*/
        }   
    } 
}
