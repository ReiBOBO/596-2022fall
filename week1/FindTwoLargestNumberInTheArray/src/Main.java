
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {3,6,2311,92,13,11};
		System.out.println(find(n,5)[0]);
		System.out.println(find(n,5)[1]);

	}
	
	public static int[]  find(int[] nums, int n){
		int first = 0 ;
		int second = 0;
		if(n<2) {
			first=Math.max(nums[0], nums[1]);
			second=Math.min(nums[0], nums[1]);
			return new int[] {first, second};
		}
		int[] res = find(nums,n-1);
		if(nums[n]>res[0]) {
			first = nums[n];
			second = res[0];
		}
		else if(nums[n]>res[1]) {
			second=nums[n];
			first=res[0];
		}
		else {
			first=res[0];
			second=res[1];
		}
		
		return new int[] {first, second};
	}

}
