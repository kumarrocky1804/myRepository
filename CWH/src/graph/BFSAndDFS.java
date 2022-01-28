package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class BFSAndDFS 
{
	/* We will create a directional graph represented by adjacency list 
	 * And perform BFS(Breadth First Traversal) 
	 */
	
	private ArrayList<ArrayList<Integer>> graph;
	
	public ArrayList<ArrayList<Integer>> getGraph()
	{
		return graph;
	}
	
	public BFSAndDFS(int vertices)
	{
		graph = new ArrayList<ArrayList<Integer>>(vertices);
		
		for(int i=0; i<vertices; i++)
		{
			graph.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int u, int v)
	{
		// add nodes to each other's adjacency list 
		graph.get(u).add(v);
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
	
	// Here we are not taking care of disconnected vertices
	public void BFS(int start)
	{
		if(start>=graph.size())
		{
			System.out.println("Start vertix not found.");
			return;
		}
		
		System.out.println();
		System.out.println("BFS is - ");
		
		boolean[] visited = new boolean[graph.size()];
		Queue<Integer> q = new LinkedList<Integer>();
		
		visited[start] = true;
		q.add(start);
		
		while(!q.isEmpty())
		{
			int temp = q.poll();
			System.out.print(temp + " -> ");
			
			ArrayList<Integer> LinkedVertices = graph.get(temp);
			
			Iterator<Integer> iterator = LinkedVertices.iterator();
			while(iterator.hasNext())
			{
				int next = iterator.next();
				if(!visited[next])
				{
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
	
	// DFS with care for disconnected nodes
	public void DFS()
	{
		boolean[] visited  = new boolean[graph.size()];
		System.out.println();
		System.out.println("DFS is - ");
		for(int i=0; i<graph.size(); i++)
		{
			if(!visited[i])
				DFSRecursive(i,visited);
		}
	}
	
	private void DFSRecursive(int start,boolean[] visited)
	{
		visited[start] = true;
		System.out.print(start + " -> ");
		
		ArrayList<Integer> linkedVertices = graph.get(start);
		
		Iterator<Integer> iterator = linkedVertices.iterator();
		
		while(iterator.hasNext())
		{
			int newStart = iterator.next();
			if(!visited[newStart])
				DFSRecursive(newStart, visited);
		}
	}
	
	public static void main(String[] args) {
		BFSAndDFS g = new BFSAndDFS(6);
		
		// Adding edges one by one
		/*g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);*/
		
		g.addEdge(5,2);
		g.addEdge(5,0);
		g.addEdge(2,3);
		g.addEdge(3,1);
		g.addEdge(4,0);
		g.addEdge(4,1);	
        
        g.print();
        
        //g.BFS(2);
        g.BFS(5);
        g.DFS(); 
	}
}
