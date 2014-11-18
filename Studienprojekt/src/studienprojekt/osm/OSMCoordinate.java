package studienprojekt.osm;


public class OSMCoordinate 
{
	private double longitude;
	private double latitude;
	
	public OSMCoordinate(double longitude, double latitude)
	{
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public double getLongitude() 
	{
		return longitude;
	}
	public void setLongitude(double longitude) 
	{
		this.longitude = longitude;
	}
	public double getLatitude() 
	{
		return latitude;
	}
	public void setLatitude(double latitude) 
	{
		this.latitude = latitude;
	}
        
        public double distanceTo(OSMCoordinate coordinate) {
            
            int r = 6371;
            
            double rad_lat_1 = Math.toRadians(this.latitude);
            double rad_lat_2 = Math.toRadians(coordinate.getLatitude());
            
            double delta_lat = Math.toRadians(this.latitude - coordinate.getLatitude());
            double delta_lon = Math.toRadians(this.longitude - coordinate.getLongitude());
            
            double a = Math.pow(Math.sin(delta_lat / 2), 2)
                    + Math.cos(rad_lat_1) * Math.cos(rad_lat_2) 
                    * Math.pow(Math.sin(delta_lon), 2);
            
            double c = Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
            
            return r * c;
        }
        
        // Exakte Distanzmessung in km, die auch die unterschiedlichen Längengradabstände 
        // in Abhängigkeit vom Breitengrad berücksichtigt (Äquator: 111km, Nordpol: 0km)
        public double exactDistanceTo(OSMCoordinate coordinate)
        {
            double a2 = Math.pow(coordinate.getLatitude() * 111.31832 - this.latitude * 111.31832, 2f);
            
            double coor_lon = coordinate.getLongitude() * 111.31832 * Math.cos(coordinate.getLatitude());
            double this_lon = this.longitude * 111.31832 * Math.cos(this.latitude);
            
            double b2 = Math.pow(coor_lon - this_lon, 2f);
            return Math.sqrt(a2 + b2);
        }        
              
        @Override
        public String toString() {
            return "( " + this.longitude + " | " + this.latitude + " )";
        }
	
	
}
