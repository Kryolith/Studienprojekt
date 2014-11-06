package studienprojekt;

import java.util.ArrayList;
import java.util.List;
import studienprojekt.osm.OSMCoordinate;
import studienprojekt.osm.OSMMap;
import studienprojekt.osm.OSMWay;
import studienprojekt.rules.Rule;

public class RuleManager {
    
    private List<Rule> rules;
    
    public RuleManager() {
        this.rules = new ArrayList();
    }
    
    public void registerRule(Rule rule) {
        this.rules.add(rule);
    }
    
    public List<OSMWay> handle(OSMMap map, OSMCoordinate coordinate, SpaceUsageRule sur) {
        
        for(Rule rule : rules) {
            if(rule.handles(sur)) {
                return rule.handle(map, coordinate, sur);
            }
        }
        return null;
    }
    
}
