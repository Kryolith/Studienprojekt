/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studienprojekt;

import java.util.ArrayList;
import java.util.List;
import studienprojekt.osm.OSMCoordinate;
import studienprojekt.osm.OSMMap;
import studienprojekt.rules.Rule;

/**
 *
 * @author Sebastian
 */
public class RuleManager {
    
    private List<Rule> rules;
    
    public RuleManager() {
        this.rules = new ArrayList();
    }
    
    public void registerRule(Rule rule) {
        this.rules.add(rule);
    }
    
    public void handle(OSMMap map, OSMCoordinate coordinate, SpaceUsageRule sur) {
        
        for(Rule rule : rules) {
            if(rule.handles(sur)) rule.execute(map, coordinate, sur);
        }
    }
    
}
