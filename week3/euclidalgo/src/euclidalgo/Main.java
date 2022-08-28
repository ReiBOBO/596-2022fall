package euclidalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(euclid1(8,6));
//		System.out.println(euclid2(8,6));
		//int[] res = euclidextend(5, 72);
		//System.out.println(res[0]+" "+res[1]+" "+res[2]);
		//System.out.println(repeatedSquaring(6,29,91));
		int[] nums = {3, -9, 4, -2, 6, -3, -1, 10, -5, 1, -3, 6};
		System.out.println(get(nums)[0]);
		System.out.println(get(nums)[1]);
		System.out.println(maxSubArray(nums));
	}
	
	public static int euclid1(int a, int b) {
		int r=a%b;
		while(r>0) {
			a=b;
			b=r;
			//if(b==0) break;
			r=a%b;
		}
		return b;
	}
	
	public static int euclid2(int a, int b) {
		if(b==0) {return a;}
		return euclid2(b,a%b);
	}
	
	public static int[] euclidextend(int a, int b) {
		if(b==0) return new int[] {1,0,a};
		
		int[] xyz = euclidextend(b,a%b);
		
		int u = xyz[0];
		int v=xyz[1];
		int d=xyz[2];
		
		return new int[] {v,u-(int)a/b*v,d};
	}
	
	public static int repeatedSquaring(int a, int power, int c) {
		List<Integer> powerToBinary =  trasferToBinary(power);
		int res=1;
		Collections.reverse(powerToBinary);
		int size = powerToBinary.size();
		int[] dp  = new int[size];
		dp[0] = a%c;
		for(int i =1; i<size;i++) {
			dp[i]=(dp[i-1]*dp[i-1])%c;
			if(powerToBinary.get(i)==1) {
				res=(res*dp[i])%c;
			}
		}
		if(powerToBinary.get(0)==1) {
			res=(res*dp[0])%c;
		}
		return res;
	}
	
	public static List<Integer> trasferToBinary(int a){
		List<Integer> res = new LinkedList<>();
		int r= 0;
		while(a>=2) {
			r=a%2;
			a=a/2;
			res.add(r);
		}
		res.add(a%2);
		return res;
		
	}
	
	public static int[] get(int[] nums) {
		int[] res = new int[2];
		int max = Integer.MIN_VALUE;
		int sum = Integer.MIN_VALUE; //the largest value of sum til i-1	
		for(int i = 0;i<nums.length;i++) {
			int pre = sum+nums[i];
			int cur = nums[i];
			if(pre>cur && pre>max) {
				res[1]=i;
				max=pre;
			}
			
			else if(pre<cur && cur>max) {
				res[0]=i;
				res[1]=i;
				max=cur;
			}
			sum = Math.max(sum+nums[i],nums[i]);
			
		}
		
		return res;
	}
	
	public static int maxSubArray(int[] nums) {
	     int sum = 0;
	     int res = Integer.MIN_VALUE;
	        sum=0;
	     for(int i = 0; i<nums.length; i++){
	         sum = Math.max(sum+nums[i],nums[i]);
	         res = Math.max(res,sum);
	     }
	        return res;
	    }
}
