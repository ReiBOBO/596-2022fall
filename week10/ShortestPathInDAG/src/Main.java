import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] edges = new int[][] { {0,1,2},{0,2,5},{1,3,6},{2,3,2}};
		int n = 4;
		List<int[]>[] graph = new LinkedList[n];
		for(int i=0;i<n;i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int[] edge :edges) {
			int from = edge[0];
			int to = edge[1];
			int weight = edge[2];
			graph[from].add(new int[] {to,weight});
			
		}
		
		int[] res = algo1(graph, 0);
		for(int i=0; i<n;i++) {
			System.out.println(res[i]);
		}
	}
	
	public static void update (int u, int v, int[] dist, int[] parent, int weight) {
		if(dist[v]> dist[u]+weight) {
			dist[v] =  dist[u]+weight;
		}
		parent[v] = u;
	}
	
	public static int[] algo (List<int[]>[] graph, int start) {
		int[] dist = new int[graph.length];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		int[] parent = new int[graph.length];
		Arrays.fill(parent, -1);
		List<Integer> topoSorted = new ArrayList<>();
		boolean[] visited = new boolean[graph.length];
		topo(graph, topoSorted,visited,start);
		int[] sorted = new int[graph.length];
		Collections.reverse(topoSorted);
		for(int i=0; i< graph.length;i++) {
			sorted[i]= topoSorted.get(i);
		}
		for(int u: sorted) {
			for(int[] edge:graph[u]) {
				update(u,edge[0],dist,parent,edge[1]);
			}
		}
		
		return dist;
	}
	public static void topo(List<int[]>[] graph, List<Integer> sorted, boolean[] visited, int start) {
		if(visited[start]) return;
		visited[start] = true;
		for(int[] edge:graph[start]) {
			topo(graph,sorted,visited,edge[0]);
		}
		sorted.add(start);
	}

	public static int[] algo1(List<int[]>[] graph, int start) {
		int n = graph.length;
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		
		
		//Collections.reverse(topoSort);
		int[] sorted = new int[n];
		topoBfs(graph,sorted,start);
		
		for(int v : sorted) {
			//update
			int curPathCost = dist[v];
			for(int[] edge : graph[v]) {
				int nextTo = edge[0];
				int weightTo = edge[1];
				if(dist[nextTo]>curPathCost+weightTo) {
					dist[nextTo] = curPathCost+weightTo;
				}
			}
		}
		
		return dist;
	}
	public static void topoBfs(List<int[]>[] graph, int[] sorted, int start) {
		int n = graph.length;
		int[] indegree = new int[n];
		int count = 0;
		for(int i = 0; i<n; i++) {
			for(int[] edge:graph[i]) {
				indegree[edge[0]]++;
			}
		}
	    Queue<Integer> q = new LinkedList<>();
	    q.add(start);
	    while(!q.isEmpty()) {
	    	int v = q.poll();
	    	sorted[count]=v;
	    	count++;
	    	for(int[] edge:graph[v]) {
	    		int to = edge[0];
	    		indegree[to]--;
	    		if(indegree[to]==0) q.add(to);
	    	}
	    }
	}
}
