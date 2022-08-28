import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class UnionFind {
	int count;
	ArrayList<LinkedList<Integer>> nodes_under_a_cc;
	ArrayList<int[]> edgeList;
	int[] cc;
	public UnionFind(int n) {
		this.count = n;
		nodes_under_a_cc = new ArrayList<>();
		for(int i = 0; i<n;i++) {
			LinkedList<Integer> curList = new LinkedList<>();
			curList.add(i);
			nodes_under_a_cc.add(curList);
		}
		cc = new int[n];
		for(int i = 0;i < n;i++) {
			cc[i]=i;
		}
		edgeList = new ArrayList<>();
	}
	//union two components.
	void union(int p, int q) {
		if(nodes_under_a_cc.get(p).size()>nodes_under_a_cc.get(q).size()) {
			Iterator<Integer> it = nodes_under_a_cc.get(q).iterator();
			while(it.hasNext()) {
				cc[(int) it.next()]=p;
			}
			nodes_under_a_cc.get(p).addAll(nodes_under_a_cc.get(q));
			nodes_under_a_cc.get(q).clear();
		}
		else {
			Iterator<Integer> it = nodes_under_a_cc.get(p).iterator();
			while(it.hasNext()) {
				cc[(int) it.next()]=q;
			}
			nodes_under_a_cc.get(q).addAll(nodes_under_a_cc.get(p));
			nodes_under_a_cc.get(p).clear();
		}
		count--;
	}
	
	//find which compnents it is.
	int find(int node) {
		return this.cc[node];
	}
	
	//get the number of cc in this graph.
	int count() {
		return this.count;
	}
	boolean connected(int p, int q) {
		return cc[p]==cc[q];
	}
}
