package graph;

import java.util.ArrayList;
import java.util.Stack;

/* The problem is to find the longest distance from source to another vertex in a weighted DAG
 * (Directed Acyclic Graph)
 * 
 * The algo we will follow is - 
 * 1. Run topological sort on the graph
 * 2. Initialize distance from source to source as 0, and to other vertices as "min"
 * 3. If (distance from reaching source to that current vertex) < (dist from source to vertex in
 * 			topological order) + (dist from top vertex to that vertex) , then change the dist value
 * 			to later
 * 
 * For more info - https://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
 * 
 * Additional exercise is to print the path
 */
class vertex
{
	// value of that vertex
	private int value;
	// distance from other vertex to this vertex (weight of edge)
	private int distTo;
	
	public vertex(int value, int distTo)
	{
		this.value = value;
		this.distTo = distTo;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public int getDist()
	{
		return this.distTo;
	}
}

public class LongestDistanceInDAG 
{
	private ArrayList<ArrayList<vertex>> graph;
	
	public LongestDistanceInDAG(int numOfVertices)
	{
		graph = new ArrayList<ArrayList<vertex>>(numOfVertices);
		
		for(int i=0; i<numOfVertices; i++)
			graph.add(new ArrayList<vertex>());
	}
	
	public void addEdge(int u, int v, int d)
	{
		graph.get(u).add(new vertex(v,d));
	}
	
	public void topSortRec(int start, boolean[] visited, Stack<Integer> stack)
	{
		visited[start] = true;
		
		ArrayList<vertex> linkedVertices = graph.get(start);
		for(vertex linkedVertex: linkedVertices)
		{
			if(!visited[linkedVertex.getValue()])
				topSortRec(linkedVertex.getValue(), visited,stack);
		}
		
		stack.push(start);
	}
	
	public int[] longestDist(int source, ArrayList<ArrayList<Integer>> path)
	{
		// create distance array which will store longest distances
		int[] dist = new int[graph.size()];
		
		// topological sort
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[6];
		
		for(int i=0; i<graph.size(); i++)
		{
			if(!visited[i])
				topSortRec(i,visited,stack);
		}
		
		// now stack has all the vertices in topological sorted order
		/*while(!stack.isEmpty())
		{
			System.out.println(stack.pop() + " -> ");
		}*/
		
		// step 2
		for(int i=0; i<graph.size(); i++)
		{
			dist[i] = Integer.MIN_VALUE;
		}
		
		dist[source] = 0;
		
		// step 3
		
		while(!stack.isEmpty())
		{
			int topVertex = stack.pop();
			// Vertex before source in topological order should be left as it is
			if(dist[topVertex] != Integer.MIN_VALUE)
			{
				// update all distances if reaching from this node is more than it already is
				for(int i=0; i<graph.get(topVertex).size(); i++)
				{
					/* For example if currently source is 1, and dist[2] = -1
					 *  Now if(dist[2]<dist[1] + dist[1to2])
					 *  	then dist[2] should be dist[1] + dist[1to2] as it is longer path
					 *  But it should be confirmed that 1 comes before 2 always, which is done
					 *  by topological sorting
					 */
					int index = graph.get(topVertex).get(i).getValue();
					if(dist[graph.get(topVertex).get(i).getValue()] < dist[topVertex] +
							graph.get(topVertex).get(i).getDist())
					{
						dist[graph.get(topVertex).get(i).getValue()] = dist[topVertex] +
								graph.get(topVertex).get(i).getDist();	
						path.get(graph.get(topVertex).get(i).getValue()).add(topVertex);
					}
				}
			}
		}
		
		return dist;
	}
	
	public void print()
	{
		for(int i=0; i<graph.size(); i++)
		{
			System.out.println();
			System.out.print(" list of " + i + " - ");
			for(int j=0; j<graph.get(i).size(); j++)
			{
				System.out.print("(" + graph.get(i).get(j).getValue() + "," +
						graph.get(i).get(j).getDist() + ") -> ");
			}
		}
	}
	
	public static void main(String[] args) {
		int graphSize = 6;
		LongestDistanceInDAG g = new LongestDistanceInDAG(graphSize);
		g.addEdge(0, 1, 5);
	    g.addEdge(0, 2, 3);
	    g.addEdge(1, 3, 6);
	    g.addEdge(1, 2, 2);
	    g.addEdge(2, 4, 4);
	    g.addEdge(2, 5, 2);
	    g.addEdge(2, 3, 7);
	    g.addEdge(3, 5, 1);
	    g.addEdge(3, 4, -1);
	    g.addEdge(4, 5, -2);
	    
	    g.print();
	    
	    int[] distance = new int[graphSize];
	    ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>(graphSize);
	    for(int i=0; i<graphSize; i++)
	    	pathList.add(new ArrayList<Integer>());
	    int source = 1;
	    distance=g.longestDist(source,pathList);
	    
	    System.out.println();
	    for(int i=0; i<graphSize; i++)
	    {
	    	if(distance[i] == Integer.MIN_VALUE)
	    		System.out.println(source + " to " + i + " path not possible");
	    	else if(distance[i] == 0)
	    	{
	    		System.out.println(source + " is the source ");
	    	}
	    	else
	    	{
	    		System.out.println("Distance from " + source + " to " + i + " is - " + 
	    				distance[i]);
	    		System.out.print("The path is " + source + " -> ");
	    		for(int j=0; j<pathList.get(i).size();j++)
	    		{
	    			if(pathList.get(i).get(j) != source)
	    				System.out.print(pathList.get(i).get(j) + " -> ");
	    		}
	    			
	    		System.out.print(i);
	    		System.out.println();
	    	}
	    }
	}
}
