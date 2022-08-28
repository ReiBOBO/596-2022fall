
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mul(33333,999));
	}
	public static int mul(int x, int y) {
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
		int[] a = new int[n];
		int[] b = new int[m+1];
		
		//add x to a
		temp=x;
		for(int i=n-1;i>=0;i--) {
			if(temp>=1) {
				a[i]=temp%10;
				temp=(temp-a[i])/10;
			}
			
		}
		//add y to b
		temp=y;
		for(int i=m;i>=0;i--) {
			if(temp>=1) {
			b[i]=temp%10;
			temp=(temp-b[i])/10;}
		}
		int[][] holder = new int[n][m+1];
		int res=0;
		
		//calculation step
		for(int i =n-1; i>=0;i--) {
			c=0;
			for(int j=m; j>=1;j--) {
				int p = c + a[i]*b[j];
				holder[i][j]=p%10;
				c=(p-holder[i][j])/10;
			}
			holder[i][0]=c;
			int cur=0;
			for(int g=m; g>=0;g--) {
				cur += holder[i][g] * Math.pow(10, m-g);
				
			}
			res+= cur * Math.pow(10, n-1-i);
		}
		return res;
	}
}
