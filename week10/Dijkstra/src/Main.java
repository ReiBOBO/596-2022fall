import java.util.LinkedList;
import java.util.*;

public class Main {
	static int[] parent;
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
		parent = new int[n];
		for(int i:d1(graph,0))
		System.out.println(i);
		
		
		
	}
	
	public static int[] dijkstra(List<int[]>[] graph, int start) {
		int n = graph.length;
		int[] distTo = new int[n];
		Arrays.fill(distTo, Integer.MAX_VALUE);
		boolean[] inS = new boolean[n];
		Queue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-a[1]);
		inS[start] = true;
		distTo[start] = 0;
		for(int[] edge: graph[start]) {
			pq.add(edge);
			int nextTo = edge[0];
			int nextWeight = edge[1];
			distTo[nextTo]=nextWeight;
			parent[nextTo] = start;
		}
		
		while(!pq.isEmpty()) {
			int[] min_edge = pq.poll();
			int to = min_edge[0];
			int pathWeight = distTo[to];
			if(inS[to]) continue;
			inS[to] = true;
			for(int[] edge : graph[to]) {
				int nextTo = edge[0];
				int nextWeight = edge[1];
				if (inS[nextTo]) continue;
				pq .add(edge);
				if(distTo[nextTo]>pathWeight+nextWeight) {
					distTo[nextTo] = pathWeight+nextWeight;
					parent[nextTo] = to;
				}
			}
		}
		return distTo;
	}

	
	public static int[] d1(List<int[]>[] g, int s) {
		int n = g.length;
		int[] dist = new int[n];
		boolean[] inS = new boolean[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		inS[s] = true;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		for(int[] edge : g[s]) {
			int to = edge[0];
			int weight = edge[1];
			dist[to] = weight;
			pq.add(edge);
		}
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curVertex = cur[0];
			if(inS[curVertex]) continue;
			for(int[] edge : g[curVertex]) {
				int nextNode = edge[0];
				if(inS[nextNode]) continue;
				int weightToNextNode = edge[1];
				if(dist[nextNode]>dist[curVertex]+weightToNextNode) {
					dist[nextNode]=dist[curVertex]+weightToNextNode;
				}
				pq.add(edge);
			}
 		}
		return dist;
	}
}
