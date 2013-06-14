package java;
import java.util.Scanner;

public class Fibonacci {
	
	private int[]	zeroCnt	=	null;
	private int[]	oneCnt	=	null;
	
	private Scanner	scanner	=	new Scanner( System.in );
	
	private int inputCaseCnt() {
		int	caseCnt	=	Integer.parseInt( this.scanner.nextLine() );
		return caseCnt;
	}
	
	private int inputNumber() {
		int	input	=	Integer.parseInt( scanner.nextLine() );
		return input;
	}
	
	public void start() {
		int	caseCnt	=	this.inputCaseCnt();
		int	number	=	0;
		
		while( caseCnt-- > 0 ) {
			number	=	this.inputNumber();
			this.getZeroAndOnePrintCnt( number );
		}
	}
			
	/**
	 * @Method Name	: getZeroAndOnePrintCnt
	 * @작성일		: 2013. 4. 2. 
	 * @작성자		: bejjang2
	 * @변경이력		:
	 * @Method 설명	: fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오. 
	 */
	private void getZeroAndOnePrintCnt( int n ) {
		zeroCnt	=	new int[ n + 2 ];
		oneCnt	=	new int[ n + 2 ];
		
		zeroCnt[ 0 ]	=	1;
		zeroCnt[ 1 ]	=	0;
		oneCnt[ 0 ]		=	0;
		oneCnt[ 1 ]		=	1;
		
		for( int i = 2; i <= n; i++ ) {
			zeroCnt[ i ]	=	zeroCnt[ i - 1 ] + zeroCnt[ i - 2 ];
			oneCnt[ i ]		=	oneCnt[ i - 1 ] + oneCnt[ i - 2 ];
		}
		
		System.out.println( zeroCnt[ n ] + " " + oneCnt[ n ] );
	}
	
	public static void main(String[] args) {
		new Fibonacci().start();
	}

}
