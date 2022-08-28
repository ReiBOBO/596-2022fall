package insertionSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {3,1,2,6,7};
		sort(nums);
		
		for (Integer i: nums) {
			System.out.println(i);
		}
	}
	
	public static void sort(int[] nums) {
		
		for(int i=1; i<nums.length;i++) {
			while(i-1>=0 && nums[i]<nums[i-1]) {
				int temp = nums[i];
				nums[i]=nums[i-1];
				nums[i-1]=temp;
			}
		}
		
	}
}
