import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Graph {
	private int V;
	private LinkedList<Integer>[] adj;
	
	Graph(int v){
		V=v;
		adj = new LinkedList[v];
		for(int i = 0; i<v;i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}//end Graph
	
	void addEdge(int u, int v) {
		adj[u].add(v);
	}
    // A recursive function to print DFS starting from v

	void DFSUtil(int v, boolean[] visited) {
		visited[v]=true;
		System.out.println(v+" ");
		Iterator<Integer> i = adj[v].iterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(n,visited);
			}
		}
	}
	
    // Function that returns reverse (or transpose) of this graph
	Graph getTranspose() {
		
		Graph g = new Graph(V);
		for(int i=0; i<V;i++) {
			Iterator<Integer> it = adj[i].iterator();
			while(it.hasNext()) {
				g.adj[it.next()].add(i);
			}
		}
		return g;
		
	}
	
	void fillOrder(int v, boolean[] visited, Stack stack) {
		visited[v]=true;
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			int n = it.next();
			if(!visited[n]) {
				fillOrder(n,visited,stack);
			}
		}
		stack.push(v);
	}
	
    void printSCCs() {
    	Stack<Integer> stack = new Stack<>();
    	boolean[] visited = new boolean[V];
    	for(int i=0; i<V; i++) {
    		if(visited[i]==false) {
    			fillOrder(i,visited,stack);
    		}
    	}
    	for(int i =0; i<V;i++) {
    		visited[i]=false;
    	}
    	Graph g = getTranspose();
    	while(!stack.isEmpty()) {
    		int n = stack.pop();
    		if(!visited[n]) {
    			g.DFSUtil(n, visited);
    			System.out.println();
    		}
    	}
    }

}
