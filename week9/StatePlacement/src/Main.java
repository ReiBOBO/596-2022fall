import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double[] towns = {23.0,24.0,36.0,39.0,46.0,56.0,57.0,65.0,84.0,98.0};
		int n = towns.length;
		int k = 2;
		Double [][] dp = new Double[n][k];
		for( int i=0; i<k;i++) {
			dp[n-1][i] =  0.0;
		}
		for(int i=0; i<n;i++) {
			dp[i][0] =((towns[n-1]-towns[i])/2.0);
		}
		System.out.println(bu(towns,2));
	}
	
	static Double bu (Double[] t, int k) {
		int n = t.length;
		Double [][] dp = new Double[n][k];
		for( int i=0; i<k;i++) {
			dp[n-1][i] =  0.0;
		}
		for(int i=0; i<n;i++) {
			dp[i][0] =((t[n-1]-t[i])/2.0);
		}
		

		for (int l = 1; l<k;l++) {
			
			for(int i = n-1; i>=0;i--) {	
				Double local_min=Double.MAX_VALUE;
				for( int x = i; x<n;x++ ) {
					Double cur_max = (t[x]-t[i])/2.0;
					Double prev =0.0;
					if(x+1<n) {
						 prev = dp[x+1][l-1];
					}
					
					cur_max = Math.max(cur_max, prev);	
					local_min = Math.min(local_min,cur_max);
				}
				if(local_min!=Double.MAX_VALUE)
				dp[i][l] = local_min;
			}
			
		}
		
		
		return dp[0][k-1];
	}
	
	static Double td(Double[] t, int k, int i, int l,Double[][] dp) {
		int n = t.length;
		if(i==n-1) {return 0.0;}
		if(l==0) {return dp[i][0];}
		
		int curmax = 0;
		
		return dp[i][l];
	}
}
