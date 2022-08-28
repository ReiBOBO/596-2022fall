	import java.util.*;
	import java.io.*;
	import java.lang.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = {100,50,50,25};
		System.out.println(cutOffRank(3,4,scores));
	}
	


	
	    public static int cutOffRank(int cutOffRank, int num, int[] scores) {
	        
	        
	        TreeMap<Integer, Integer> map = new TreeMap<>();
	        for(int i = 0; i< num;i++){
	        	
	           map.put(scores[i],map.getOrDefault(scores[i],0)+1);
	        }
	        int res = 0;
	        while(cutOffRank>0){
	            int temp = map.pollFirstEntry().getValue();
	            res = res+temp;
	            cutOffRank=cutOffRank-res;
	        }
	        
	        return res;
	    }
	
}
