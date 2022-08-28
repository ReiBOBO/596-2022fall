import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res =new ArrayList<>();
		res.add(1);
		res.add(3);
		res.add(5);
		res.add(2);
		res.add(4);
		res.add(6);
		HashMap<List<Integer>,Integer> countInv= sortAndCountInv(res);
		for(Map.Entry<List<Integer>, Integer> e :countInv.entrySet()) {
			for(int i=0; i<e.getKey().size();i++) {
				System.out.println(e.getKey().get(i));
			}
			System.out.println("The number of inversions is: "+e.getValue());
		}
	}
	
	public static HashMap<List<Integer>,Integer> sortAndCountInv(List<Integer> a){
		if(a.size()==0 || a.size()==1) {
			HashMap<List<Integer>,Integer> res= new HashMap<>();
			res.put(a, 0);
			return res;
		}
		
		int half = a.size()/2;
		List<Integer> c = new ArrayList<Integer>();
		List<Integer> d = new ArrayList<Integer>();
		HashMap<List<Integer>, Integer> firsthalf = new HashMap<>();
		HashMap<List<Integer>, Integer> secondhalf = new HashMap<>();
		HashMap<List<Integer>, Integer> res = new HashMap<>();

		for(int i =0; i<half;i++) {
			c.add(a.get(i));
		}
		for(int i=half;i<a.size();i++) {
			d.add(a.get(i));
		}
		firsthalf  = sortAndCountInv(c);
		secondhalf = sortAndCountInv(d);
		res = mergeAndCountSplitInv(firsthalf,secondhalf);
		return res;
		
	}
	
	public static  HashMap<List<Integer>,Integer> mergeAndCountSplitInv(HashMap<List<Integer>, Integer>a, HashMap<List<Integer>, Integer> b){
		ArrayList<Integer> c =new ArrayList<>();
		ArrayList<Integer> d =new ArrayList<>();
		int cInv=0;
		int dInv=0;
		HashMap<List<Integer>,Integer> res = new HashMap<>();
		int mInv=0;
		ArrayList<Integer> m = new ArrayList<>();
		for(Map.Entry<List<Integer>, Integer> e :a.entrySet()) {
			c=(ArrayList<Integer>) e.getKey();
			cInv=e.getValue();
		}
		for(Map.Entry<List<Integer>, Integer> e :b.entrySet()) {
			d=(ArrayList<Integer>) e.getKey();
			dInv=e.getValue();
		}
		int p=0;
		int q=0;
		for(int i=0;i<c.size()+d.size();i++) {
			if(p<c.size() && q<d.size()) {
				if(c.get(p)<d.get(q)) {
					m.add(c.get(p));
					p++;
				}
				else {
					m.add(d.get(q));
					q++;
					mInv+=c.size()-p;
				}
			}
			else if(p<c.size()) {
				m.add(c.get(p));
				p++;
			}
			else if(q<d.size()) {
				m.add(d.get(q));
				q++;
			}
		}
		
		res.put(m, mInv+cInv+dInv);
		return res;
		
	}
}
