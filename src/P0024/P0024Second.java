package P0024;

public class P0024Second {
	public static void main(String[] args) {
		Pnode n012 = new Pnode("", "012 ", 0);
		//012 0
        //021 1
		//102 2
		//120 3
		//201
		//210
//		Pnode nth = n012.find(3);
//		System.out.println(n012 == nth);
//		System.out.println(nth.getCurrent() + nth.getNums());
		Pnode root = new Pnode("", "0123456789", 0);
//		
		Pnode answerNode = root.find( 1_000_000 -1  );
		System.out.println(answerNode.getCurrent() + answerNode.getNums()); //10!
//		
//		Pnode abc = new Pnode("", "abc", 0);
//		System.out.println(abc.getLength()); // 3!
		
		/*
		 *       c0 = new Pnode( "0", "123456789", 0 * 9! );
		 *                   new Pnode( "01", "234567890", 0*8! );
		 *                        ...
		 *                              ...
		 *                                 ...
		 *                                    new Pnode("01234567890", "", 3323);
		 *                   new Pnode( "02", "134567890", 1*8! );
		 *                   
		 *       c1 new Pnode( "1", "023456789", 1 * 9! );
		 *       c2 new Pnode(root, "2", "013456789", 2 * 9! );
		 *               ....
		 *       c9 new Pnode(root, "9", "012345678", 9 * 9! );
		 */
	}
}
