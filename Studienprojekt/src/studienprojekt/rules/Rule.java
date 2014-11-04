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
public abstract class Rule {
    
    // Bekommt die aktuelle SpaceUsageRule übergeben und gibt zurück, ob diese behandelt werden kann
    public abstract boolean handles(SpaceUsageRule sur);
    
    // Bekommt den API-Handler, die aktuelle Koordinate und die aktuelle SpaceUsageRule übergeben
    // Rückgabe: Liste mit gefundenen Wegen
    public abstract List<OSMWay> handle(OSMMap map, OSMCoordinate coordinate, SpaceUsageRule sur);
    
    // Gibt das Tiefenlevel dieser Regel zurück
    // 1: Standardregel
    // 2: Allgemeine Regel
    // 3: Spezielle Regel
    public abstract int getLevel();
}
