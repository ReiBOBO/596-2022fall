package matrixmultiplication;

public class Main {

	public static  void main(String[] args) {
		int[][] a = new int[2][3];
		int[][] b = new int[3][2];
		a[0][0]=1;
		a[0][1]=3;
		a[0][2]=5;
		a[1][0]=2;
		a[1][1]=4;
		a[1][2]=6;
		
		b[0][0]=9;
		b[0][1]=10;
		b[1][0]=8;
		b[1][1]=7;
		b[2][0]=6;
		b[2][1]=5;
		
		int[][] c = straight(a,b);
		for(int i=0; i<c.length;i++) {
			for(int j=0;j<c[0].length;j++) {
				System.out.println(c[i][j]);
			}
		}
		
	}
	
	public static int[][] straight(int[][] a, int[][]b){
		int m = a.length;
		int n=a[0].length;
		int l=b[0].length;
		int[][] res = new int[m][l];
		for(int i=0; i<m; i++) {
			for(int j=0;j<l;j++) {
				for(int k=0; k<n;k++) {
					res[i][j]+=a[i][k]*b[k][j];
				}
			}
		}
		return res;
		
	}

//	public static int[][] rec(int[][]a, int[][]b){
//		if(a.length==1 || b.length==1) {
//			int[][] res = new int[1][1];
//			res[0][0]=a[0][0]*b[0][0];
//			return res;
//		}
//		int m = a.length;
//		int n = a[0].length;
//		int l = b[0].length;
//		int[][] u=new int[m/2][n/2];
//		int[][] v=new int[m/2][n-n/2];
//		int[][] w=new int[m-m/2][n/2];
//		int[][] x=new int[m-m/2][n-n/2];
//		for(int i=0; i<m/2;i++) {
//			for(int j=0; j<n/2;j++) {
//				u[i][j]=a[i][j];
//			}
//		}
//		for(int i=0; i<m/2;i++) {
//			for(int j=n/2; j<n;j++) {
//				v[i][j-n/2]=a[i][j];
//			}
//		}
//		for(int i=m/2; i<m;i++) {
//			for(int j=0; j<n/2;j++) {
//				w[i-m/2][j]=a[i][j];
//			}
//		}
//		for(int i=m/2; i<m;i++) {
//			for(int j=n/2; j<n;j++) {
//				x[i-m/2][j-n/2]=a[i][j];
//			}
//		}
//		
//		int[][] p=new int[m/2][n/2];
//		int[][] q=new int[m/2][n-n/2];
//		int[][] r=new int[m-m/2][n/2];
//		int[][] s=new int[m-m/2][n-n/2];
//		for(int i=0; i<m/2;i++) {
//			for(int j=0; j<n/2;j++) {
//				p[i][j]=b[i][j];
//			}
//		}
//		for(int i=0; i<m/2;i++) {
//			for(int j=n/2; j<n;j++) {
//				q[i][j-n/2]=b[i][j];
//			}
//		}
//		for(int i=m/2; i<m;i++) {
//			for(int j=0; j<n/2;j++) {
//				r[i-m/2][j]=b[i][j];
//			}
//		}
//		for(int i=m/2; i<m;i++) {
//			for(int j=n/2; j<n;j++) {
//				s[i-m/2][j-n/2]=b[i][j];
//			}
//		}
//		
//		int[][] res = new int[m][l];
//		int[][] first = rec(u,q)+rec(v,r);
//		int[][] second=rec(v,r);
//		int[][] third=rec(w)
//		
//	}



}

