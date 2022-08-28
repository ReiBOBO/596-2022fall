
public class BipartiteMatching {
	static final int M =6;
	static final int N =6;
	
	boolean bpm(boolean[][] rGraph, int u, boolean visited[], int[] assign) {
		
		for(int v=0; v<N;v++) {
			if(rGraph[u][v] && !visited[v]) {
				visited[v] = true;
			if(assign[v]==-1 || bpm(rGraph,assign[v],visited,assign)) {
				assign[v] = u;
				return true;
			}
			}
		}
		return false;
	}
	
	int maxBPM(boolean[][] rGraph) {
		int res = 0;
		int[] assign = new int[N];
		for(int i = 0; i<N;i++) {
			assign[i]=-1;
		}
		
		for(int u=0; u < M; u++) {
			boolean[] visited = new boolean[M];
			if(bpm(rGraph,u,visited,assign)) res++;
		}
		
		
		
		return res;
	}
}
