package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class DetectCycleInDirectedGraph 
{
	/* To detect cycle in directed graph,
	 * we keep track of all the nodes getting visited in the current loop of depth.
	 * And if we are back to any of the nodes that we visited, we found a cycle
	 */
	
	public static boolean detectCycleRecursive(ArrayList<ArrayList<Integer>> graph,int start,
			boolean[] visited, boolean[] currentLoop)
	{
		
		// if this node is visited in current loop, then there is a cycle
		if(currentLoop[start])
		{
			System.out.println(" Again at - " + start);
			return true;
		}
		
		// if this node is visited but not in current loop, there is no point in further visiting it
		if(visited[start])
			return false;
		
		System.out.println("Visiting - " + start);
		
		// If visited for first time -
		visited[start] = true;
		currentLoop[start] = true;
		
		ArrayList<Integer> linkedVertices = graph.get(start);
		for(int i: linkedVertices)
		{
			if(detectCycleRecursive(graph, i, visited, currentLoop))
				return true;
		}
		
		// If no cycle is detected, make sure that current node is no more in current loop
		currentLoop[start] = false;
		return false;
	}
	
	public static void detectCycle(ArrayList<ArrayList<Integer>> graph)
	{
		boolean[] visited = new boolean[graph.size()];
		boolean[] currentLoopVertices = new boolean[graph.size()];
		
		for(int i=0; i<graph.size(); i++)
		{
			if(detectCycleRecursive(graph,i,visited,currentLoopVertices))
			{
				System.out.println("cycle detected");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		BFSAndDFS g = new BFSAndDFS(4);
		
		// Adding edges one by one
		/*g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);*/
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        
        g.print();
        
        detectCycle(g.getGraph());
	}
}
