/*	Nicholas Calleja
 *	10/20/19
 * 	COSC 461: Intro into Artificial Intellegence
 * 
 * 	The Traveling Salesmen Problem
 */ 

/*	WARNING: There's a lot of comments here.
 * 	These comments were meant to help me
 *	as I went through this project. They
 *	explain mostly all the reasoning behind 
 *	the code. It's meant to help me keep
 *	track of everything. This was the first
 *	project that I've ever had of this scale.
 *	I had to learn how to use other classes 
 *	to my advantage, how to use a Interface,
 *	and even how to do graphics. I've never 
 *	made a GUI like this before, there's alot
 *	of work that went into this. Even if 
 *	it looks very sloppy and amatureish, 
 *	just remember this was my first project
 *	that has ever really made me push
 *	myself to the limit, and required this
 *	amount of work and thinking. This is
 *	the most I've ever learned from any
 *	programming project.
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
		
		// Main Menu Prompt
		System.out.println("< Welcome to the Main Menu >");
		System.out.println("-----------------------------------------------------------");
		System.out.println("How would you like to solve the Traveling Salesmen Problem?");
		System.out.println("(type the number correlating with the options)");
		System.out.println();
		System.out.println("1.) Uniform Cost ");
		System.out.println("2.) Uniform Cost without Crossing Paths");
		System.out.println("3.) Greedy Algorithm");
		
		// Reading from User Input
		Scanner keyb = new Scanner(System.in);
		int response = keyb.nextInt();
		
		// The Interface allows it to be able to use any Case
		Answer ans = null;
		
		// Used to keep track of which case was choosen
		String algo = null;
		
		// Switch Case to give the user a choice to which algorithm they want to use
		switch (response)	{
		
		// Case One: Uniform-Cost
		case 1:			
			algo = "Uniform Cost Search";
			ans = new UniformCost(map);
			break;
		// Case Two: Uniform-Cost without Crossing
		case 2:
			System.out.println("Not Done Yet");
			algo = "Uniform Cost Search without Crossing Paths";
			// ans = new UniformCostNoCross(map);
			break;
		// Case Three: Greedy Algorithm
		case 3:
			algo = "Greedy Algorithm";
			ans = new GreedyAlgo(map);
			break;
		default:
			System.out.println("Error: Invalid Response");
			System.out.println("Quitting...");
			System.exit(0);
		}
		
		System.out.println();
		
		// Beginning Timer
		long timer = System.currentTimeMillis();
		
		// Creating Tour by Computing the Path
		Tour mapTour = ans.ComputePath();
		
		// Presents Time and which algorithm you chose
		System.out.println();
		System.out.println("Time: " + (System.currentTimeMillis() - timer));
		System.out.println("Complete Tour Using " + algo + ": ");
		
		// Prints the tour
		mapTour.printTour();
		
		// Shows total distance of the Tour, with retricting the answer to 2 decimals
		System.out.println();
		System.out.println("Distance of Tour: " + String.format("%.2f", mapTour.getDist()));
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
				
			System.out.print("City: " + i + " ");
			city.get(i).cityLocation();
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
			
			MapInfo map = new MapInfo(cities, distances, n);
			
			MainMenu(map);
		}
		
		catch(FileNotFoundException e)	{
			
			errorPrompt();
		}
		
	}

}
