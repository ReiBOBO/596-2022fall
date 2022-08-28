package sum;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(100));
	}
	public static int sum(int i) {
		if(i==1) {
			return 1;
		}
		
		return sum(i-1)+i;
		
	}
}
