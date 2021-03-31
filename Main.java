package kpi.fict.it03;

public class Main {
	
	public static void main(String args[]) {
		CSLList<Integer> list = new CSLList<>();
		list.append(1);
		list.append(2);
		list.append(3);
		list.insert(0, 0);
		
		
		System.out.println(list.summ());
	}
}
