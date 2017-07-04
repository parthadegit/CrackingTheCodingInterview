package chapter_04_Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class PathExistsBetweenTwoNodesInDirectedGraph {
	public static void main(String[] args) {
		//build the graph etc etc.
		int noOfNodes  = 10;
		Graph g = new Graph(noOfNodes);
		addDirectedEdgesToGraph(g);
		Vertex nodeA = g.vertsList.get(7), nodeB = g.vertsList.get(0);
		boolean b = isThereAnyRoute(nodeA,nodeB);
		System.out.println(b);
	}
	
	private static boolean isThereAnyRoute(Vertex nodeA, Vertex nodeB) {
		if(nodeA==null||nodeB==null)
			return false;
		HashMap<Vertex,Boolean> hm = new HashMap<Vertex,Boolean>();
		if(dfst(nodeA,nodeB,hm))
			return true;
		else{
			hm = new HashMap<Vertex,Boolean>();
			return dfst(nodeB,nodeA,hm);
		}
	}
	//Assuming that there is no seen flag in the Vertex class and nodes are not properly numbered.
	
	private static boolean dfst(Vertex nodeA, Vertex nodeB, HashMap<Vertex, Boolean> hm) {
		if(nodeA==nodeB)
			return true;
		
		hm.put(nodeA, true);
		for(int i=0;i<nodeA.adj.size();i++){
			if(!hm.containsKey(nodeA.adj.get(i))){
				boolean flag = dfst(nodeA.adj.get(i),nodeB,hm);
				if(flag)
					return true;
			}
		}
		return false;
	}
	
//***************Adding edge between node*********************//
	private static void addDirectedEdgesToGraph(Graph g) {
		g.vertsList.get(0).adj.add(g.vertsList.get(3)); // 0->3
		g.vertsList.get(1).adj.add(g.vertsList.get(3)); // 1->3
		g.vertsList.get(3).adj.add(g.vertsList.get(5)); // 3->5
		g.vertsList.get(0).adj.add(g.vertsList.get(9)); // 0->9
		g.vertsList.get(7).adj.add(g.vertsList.get(9)); // 7->9
		g.vertsList.get(0).adj.add(g.vertsList.get(5)); // 0->5
		g.vertsList.get(5).adj.add(g.vertsList.get(7)); // 5->7
		g.vertsList.get(5).adj.add(g.vertsList.get(3)); // 5->3
		g.vertsList.get(7).adj.add(g.vertsList.get(2)); // 7->2
		g.vertsList.get(9).adj.add(g.vertsList.get(1)); // 8->1
		g.vertsList.get(8).adj.add(g.vertsList.get(0)); // 8->0
		g.vertsList.get(6).adj.add(g.vertsList.get(3)); // 6->3
	}

}

//***************Graph Class**********************//
class Graph{
	ArrayList<Vertex> vertsList;
	public Graph(int graphSize){
		vertsList = new ArrayList<Vertex>();
		for(int i=0;i<graphSize;i++){
			vertsList.add(new Vertex(i));
		}
	}
	
}
//***************Vertex Class**********************//
class Vertex{
	int vertexId;
	ArrayList<Vertex> adj;
	public Vertex(int nodeId) {
		vertexId = nodeId;
		adj = new ArrayList<Vertex>();
	}
}
