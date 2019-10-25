// This is the City Class, contains the data for a City
public class City {
	
	// Vars: X and Y Coordinates, and the City Name
	int x, y, cityName;
	
	// Constructor for a City
	public City(int x, int y, int cityName)	{
		
		this.x = x;
		this.y = y;
		this.cityName = cityName;
	}
	
	// Prints the Cities Location
	public void cityLocation()	{
		
		System.out.println("(" + x + ", " + y + ")");
	}
	
	// Returns X Coordinate
	public int getX()	{
		
		return x;
	}
	
	// Returns Y Coordinate
	public int getY()	{
		
		return y;
	}
	
	// returns the City Name
	public int getCityName()	{
		
		return cityName;
	}
	
	// Sets the X Coordinate
	public void setX(int x)	{
		
		this.x = x;
	}
	
	// Sets the Y Coordinate
	public void setY(int y)	{
		
		this.y = y;
	}
	
	// Sets the City Name
	public void setCityName(int cityName)	{
		
		this.cityName = cityName;
	}
}
