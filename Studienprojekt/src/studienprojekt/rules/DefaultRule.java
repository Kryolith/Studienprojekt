/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studienprojekt.rules;

import java.util.List;
import studienprojekt.SpaceUsageRule;
import studienprojekt.osm.OSMCoordinate;
import studienprojekt.osm.OSMMap;
import studienprojekt.osm.OSMWay;

/**
 *
 * @author Sebastian
 */
public class DefaultRule extends Rule { 
    
    private final int level = 1;
    
    // Gilt für jede Regel und gibt daher immer `true` zurück
    @Override
    public boolean handles(SpaceUsageRule sur) {
        return  true;
    }

    // Finde den nächstbesten Weg und gebe diesen zurück
    @Override
    public List<OSMWay> execute(OSMMap map, OSMCoordinate coordinate, SpaceUsageRule sur) {
        throw new UnsupportedOperationException("Execute ist noch nicht implementiert");
    }

    // Regel ist eine Standardregel (1)
    @Override
    public int getLevel() {
        return this.level;
    }
    
}
