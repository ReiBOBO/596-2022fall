import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{0,1,5},{1,2,3},{1,3,2},{1,5,4},{1,4,1},{2,3,4},{2,4,5},{2,5,2},{3,4,1},{3,5,3},{4,5,2}};
		int n  = 6;
		List<int[]>[] g = new ArrayList[n];
		for(int i=0; i<n;i++) {
			g[i] = new ArrayList<>();
		}
		for(int[] edge :edges) {
			int u = edge[0];
			int v = edge[1];
			int weight = edge[2];
			g[edge[0]].add(new int[] {u,v,weight});
			g[edge[1]].add(new int[] {u,v,weight});
		}
		Prim prim = new Prim(g);
		System.out.println(prim.getWeightSum());
		System.out.println(prim.ifConnected());

	}

}
