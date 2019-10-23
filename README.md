# Traveling-Salesmen-Problem
This is my attempt to get the best estimate for "The Traveling Salesmen Problem"

- We will be using multiple Algorithms to do the Traveling Salesmen Problem. 
- For each Algorithm we'll keep track of the total amount of tours tested, as well as the runtime.
- Report the Shortest tour and graph it. (For each Algorithm)

Due by October 28th:

- 1.) Uniform Cost
- 2.) Uniform Cost except without crossing paths
- 3.) Greedy Algorithm (Choosing the Shortest Paths)

Things to Do:

- 1.) Read from the File, store locations into an array inside of an array.
    - int[][] locations
    - The first [] stores the city, city 0, then the second [] stores the coordinates
- 2.) Now, store all of the possible distances in an array inside of an array.
    - int[][] distances
    - The first [] stores the city, and the second [] represents the city that we're trying to reach
    - [0] will store the distances from that city to every other city
- 3.) Create the Path-Way class to represent a path to be taken, the Path-Way will be a node
- 4.) Path Class will have the Queue that stores all of the paths
- 5.) Start with Greedy Algo. to gain an understanding of how this should work
- 6.) Create the Methods,
    - a.) Uniform Cost 
    - b.) Uniform Cost without crossing Paths
    - c.) Greedy Algorithm
- 7.) Comense Testing (Start with smaller data for Uniform Cost 1 & 2)
- 8.) Finish Class Assignment Handin:
    - a.) Explain what you learned.
    - b.) Include actual Graphs of the tours
    - c.) Include Tables where we compare the Algorithms

Due by December 2nd:

- 4.) Genetic Algorithm
- 5.) Simulated Annealing
