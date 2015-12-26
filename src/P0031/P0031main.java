package P0031;

public class P0031main {

	static int [] munit = {200,100,50,20,10,5,2,1};
	
	public static void main(String []args){
		int exchange = 200 ;
		int used = 0;
		int coinIndex = 0;
		
		int way = coin_sum(coinIndex, exchange, used);
		System.out.println(way);
	}
	public static int coin_sum(int coinIndex, int exchange, int used){
		if(exchange==0){
			return 1;
		}
		if(coinIndex>=munit.length){
			return 0;
		}
		int result =0;
		int nCoin = munit[coinIndex];
		int c = exchange/nCoin;
		coinIndex++;
		for(int n = 0; n<=c ; n++){
			int way =coin_sum(coinIndex, exchange-nCoin*n, nCoin*n);
			result+=way;
		}
		return result;
	}
	
	
	
	
}
