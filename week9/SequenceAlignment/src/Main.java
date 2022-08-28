import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "apple";
		String s2 ="pinapple";
		int m = s1.length();
		int n = s2.length();
		int[][] memo = new int[m][n];
		for(int i =0; i<m;i++) {
			for(int j=0; j<n;j++) {
				memo[i][j]=-1;
			}
		}
		System.out.println(td(s1,m-1,s2,n-1,memo));
		System.out.println(bu(s1,s2));
	}
	
	static int td(String s1, int i, String s2, int j,int[][] memo) {
		if(i==-1) return j+1;
		if(j==-1) return i+1;
		if(memo[i][j]!=-1) {return memo[i][j];}
		if(s1.charAt(i)==s2.charAt(j)) memo[i][j]= td(s1,i-1,s2,j-1,memo);
		else {
		int case1 = td(s1,i-1,s2,j-1,memo)+1;
		int case2= td(s1,i,s2,j-1,memo)+1;
		int case3= td(s1,i-1,s2,j,memo)+1;
		int curMin = Math.min(case1, case2);		 
		memo[i][j]= Math.min(case3, curMin);
		}
		return memo[i][j];
	}
	
	static int bu(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		int[][] table = new int[m+1][n+1];
		//initialize base cases.
		for(int i =0; i<m+1;i++) {
			table[i][0]=i;
		}
		for(int j=0; j<n+1;j++) {
			table[0][j]=j;
		}
		
		for(int i=1; i<m+1;i++) {
			for(int j=1; j<n+1;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					table[i][j]=table[i-1][j-1];
				}
				else{table[i][j]=Math.min(table[i-1][j-1]+1, Math.min(table[i][j-1]+1, table[i-1][j]+1));}
				
			}
		}
		return table[m][n];
	}

}
