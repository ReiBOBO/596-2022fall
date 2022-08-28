import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
public class Prim {
	boolean[] inMST;
	List<int[]>[] graph;
	PriorityQueue<int[]> pq;
	int weightSum=0;
	Prim(List<int[]>[] graph){
		this.graph=graph;
		this.pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
		int n = graph.length;
		this.inMST = new boolean[n];
		inMST[0]=true;
		cut(0);
		while(!pq.isEmpty()) {
			int[] edge = pq.poll();
			int to = edge[1];
			if(inMST[to]) continue;
			weightSum+=edge[2];
			inMST[to]=true;
			cut(to);
		}
	}
	
	void cut(int v){
		for(int[] edge:graph[v]) {
			int to = edge[1];
			if(inMST[to]) continue;

			pq.offer(edge);
		}
	}
	
	boolean ifConnected() {
		for(boolean i: inMST) {
			if(!i) return false;
		}
		return true;
	}
	
	int getWeightSum() {
		return this.weightSum;
	}
}
