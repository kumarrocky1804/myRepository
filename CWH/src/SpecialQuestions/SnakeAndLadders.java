package SpecialQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadders 
{
	/* Given is the array of source and destination nodes of various nodes in an snake and ladders
	 * game. like if move[2] = 27, there is a ladder from 2 to 27. For others move[i] = -1.
	 * 
	 * Find the minimum number of moves from source (0) to destination (29). You have full control
	 * over outcome of dice (1 to 6)
	 * 
	 * It is also similar to shortest path problem in graphs.
	 */
	
	static class edge
	{
		int vertex; // destination vertex
		int dist; // distance from source or number of rolls of dice in which we can get there
	}
	
	static int minMoves(int[] move, int dest)
	{
		// BFS like algorithm
		boolean[] visited = new boolean[dest];
		Queue<edge> q = new LinkedList<edge>();
		
		// Create 1st edge and mark its vertex as visited
		edge start = new edge();
		start.vertex=0;
		start.dist=0;
		visited[start.vertex] = true;
		q.add(start);
		
		// RUN BFS for adjacent vertices, here adjacent vertices are next 6 cells of game
		// as the outcome of dice can be 1 to 6
		while(!q.isEmpty())
		{
			start = q.poll();
			
			// if we have the destination, we are done
			if(start.vertex == dest-1)
				break;
			
			// if not, then calculate the result of next moves and find adjacent vertices
			// add them to queue
			for(int i=start.vertex+1; i<= (start.vertex+6)&& i<dest; i++)
			{
				if(!visited[i])
				{
					edge newEdge = new edge();
					newEdge.dist = start.dist+1;
					visited[i] = true;
					
					// check if there is any snake or ladder
					if(move[i] != -1)
						newEdge.vertex = move[i];
					else
						newEdge.vertex = i;
					// above code means that is you can go till 2 then neighbour is 2
					// if there is a ladder from 2 to 22, then neighbour will be 22
					q.add(newEdge);
				}
			}
		}
		return start.dist;
	}
	
	public static void main(String[] args) {
		int n = 30; // no of cells in game
		int[] moves = new int[n];
		for(int i=0; i<n; i++)
			moves[i] = -1;
		
		// Ladders
        /*moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;
 
        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;*/
		//moves[18] = 24;
        
        System.out.println("Minimum moves required is -" + minMoves(moves, n));
	}
}
