import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Uc {
	int count;
	int[] parent;
	ArrayList<int[]> edgeList;
	public Uc(int n) {
		this.count = n;
		parent = new int[n];
		for(int i = 0; i<n; i++) {
			parent[i]=i;
		}
		edgeList = new ArrayList<>();
		
	}
	void union(int p , int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if(p==q) return;
		parent[rootP]=rootQ;
		count--;
	}
	int find(int p) {
		if(parent[p]!=p) {
			parent[p]=find(parent[p]);
		}
		return parent[p];
	}
	
	boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return rootP==rootQ;
	}
}
