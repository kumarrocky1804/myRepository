package graph;

import java.util.ArrayList;

public class BasicGraph 
{
	/* We will create a undirectional graph with following representation in adjacency list - 
	 *    0 - 1 - 2
	 *    | / |   |
	 *    4 - 3 - |
	 */
	
	private ArrayList<ArrayList<Integer>> graph;
	
	public ArrayList<ArrayList<Integer>> getGraph()
	{
		return graph;
	}
	
	public BasicGraph(int numOfNodes)
	{
		graph = new ArrayList<ArrayList<Integer>>(numOfNodes);
		
		for(int i=0; i<numOfNodes; i++)
		{
			graph.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int u, int v)
	{
		// add nodes to each other's adjacency list 
		graph.get(u).add(v);
		graph.get(v).add(u);
	}
	
	//O(Vertices + edges)
	public void print()
	{
		for(int i=0; i<graph.size(); i++)
		{
			System.out.println();
			System.out.print(" list of " + i + " - ");
			for(int j=0; j<graph.get(i).size(); j++)
			{
				System.out.print(graph.get(i).get(j)+ " -> ");
			}
		}
	}
	
	public static void main(String[] args) {
		BasicGraph graph = new BasicGraph(5);
		
		// Adding edges one by one
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        graph.print();
 
	}
}
