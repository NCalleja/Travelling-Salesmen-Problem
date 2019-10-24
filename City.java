/* 	This is the City Class
	It contains all the info for a city
*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class City {

	int x, y, cityName;
	
	public City(int x, int y, int cityName)	{
		
		this.x = x;
		this.y = y;
		this.cityName = cityName;
	}
	
	public int getX()	{
		
		return x;
	}
	
	public int getY()	{
		
		return y;
	}
	
	public int getCityName()	{
		
		return cityName;
	}
	
	public void setX(int x)	{
		
		this.x = x;
	}
	
	public void setY(int y)	{
		
		this.y = y;
	}
	
	public void setCityName(int cityName)	{
		
		this.cityName = cityName;
	}
	
	public String cityCoord()	{
		
		return "(" + x + ", " + y + ")";
	}
}
