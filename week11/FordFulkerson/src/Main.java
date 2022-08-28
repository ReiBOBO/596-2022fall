import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = new int[][] {
            { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
            { 0, 4, 0, 0, 14, 0 },  { 0, 0, 9, 0, 0, 20 },
            { 0, 0, 0, 7, 0, 4 },   { 0, 0, 0, 0, 0, 0 }
        };
        
        
 
        System.out.println("The maximum possible flow is "+
        		ff(graph,0,5) );
        
        boolean bpGraph[][] = new boolean[][]{
            {false, true, true,
             false, false, false},
            {true, false, false,
             true, false, false},
            {false, false, true,
             false, false, false},
            {false, false, true,
             true, false, false},
            {false, false, false,
             false, false, false},
            {false, false, false,
             false, false, true}};
             BipartiteMatching bm = new BipartiteMatching();
             System.out.println("Maximum number of applicants that can"+
                     " get job is "+ bm.maxBPM(bpGraph));
	}
	
	public static boolean bfs(int[][] rGraph,int s, int t, int[] parent) {
		parent[s] = -1;
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		boolean[] visited = new boolean[rGraph.length];
		visited[s] = true;
	
		while(!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true;
			if(cur == t) return true;
			
			for(int i =0; i<rGraph.length;i++) {
				
				if(visited[i]==false && rGraph[cur][i]>0) {
					parent[i]=cur;
					q.add(i);
				}
			}
			
		}
		
		
		return false;
	}
	
	public static int ff(int[][] graph, int s, int t) {
		int m = graph.length;
		int[][] rGraph = new int[m][m];
		int[] parent = new int[m];
		int maxFlow = 0;
		for(int i = 0; i<m; i++) {
			for(int j=0; j<m; j++) {
				rGraph[i][j] = graph[i][j];
			}
		}
		while(bfs(rGraph,s,t,parent)) {
			int path_cap = Integer.MAX_VALUE;
			
			for(int v =t; v!=s;v=parent[v]) {
				int u = parent[v];
				path_cap = Math.min(path_cap, rGraph[u][v]);
			}
			// update residual capacities of the edges and
            // reverse edges along the path
			for(int v = t; v!=s; v=parent[v]) {
				int u = parent[v];
				rGraph[u][v]-=path_cap;
				rGraph[v][u]+=path_cap;
			}
			maxFlow += path_cap;
		}
		return maxFlow;
	}

}
