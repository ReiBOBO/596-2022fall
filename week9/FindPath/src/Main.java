import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node v1 = new Node(1);
		Node v2 = new Node(2);
		Node v3 = new Node(3);
		Node v4 = new Node(4);
		Node v5 = new Node(5);
		Node v6 = new Node(6);
		v1.addEdge(new Edge(1,2,1));
		v1.addEdge(new Edge(1,3,1));
		v1.addEdge(new Edge(1,5,1));
		v2.addEdge(new Edge(2,6,2));
		v2.addEdge(new Edge(2,4,1));
		v3.addEdge(new Edge(3,2,2));
		v4.addEdge(new Edge(4,3,2));
		v4.addEdge(new Edge(4,6,3));
		v5.addEdge(new Edge(5,4,2));
		v5.addEdge(new Edge(5,6,2));
		v6.addEdge(new Edge(6,5,2));
		List<Edge> edgeList = new ArrayList<>();
		edgeList.add(new Edge(1,2,1));
		edgeList.add(new Edge(1,3,1));
		edgeList.add(new Edge(1,5,1));
		edgeList.add(new Edge(2,6,2));
		edgeList.add(new Edge(2,4,1));
		edgeList.add(new Edge(3,2,2));
		edgeList.add(new Edge(4,3,2));
		edgeList.add(new Edge(5,4,2));
		edgeList.add(new Edge(5,6,2));
		edgeList.add(new Edge(6,5,2));

		System.out.println(bu(2,6,edgeList));
		
		
	}
	static class graph{
		List<Node> vertices;
		public graph() {
			vertices=new ArrayList<>();
		}
	}
	static class Node{
		int v;
		List<Edge> neighbors;
		public Node(int v) {
			this.v = v;
			neighbors = new ArrayList<>();
		}
		public void addEdge(Edge e) {
			neighbors.add(e); 
			
		}
	}
	static  class Edge{
		int source;
		int dest;
		int label;
		Edge(int s, int d, int l){
			source = s;
			dest =d;
			label =l;
		}
	}

	static int bu(int path_length, int n, List<Edge> edges) {
		int[][] table = new int[path_length][n];
		for(Edge edge:edges) {
			if(edge.source==1 && edge.label==1) {
				table[0][edge.dest-1]=1;
			}
		}
		for(int i=1;i<path_length;i++) {
			for(Edge edge:edges) {
				if(edge.label==i+1) {
					int idx = edge.source-1;
					if(table[i-1][idx]!=0) {
						table[i][idx]+=table[i-1][idx];
					}
				}
				
			}			
		}
		int res = 0;
		for(int i=0;i<n;i++) {
			res+=table[path_length-1][i];
		}
		return res;
		
	}
}
