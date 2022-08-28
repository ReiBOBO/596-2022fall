
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{1,3},{2,3},{3,4},{4,5},{5,7},{7,9}};
		int n =points.length;
		Double[] memo = new Double[n];
		for(int i=0; i<n;i++) {
			memo[i]=-1.0;
		}
		
		Double C = 0.5;
		memo[0]=C;
		memo[1]=C;
		Double res = td(points,memo,n-1,C);
		System.out.println(res);
		System.out.println(bu(points,C));
	}



 static Double td(int[][] points, Double[] memo, int j, Double C) {
	 if(j<0) {return 0.0;}
	 if(j<=1) {return C;}
	 if(memo[j]==-1.0) {
		 Double min =Double.MAX_VALUE;
		 for(int i = 0; i<j;i++) {
			 min = Math.min(td(points,memo,i-1,C)+C+REG(points,i,j), min);
		 }
		 memo[j]=min;
		 
	 }
	 return memo[j];
	 
 }
 static Double bu(int[][] points, Double C) {
	 int n =points.length;
	 Double[] table = new Double[n+1];	
	 for(int i=0; i<n;i++) {
		 table[i]=-1.0;
		}
	    table[0]=0.0;
		table[1]=C;
		table[2]=C;
		
		for(int j=1;j<n;j++) {
			Double min = Double.MAX_VALUE;
			for(int i=1;i < j; i++) {
				Double y_error =REG(points,i,j);
				Double last_best = table[i-1];
				 
				min = Math.min(min,last_best+C+y_error);
			}
			table[j]=min;
		}
		
		return table[n-1];
 }
 
 static Double REG(int[][] points,int i, int j) {
	 Double a = 0.0;
	 Double b = 0.0;
	 Double x_sum =0.0;
	 Double y_sum =0.0;
	 Double xy_sum = 0.0;
	 Double x_square_sum=0.0;
	 for(int p=i;p<j+1;p++) {
		 Double x_p = (double) points[p][0];
		 Double y_p = (double) points[p][1];
		 x_sum+=x_p;
		 y_sum+=y_p;
		 xy_sum+=x_p*y_p;
		 x_square_sum+=x_p*x_p;
	 }
	 int n = j-i;
	 a = (n*xy_sum-x_sum*y_sum)/(n*x_square_sum-x_sum*x_sum);
	 b = (y_sum-a*x_sum)/n;
	 Double res = 0.0;
	 for(int p=i;p<j+1;p++) {
		 Double x_p = (double) points[p][0];
		 Double y_p = (double) points[p][1];
		 res += (a*x_p+b-y_p)*(a*x_p+b-y_p);
	 }
	 
	 return res;
 }
 
 }