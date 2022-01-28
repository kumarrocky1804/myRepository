package graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort 
{
	/* Linear ordering of vertices of DAG (Directed Acyclic Graph) in which every edge(u,v),
	 * the vertex u should be before v. i.e. the direction of edges should be from u to v.
	 * Topological sort is not unique.
	 * Example - 5,4,2,3,1,0 (5 should be before 4, 2 before 3 before 1 etc.)
	 * More info - https://www.geeksforgeeks.org/topological-sorting/
	 * 
	 * It can be used in building libraries to make sure that the dependent codes get compiled
	 * only after the code on which it is depended upon.
	 */
	
	public static void topSortRec(ArrayList<ArrayList<Integer>> graph, int start,
			boolean[] visited, Stack<Integer> stack)
	{
		// mark this visited
		visited[start] = true;
		
		ArrayList<Integer> linkedVertices = graph.get(start);
		for(int linkedVertex: linkedVertices)
		{
			// first put all unvisited linked vertices into the stack
			if(!visited[linkedVertex])
			{
				topSortRec(graph,linkedVertex,visited,stack);
			}
		}
		
		// push this into stack only after the linked vertices are already there, so that this 
		// gets printed before them
		stack.push(start);
	}
	
	public static void topSort(ArrayList<ArrayList<Integer>> graph)
	{
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[graph.size()];
		
		for(int i=0; i<graph.size(); i++)
		{
			if(!visited[i])
				topSortRec(graph,i,visited,stack);
		}
		
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop() + " -> ");
		}
	}
	
	public static void main(String[] args) {
		BFSAndDFS g = new BFSAndDFS(5);
		
		// For pictorial representation of graph
		// https://www.geeksforgeeks.org/topological-sorting/
		/*g.addEdge(5,2);
		g.addEdge(5,0);
		g.addEdge(2,3);
		g.addEdge(3,1);
		g.addEdge(4,0);
		g.addEdge(4,1);	*/
		
		g.addEdge(1, 0);
		g.addEdge(2, 0);
		g.addEdge(3, 0);
		g.addEdge(3, 4);
        
        g.print();
        System.out.println();
        topSort(g.getGraph());
	}
}
