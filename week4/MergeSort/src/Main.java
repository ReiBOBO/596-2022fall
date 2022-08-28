
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sample = {6,2,3,1,7,5};
		int[] sorted=mergeSort(sample);
		for(int i = 0; i<sorted.length;i++) {
			System.out.println(sorted[i]);
		}
				
	}
	
	public static int[] mergeSort(int[] num) {
		if(num.length==1) {return num;}
		int[] firstHalf=new int[num.length/2];
		int[] secondHalf=new int[num.length-num.length/2]; 
		for (int i=0;i<num.length/2;i++) {
			firstHalf[i] = num[i];
		}
		for(int i=num.length/2; i<num.length;i++) {
			secondHalf[i-num.length/2]=num[i];
		}
		
		firstHalf=mergeSort(firstHalf);
		secondHalf=mergeSort(secondHalf);
		
		return merge(firstHalf,secondHalf);
		
	}
	
	public static int[] merge(int[] nums1, int[] nums2) {
		int p =0;
		int q = 0;
		int[] res = new int[nums1.length+nums2.length];
		for(int i = 0; i<res.length;i++) {
			if(p<nums1.length && q<nums2.length) {
				if(nums1[p]<nums2[q]) {
					res[i]=nums1[p];
					p++;
				}
				else {
					res[i]=nums2[q];
					q++;
				}
			}
			else if(p<nums1.length) {
				res[i]=nums1[p];
				p++;
			}
			else if(q<nums2.length) {
				res[i]=nums2[q];
				q++;
			}
		}
		return res;
		
	}
}
