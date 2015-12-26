package P00033;

public class Fraction {
	private int bunja;
	private int bunmo;

	public Fraction(int bunja, int bunmo){
		this.bunja = bunja;
		this.bunmo = bunmo;
	}
	
	/**
	 * 문제에서 말하는 non-trivial 형태의 분수인지 확인합니다.
	 * new Fraction(49, 98).isNonTrivialForm() == true 
	 * @return
	 */
	public boolean isNotTrivialForm() {
		// case 1 bunja(1) == bunmo(2) && bunja(2) != bunmo(1)
		
		// case 2 bunj(2) == bunmo(1) && bunja(1) != bumno(2)
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fraction){
			Fraction f = (Fraction) obj;
			if(f.bunmo==this.bunmo &&f.bunja == this.bunja){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return bunja+" / "+bunmo;
	}
	
	public void reduct() {
		// 13 / 97   div(1)
		int divider = bunmo;
		if(bunja < bunmo){
			divider = bunja;
		}
		while(divider > 1){
//		while(!util.Uitl.isPrime(bunmo)||!util.Uitl.isPrime(bunja)){
			boolean canDivide = (bunmo%divider==0)&&(bunja%divider==0);
			if(canDivide){
				bunja/=divider;
				bunmo/=divider;
				break;
			}else{
				divider--;
			}
		}
	}

	public void mutiply(Fraction f) {
		int bunja = f.bunja;
		int bunmo = f.bunmo;
		
		this.bunja*=bunja;
		this.bunmo*=bunmo;
	}
	
}
