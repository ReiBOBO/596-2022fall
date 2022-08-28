package quickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = new int[] {3,2,7,4,9,1};
//		quickSort(nums,0,nums.length-1);
//		for(Integer i : nums) {
//			System.out.println(i);
//		}
//		System.out.println(quickSelect(nums,4,0,nums.length-1));
		int[] n = {1,2,3,4};
		System.out.println(wangdachui(4,3,n).toString());
	}
	
	public static void quickSort(int[] n, int l, int r) {
		if(l>=r) {return;}
		int left = l;
		int right = r;
		random(n,l,r);
		int p = n[l];
		while(left<right) {
			while(left<right && n[right]>=p) {
				right--;
			}
			if(left<right) {
				n[left]=n[right];
				left++;
			}
			while(left<right && n[left]<p) {
				left++;
			}
			if(left<right) {
				n[right]=n[left];
				right--;
			}
		}//end while
		n[left] = p;
		quickSort(n,l,left-1);
		quickSort(n,left+1,r);

	}
	
	public static int quickSelect(int[] n, int k, int l, int r) {
		
		random(n,l,r);
		int i = l;
		int j = r;
		int p = n[l];
		while(i<j) {
			while(i<j && n[j]>=p) {
				j--;
			}
			if(i<j) {
				n[i]=p;
				i++;
			}
			while(i<j && n[i]<p) {
				i++;
			}
			if(i<j) {
				n[j]=p;
				j--;
			}
		}
		n[i]=p;
		if(i==k) {return p;}
		else if(k<i) {return quickSelect(n,k,l,i-1);}
		return quickSelect(n,k,i+1,r);
		
	}
	public static void random(int[]nums, int l, int r) {
		Random rand = new Random();
		int p = rand.nextInt(r-l)+l;
		int temp = nums[p];
		nums[p] = nums[l];
		nums[l]=temp;
	}
	
	public static List<List<Integer>> wangdachui(int k, int d, int[] nums){
			int a = 0;
			int c = a+d;
			List<List<Integer>> res = new ArrayList<>();
			while(c<nums.length) {
				int t = a;
				while(t<c) {
					int b = t +1;
					while(b<c) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[a]);
						temp.add(nums[b]);
						temp.add(nums[c]);
						b++;
						res.add(temp);
					}
					t++;
				}
				
				c++;
			}
			return res;}
}
