import java.util.Stack;

public class Main {
	static int count = 0;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Stack<Integer> A = new Stack<>();
		Stack<Integer> B = new Stack<>();
		Stack<Integer> C = new Stack<>();
		A.push(4);
		A.push(3);
		A.push(2);
		A.push(1);
		
		Hanoi(A,B,C,4);
		
		System.out.println(C.toString());
		System.out.println("count is :"+count);

	}
	
	public static void Hanoi(Stack<Integer> A, Stack<Integer> B, Stack<Integer> C, int n) {
		if(n==1) {
			int temp = A.pop();
			C.push(temp);
			count++;
			return;
		}
		else {
			Hanoi(A,C,B,n-1);
			Hanoi(A,B,C,1);
			Hanoi(B,A,C,n-1);
			
		}
		
		
	}

}
