package studienprojekt.osm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class OSMWay extends OSMElement 
{
	private List<OSMNode> wayComponents = new ArrayList<OSMNode>();
	private HashMap tags;
	
	public OSMWay(String id)
	{
		super(id);	
	}

	public List<OSMNode> getWayComponents() 
	{
		return wayComponents;
	}

	public void setWayComponents(List<OSMNode> wayComponents) 
	{
		this.wayComponents = wayComponents;
	}

	public HashMap getTags() 
	{
		return tags;
	}

	public void setTags(HashMap tags) 
	{
		this.tags = tags;
	}
	
	@Override
	public String toString()
	{
		String wayDescription = "\n\nWAY WITH ID: " + super.getId() + "\n";
		wayDescription += "Nodes contained within this way:\n";
		String wayNodeIds = "";
		String allTags = "";
		Set<String> tagKeys;
;		
		for (OSMNode wayComp : wayComponents)
		{
			String id = wayComp.getId();
			wayNodeIds += "ref = " + id + "\n";
		}
		
		wayDescription += wayNodeIds + "Available Tags for this way:\n";		
		
		if (tags != null)
		{	
			tagKeys = tags.keySet();
			for(String key : tagKeys)
			{
				allTags += " " + key + " = " + tags.get(key) + "\n";
			}
		}
		
		wayDescription += allTags;
		
		return wayDescription;
	}
	
}
