package kr.co.plask.common.constants;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationBitWise {
	
	/*
	 * 1 <= n <= 32 범위를 가정하고 비트와이즈 연산을 이용해서 풀었심.
	 **/
	private Scanner	scanner	=	new Scanner( System.in );
	
	public int inputCaseCnt() {
		int	caseCnt	=	Integer.parseInt( this.scanner.nextLine() );
		return caseCnt;
	}
	
	public String[] inputNumber() {
		String[]	temps	=	scanner.nextLine().split( " " );
		return temps;
	}
	
	public void start() {
		int	caseCnt	=	this.inputCaseCnt();
		int	n		=	0;
		int	m		=	0;
		
		String[]	temps	=	null;
		
		while( caseCnt > 0 ) {
			temps	=	this.inputNumber();
			
			/*
			 * n개의 원소에서 m개를 꺼냄.
			 **/
			n		=	Integer.parseInt( temps[ 0 ] );
			m		=	Integer.parseInt( temps[ 1 ] );
			
			if( n < m ) {
				System.out.println( "장난하냐 제대로 입력해라잉." );
				continue;
			}
					
			long	begin	=	System.currentTimeMillis();
			this.printAllOfCombination( n, m );	
			caseCnt--;
			System.out.println( System.currentTimeMillis() - begin );
		}
	}
	
	private void printAllOfCombination( int n, int m ) {
		int[]	combArray	=	null;
		int		checker	=	0;
		
		int	curIdx	=	0;
		for( int i = 0; i < n; i++ ) {
			checker		=	0;
			combArray	=	new int[ m ];
			
			checker	=	checker | ( 1 << i );
			combArray[ curIdx ]	=	( i + 1 );
			
			this.combinate( checker, combArray, n, m, curIdx );
		}
	}
	
	/*
	 * int 배열 복사
	 **/
	private int[] arrayCopy( final int[] srcArray ) {
		final int LEN	=	srcArray.length;
		
		int[] newArray	=	new int[ LEN ];
		for( int j = 0; j < LEN; j++ ) {
			newArray[ j ]	=	srcArray[ j ];
		}
		
		return newArray;
	}
	
	/*
	 * 재귀함수로 조합 구하기
	 **/
	private void combinate( int srcChecker, int[] combArray, int n, int m, int curIdx ) {
		curIdx++;
		
		if( curIdx == m ) {
			System.out.println( Arrays.toString( combArray ) );
			return;
		}
		
		int	newChecker		=	0;
		int[] newCombArray	=	null;
		
		for( int i = 0; i < n; i++ ) {
			/* 새로운 배열을 만들어서 이용하지 않으면 값이 참조가 되는 문제 발생 */
			newChecker		=	srcChecker;
			newCombArray	=	this.arrayCopy( combArray );
			
			if( ( ( newChecker & ( 1 << i ) ) ) > 0 ) {
				continue;
			}
			
			newChecker	=	newChecker | ( 1 << i );
			newCombArray[ curIdx ]		=	( i + 1 );
			
			this.combinate( newChecker, newCombArray, n, m, curIdx );
		}
	}
	
	
	public static void main(String[] args) {
		new CombinationBitWise().start();
	}

}
