import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = new int[][] { {0,1,2},{0,2,5},{1,3,6},{2,3,2},{3,2,1}};
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
		int[] res = algo(graph, 0);
		for(int i=0; i<n;i++) {
			System.out.println(res[i]);
		}
	}
	
	public static int[] algo(List<int[]>[] g, int s) {
		int n = g.length;
		int[] dist = new int[n];		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		for(int i = 0; i<n-1; i++) {
			for(int j = 0; j<n; j++) {
				for(int[] edge:g[j]) {
					int to = edge[0];
					int weight = edge[1];
					if(dist[to]>dist[j]+weight) {
						dist[to]=dist[j]+weight;
					}
				}
			}
		}
		
		for(int j = 0; j<n; j++) {
			for(int[] edge:g[j]) {
				int to = edge[0];
				int weight = edge[1];
				if(dist[to]>dist[j]+weight) {
					System.out.println("negative cycle detected");
				}
			}
		}
		
		return dist;
	}

}
