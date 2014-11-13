package studienprojekt.rules;

import studienprojekt.rules.data.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import studienprojekt.SpaceUsageRule;
import studienprojekt.osm.OSMCoordinate;
import studienprojekt.osm.OSMMap;
import studienprojekt.osm.OSMWay;


public class Rule {
    
    private Map<String, Data> data;
    
    public Rule() {
        this.data = new HashMap();
    }
    
    public void addInformation(Data data) {
        this.data.put(data.getName(), data);
    }
    
    public List<OSMWay> handle(OSMMap map, OSMCoordinate coordinate, SpaceUsageRule sur) {
        // Initialisiere Ergebnisvariable
        List<OSMWay> result = new ArrayList();
        
        
        
        
        return result;
    }
    
    
    
    
}
