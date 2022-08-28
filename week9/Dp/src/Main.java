import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4;
		   Job arr[] = new Job[m];
		    arr[0] = new Job(3, 10, 20);
		    arr[1] = new Job(1, 2, 50);
		    arr[2] = new Job(6, 19, 100);
		    arr[3] = new Job(2, 100, 200);
		    int n =arr.length;
		    int[] dp = new int[m];
		    Arrays.sort(arr,(a,b)->a.finish-b.finish);
		    System.out.println("The top-down optimal profit is " + findMaxProfit(arr, n,dp));
		    System.out.println("The bottom-up optimal profit is " + bu(arr,dp));
	}
	
	static class Job
	{
	    int start, finish, profit;
	    Job(int start, int finish, int profit)
	     {
	        this.start = start;
	        this.finish = finish;
	        this.profit = profit;
	     }
	}
	public static int findMaxProfit(Job[] arr, int n,int[] dp) {
		if(n-1==0) {return arr[0].profit;}
		if(dp[n-1]==0) {
			 int inclProf = arr[n-1].profit;
			 int i = latestNonConflict(arr, n-1);
			 if(i!=-1) {
				inclProf +=arr[i].profit; 
			 }
			 int exclProf = findMaxProfit(arr, n-1,dp);
			dp[n-1]=Math.max(inclProf, exclProf);
		}
		return dp[n-1];
	}
	
	static int latestNonConflict(Job arr[], int i)
	{	
		int curStar = arr[i].start;
		for(int j = i-1 ; j>=0; j--) {
			if(arr[j].finish<=curStar) {
				return j;
			}
		}
		return -1;
	}
	
	 static int bu(Job[] arr, int[] dp){
		dp[0] =  arr[0].profit;
		for(int i = 1; i < arr.length;i++) {
			int last_meeting = latestNonConflict(arr,i);
			int inc_cur_meeting = arr[i].profit;
			if(last_meeting!=-1) {
				inc_cur_meeting+=dp[last_meeting];
			}
			int exc = dp[i-1];
			dp[i]=Math.max(inc_cur_meeting, exc);
		}
		return dp[dp.length-1];
	}
}
