package graph;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraph 
{
	/* To detect cycle in undirected graph,
	 * we keep track of the parent/previous node of current node and if the next node 
	 * in the DFS is any other node than parent, we found a cycle
	 * 
	 * If we find parent node, its fine because in undirected graph, the nodes are connected
	 * both ways.
	 */
	
	public static boolean detectCycleRecursive(ArrayList<ArrayList<Integer>> graph,int start,
			boolean[] visited, int prev)
	{
System.out.println("Visiting - " + start);
		
		// mark current node as visited
		visited[start] = true;
		
		ArrayList<Integer> linkedVertices = graph.get(start);
		for(int i: linkedVertices)
		{
			// if current node is not visited, then continue DFS
			if(!visited[i])
			{
				if(detectCycleRecursive(graph, i, visited, start))
					return true;
			}
			// if current node is visited but not the prev node
			else if(i!=prev)
				return true;
		}
		return false;
	}
	
	public static void detectCycle(ArrayList<ArrayList<Integer>> graph)
	{
		boolean[] visited = new boolean[graph.size()];
		
		for(int i=0; i<graph.size(); i++)
		{
			if(!visited[i])
			{
				// initialsize prev as -1, for first node
				if(detectCycleRecursive(graph,i,visited,-1))
				{
					System.out.println("cycle detected");
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BasicGraph g = new BasicGraph(4);
        
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(0,2);
		
        g.print();
        
        detectCycle(g.getGraph());
	}
}
