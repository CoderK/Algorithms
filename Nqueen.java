package first;

import java.util.Scanner;

public class Nqueen {
	
	private int	resultCnt;
	
	public void backtrack( int[] resultArray, int idx, int n ) {
		int 	ncandidates	=	0;	// 다음위치 후보
		int[] 	c	=	new int[ n ];
		int		i	=	0;
		
		if( idx == n ) {
			resultCnt++;
			
		} else {
			idx++;
			ncandidates	=	constructCandidates( resultArray, idx, n, c, ncandidates );
			
			for(i = 0; i < ncandidates; i++) {
				resultArray[idx] = c[i];
				this.backtrack(resultArray, idx, n);
			}
		}
	}
	
	private int constructCandidates( int[] result, int rows, int cols, int[] c, int ncandidates ) {
		int	i = 1, j = 1;
		boolean canMove	=	true;
		ncandidates	=	0;
		
		for( i = 1; i <= cols; i++ ) {		// 열
			canMove	=	true;
			
			/* 이부분이 중요 */
			for( j = 1; j < rows; j++ ) {	// 행
				if( Math.abs( (rows) - j ) == Math.abs( i - result[j] ) || i == result[ j ] ) {
					canMove	=	false;
					break;
				}
			}
			
			if( canMove ) {
				c[ ncandidates ] = i;
				ncandidates	=	ncandidates + 1;
			}
		}
		
		return ncandidates;
	}
	
	public static void main(String[] args) {
		Scanner scanner	=	new Scanner( System.in );
		
		int	caseCnt		=	Integer.parseInt( scanner.nextLine() );
		int n			=	0;
		
		Nqueen	nqueen		=	new Nqueen();
		int[]	resultArray	=	null;
		
		for(int i = 0; i < caseCnt; i++) {
			n			=	Integer.parseInt( scanner.nextLine() );
			resultArray =	new int[n + 1];
			nqueen.resultCnt	=	0;
			nqueen.backtrack(resultArray, 0, n);

			System.out.println( nqueen.resultCnt );
		}
	}

}
