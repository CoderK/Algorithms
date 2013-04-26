package kr.co.plask.common.constants;

import java.util.Scanner;

public class LIS {

	/*
	* http://algospot.com/judge/problem/read/LIS
	*/
	
	private Scanner	scanner	=	new Scanner( System.in );
	
	public void start() {
		int	caseCnt	=	Integer.parseInt( scanner.nextLine() );
		
		int		elementCnt	=	0;
		int[] 	elements	=	null;
		
		Scanner	tokenizer	=	null;
		int	idx	=	0;
		
		while( caseCnt-- > 0 ) {
			idx	=	0;
			elementCnt	=	Integer.parseInt( scanner.nextLine() );
			elements	=	new int[ elementCnt ];

			tokenizer	=	new Scanner( scanner.nextLine() );
			while( tokenizer.hasNext() ) {
				elements[ idx++ ] =	Integer.parseInt( tokenizer.next() );
			}
			
			
			/* 여기부터 솔루션 */
			final int LEN	=	elements.length;
			int[]	results	=	new int[ LEN ];
			
			for( int i = 0; i < LEN; i++ ) results[ i ] = 1;
			
			for( int i = 0;  i < LEN; i++ ) {
				for( int j = 0; j < i; j++  ) {
					if( elements[ i ] > elements[ j ] && results[ i ] < results[ j ] + 1 ) {
						results[ i ]	=	results[ j ] + 1;
					}
				}
				
			}

			int		longest	=	0;
			for( int val : results ) {
				if( val > longest ) {
					longest = val;
				}
			}
			
			System.out.println( longest );
			
		}
	}
	
	public static void main(String[] args) {
		new LIS().start();
	}

}
