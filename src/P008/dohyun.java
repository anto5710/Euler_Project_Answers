package P008;

public class dohyun {
	public static void main(String[] args) {
	
		System.out.println(getMultipy("234"));
//		String source = "73167176531330624919225119674426574742355349194934"
//				+ "96983520312774506326239578318016984801869478851843"
//				+ "85861560789112949495459501737958331952853208805511"
//				+ "12540698747158523863050715693290963295227443043557"
//				+ "66896648950445244523161731856403098711121722383113"
//				+ "62229893423380308135336276614282806444486645238749"
//				+ "30358907296290491560440772390713810515859307960866"
//				+ "70172427121883998797908792274921901699720888093776"
//				+ "65727333001053367881220235421809751254540594752243"
//				+ "52584907711670556013604839586446706324415722155397"
//				+ "53697817977846174064955149290862569321978468622482"
//				+ "83972241375657056057490261407972968652414535100474"
//				+ "82166370484403199890008895243450658541227588666881"
//				+ "16427171479924442928230863465674813919123162824586"
//				+ "17866458359124566529476545682848912883142607690042"
//				+ "24219022671055626321111109370544217506941658960408"
//				+ "07198403850962455444362981230987879927244284909188"
//				+ "84580156166097919133875499200524063689912560717606"
//				+ "05886116467109405077541002256983155200055935729725"
//				+ "71636269561882670428252483600823257530420752963450";
		String source = "123456789"; // 42
		long digit = 2;
		System.out.println(	getLargest(source, digit));
		
	}

	/**
	 *         p0             P1
	 *      7163626956188267042825248360082325
	 * 
	 * @param source
	 * @param digit
	 * @return
	 */
	private static long getLargest(String source, long digit) {

		long Ml = 0;

		long Cl = 0;
		long biggest = 0;
		long size = source.length();
		int slot = 0;

		String CurrentSlot = "";
		for (slot = 0; slot + digit <= size; slot++) { // 잠재적 버그
			CurrentSlot = "";
			for (int c = 0; c < digit; c++) {
				CurrentSlot = CurrentSlot + source.charAt(c + slot);

			}
			Cl = getMultipy(CurrentSlot);
			if (Cl > Ml) {
				biggest = Cl;
				Ml = Cl;
			}
		}
		//
		return biggest;
	}
	
	/**
	 * "234" = 24
	 * @param Num
	 * @return
	 */
	private static long getMultipy(String Num) {
		long result = 1;
		
		for (int i = 0; i < Num.length() ; i++) {
			result = result * toNum(Num.charAt(i)); // 꼼수: '2' - '0' --> 2, '9' - '0' = 9
			
			if ( result == 0 ){
				return result;
			}
			
		}
		return result;
	}
	
	private static int toNum ( char num ) {
		return num - '0';
	}
}
