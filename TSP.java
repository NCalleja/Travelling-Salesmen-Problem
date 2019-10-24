/*	Nicholas Calleja
 *	10/20/19
 * 	COSC 461: Intro into Artificial Intellegence
 * 
 * 	The Traveling Salesmen Problem
 */ 

import java.util.*;
import java.lang.*;
import java.io.*;

public class TSP {
	
	// Introduction Prompt
	public static void firstPrompt() {
			
		System.out.println("< Welcome to Nicholas Calleja's Traveling Salesmen Solutions >");
		System.out.println("--------------------------------------------------------------");
		System.out.println();
	}

	// Main Menu
	public static void MainMenu(MapInfo map)	{
		
		System.out.println("< Welcome to the Main Menu >");
		System.out.println("-----------------------------------------------------------");
		System.out.println("How would you like to solve the Traveling Salesmen Problem?");
		System.out.println("(type the number correlating with the options)");
		System.out.println();
		System.out.println("1.) Uniform Cost ");
		System.out.println("2.) Uniform Cost without Crossing Paths");
		System.out.println("3.) Greedy Algorithm");
		
		Scanner keyb = new Scanner(System.in);
		int response = keyb.nextInt();
		
		Answer ans = null;
		
		switch (response)	{
		
		case 1:
			// cities.UniformCost();
			break;
		case 2:
			// cities.UniCostNoCross();
			break;
		case 3:
			ans = new GreedyAlgo(map);
			break;
		default:
			System.out.println("Error: Invalid Response");
			System.out.println("Quitting...");
			System.exit(0);
		}
	}
	
	// Error Prompt
	public static void errorPrompt()	{
		
		System.out.println("Error: File Not Found");
		System.out.println("- Check if the File is in the correct folder");
	}
	
	// Prints City Coordinates
	public static void printCityCoord(List<City> city, int n)	{
		
		System.out.println();
		System.out.println("Cities: Name & Location");
		
		for(int i = 0; i < n; i++)	{
				
			System.out.println("City: " + i + " " + city.get(i).cityCoord());
		}
		
		System.out.println();
	}
	
	// Calculating Distance
	public static double distance(City here, City there)	{
		
		double x = there.getX() - here.getX();
		double y = there.getY() - here.getY();
		
		double d = Math.sqrt( (x*x) + (y*y) );
		d = Math.abs(d);
		
		return d;
	}
	
	// Printing Matrix of Distances
	public static void printDistances(double[][] dist)	{
		
		System.out.println("Distances of Cities: ");
		System.out.println();
		
		for (int i = 0; i < dist.length; i++)	{
			
			for (int j = 0; j < dist.length; j++)	{
				
				System.out.print(dist[i][j] + " ");
			}
		
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		firstPrompt();
		
		// Getting the number of cities
		System.out.println("How many Cities do you want to compute?");
		Scanner keyb = new Scanner(System.in);
		int n = keyb.nextInt();
		
		// Reading from the File "Data-Set-All.txt"
		File f = new File("Data-Set");
		Scanner inFile;
		
		try { 
			
			inFile = new Scanner(f);
			
			// Creating a list of Cities
			List<City> cities = new ArrayList<City>();
			
			for (int i = 0; i < n; i++)	{
				
				int x = inFile.nextInt();
				int y = inFile.nextInt();
				
				cities.add(new City(x, y, i));
			}
			
			// Testing Cities
			printCityCoord(cities, n);
			
			// Creating list of Distances
			double[][] distances = new double[n][n];
			
			for (int i = 0; i < n; i++)	{
				
				for (int j = 0; j < n; j++)	{
					
					distances[i][j] = distance(cities.get(i), cities.get(j));
				}
			}
			
			// Testing Distances
			// printDistances(distances);
			
			MapInfo map = new MapInfo(cities, distances, n);
			
			MainMenu(map);
		}
		
		catch(FileNotFoundException e)	{
			
			errorPrompt();
		}
		
	}

}
