
public class MainA {

	public static void main(String[] args) {
		
		SearchTree s1 = new SearchTree();
		s1.add("MUdra");
		s1.add("Milind");
		s1.add("kaushal");
		s1.add("muskan");
		s1.add("ashwati");
		s1.add("shardul");
		s1.add("gaurav");
		s1.add("pallavi");
		s1.add("alen");
		s1.add("limysh");
		s1.add("dhruv");
		s1.add("rishi");
		s1.add("Anirudh");
		
		int d = s1.find("rishi");
		System.out.println(d);

		int r = s1.find("rishi");
		System.out.println(r);

		int p = s1.find("rishi");
		System.out.println(p);

		int q = s1.find("rishi");
		System.out.println(q);
		
		String s4 = s1.printTree();
		System.out.println(s4);
		
		int s = s1.find("anirudh");
		System.out.println(s);

		String s7 = s1.printTree();
		System.out.println(s7);

		int b = s1.find("gaurav");
		System.out.println(b);
		
		int c = s1.find("limysh");
		System.out.println(c);

		int t = s1.find("shardul");
		System.out.println(t);

		String s9 = s1.printTree();
		System.out.println(s9);

	}

}
