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

	public static void errorPrompt()	{
		
		System.out.println("Error: File Not Found");
		System.out.println("- Check if the File is in the correct folder");
	}
	
	// Prints Map
	public static void printMap(int[][] graph)	{
			
		for(int i = 0; i < graph.length; i++)	{
				
			System.out.println("City: "+ i + " (" + graph[i][0] + ", " + graph[i][1] + ")");
		}
	}
	
	public static void main(String[] args) {
				
		// Getting the number of cities
		System.out.println("How many Cities do you want to compute?");
		Scanner keyb = new Scanner(System.in);
		int size = keyb.nextInt();
		
		// Reading from the File "Data-Set-All.txt"
		File f = new File("Data-Set");
		Scanner inFile;
		
		try { 
			
			inFile = new Scanner(f);
			
			CityInfo map = new CityInfo(size);
			
			int count = 0;
			
			while(count < size)	{
				
				for(int i = 0; i < size; i++)	{
					
					int x = inFile.nextInt();
					int y = inFile.nextInt();
					
					map.locations[i][0] = x;
					map.locations[i][1] = y;
				}
				
				count++;
			}
			
			printMap(map.locations);
		}
		
		catch(FileNotFoundException e)	{
			
			errorPrompt();
		}
		
	}

}
