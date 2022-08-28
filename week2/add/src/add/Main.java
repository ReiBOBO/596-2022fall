package add;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(11,2313));
	}
	public static int add(int x, int y) {
		int c = 0;
		//get n digit of x and y
		int temp = x;
		int n =1;
		while(temp/10>=1) {
			n++;
			temp=temp/10;
		}
		 temp = y;
		 int m =1;
		while(temp/10>=1) {
			m++;
			temp=temp/10;
		}
		int f=Math.max(n, m);
		int[] a = new int[f];
		int[] b = new int[f];
		
		int[] z = new int[f+1];
		//add x to a
		temp=x;
		for(int i=f-1;i>=0;i--) {
			if(temp>=1) {
				a[i]=temp%10;
				temp=(temp-a[i])/10;
			}
			
		}
		//add y to b
		temp=y;
		for(int i=f-1;i>=0;i--) {
			if(temp>=1) {
			b[i]=temp%10;
			temp=(temp-b[i])/10;}
		}
		
		//calculate the final answer
		for(int i=f-1;i>=0;i--) {
			int s = a[i]+b[i]+c;
			z[i+1]=s%10;
			c=(s-z[i])/10;
		}
		z[0]=c;
		int res=0;
		//build a number from an array.
		for(int i=f;i>=0;i--) {
			res+=z[i]*Math.pow(10,f-i);
			
		}
		return res;
	}

}
