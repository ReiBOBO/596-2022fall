package greedy;

import java.util.PriorityQueue;

class HuffmanNode{
	int frequency;
	char c;
	HuffmanNode left;
	HuffmanNode right;
	public HuffmanNode(char c,int f) {
		this.frequency=f;
		this.c=c;
		this.left=null;
		this.right=null;
	}
}
class HuffmanAlgo{
	public static void printCode(HuffmanNode root, String s) {
		if( root == null) {return;}
		if(root.left==null && root.right==null) {
			System.out.println(root.c+" has code: "+s);
			return;
		}
		printCode(root.left,s+0);
		printCode(root.right,s+1);
		
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        PriorityQueue<HuffmanNode> q=new PriorityQueue<>((a,b)-> a.frequency-b.frequency);
        for(int i=0; i<n;i++) {
        	HuffmanNode node = new HuffmanNode(charArray[i],charfreq[i]);
        	q.add(node);
        }
        HuffmanNode root =null;
        while(q.size()>1) {
        	HuffmanNode a = q.poll();
        	HuffmanNode b = q.poll();
        	HuffmanNode ab = new HuffmanNode('-',a.frequency+b.frequency);
        	ab.left=a;
        	ab.right=b;
        	q.add(ab);
        }
        root=q.poll();
        HuffmanAlgo.printCode(root,"");
	}

}
