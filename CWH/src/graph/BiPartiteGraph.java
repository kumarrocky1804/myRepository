package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteGraph 
{
	/* A Bipartite Graph is a graph whose vertices can be divided into two independent sets, 
	 * U and V such that every edge (u, v) either connects a vertex from U to V or a vertex 
	 * from V to U. In other words, for every edge (u, v), either u belongs to U and v to V, or 
	 * u belongs to V and v to U.
	 * 
	 * A bipartite graph is possible if the graph coloring is possible using two colors such that 
	 * vertices in a set are colored with the same color.
	 * 
	 * An acyclic graph is always Bi-partite.
	 * A cyclic graph with all cycles having even number of nodes are Bi-Partite.
	 * A cyclic graph with any cycle having odd number of nodes are not Bi-partite.
	 * For more info - https://www.geeksforgeeks.org/bipartite-graph/
	 */
	
	/* we are going to implement BFS with source as red color(1).
	 * And neighbors as blue(0), if we find neighbors that are already colored and of the same
	 * color as its source, then we return false, otherwise stay true.
	 */
	
	// assumed graph is connected by start vertexs
	 public static boolean isBiParitite(ArrayList<ArrayList<Integer>> graph, int start)
	 {
		 // initialize every vertex's color as colorless(-1)
		 int[] color = new int[graph.size()];
		 for(int i=0;i<graph.size();i++)
		 {
			 color[i] = -1;
		 }
		 
		 Queue<Integer> q = new LinkedList<Integer>();
		 
		 // Start BFS and color the starting/root vertex as red
		 q.add(start);
		 color[start] = 1;
		 
		 while(!q.isEmpty())
		 {
			 int currentRoot = q.poll();
			 ArrayList<Integer> linkedVertices = graph.get(currentRoot);
			 for(int linkedVertex: linkedVertices)
			 {
				 // if any vertex is colorless, color it with opposite color of root
				 if(color[linkedVertex]==-1)
				 {
					 q.add(linkedVertex);
					 color[linkedVertex] = 1-color[currentRoot];
				 }
				 // if vertex is colored with same color as root, return false
				 else if(color[linkedVertex]==color[currentRoot])
					 return false;
			 }
		 }
		 return true;
	 }
	 
	 public static void main(String[] args) {
		BFSAndDFS g = new BFSAndDFS(4);
		
		/*g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(1,0);
		g.addEdge(1,2);
		g.addEdge(2,1);
		g.addEdge(2,3);
		g.addEdge(3,0);
		g.addEdge(3,2);*/
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		
		g.print();
		
		System.out.println();
		System.out.println(isBiParitite(g.getGraph(), 0));
	}
}
