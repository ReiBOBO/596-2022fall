
public class Main {
	static int V;
	static int INF=99999;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
              };
		V=4;
		floydWarshall(graph);
	}
	public static int[][] floydWarshall(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dist = new int[m][n];
		for (int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				dist[i][j] = matrix[i][j];
			}
		}
		for(int k =0; k<m ;k++) {
			for(int i=0; i<m;i++){
				for(int j=0; j<m;j++){
					if(dist[i][k]+dist[k][j]<dist[i][j]) {
						dist[i][j]=dist[i][k] + dist[k][j];
					}
				}
			}
		}
		printSolution(dist);
		return dist;
	}
	
	public static  void printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                         "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
