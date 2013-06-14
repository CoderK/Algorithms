package java;
import java.util.Arrays;
import java.util.Scanner;

public class CombinationBitWise {
	
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
			 * n媛쒖쓽 �먯냼�먯꽌 m媛쒕� 爰쇰깂.
			 **/
			n		=	Integer.parseInt( temps[ 0 ] );
			m		=	Integer.parseInt( temps[ 1 ] );
			
			if( n < m ) {
				System.out.println( "�λ궃�섎깘 �쒕�濡��낅젰�대씪��" );
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
	 * int 諛곗뿴 蹂듭궗
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
	 * �ш��⑥닔濡�議고빀 援ы븯湲�	 **/
	private void combinate( int srcChecker, int[] combArray, int n, int m, int curIdx ) {
		curIdx++;
		
		if( curIdx == m ) {
			System.out.println( Arrays.toString( combArray ) );
			return;
		}
		
		int	newChecker		=	0;
		int[] newCombArray	=	null;
		
		for( int i = 0; i < n; i++ ) {
			/* �덈줈��諛곗뿴��留뚮뱾�댁꽌 �댁슜�섏� �딆쑝硫�媛믪씠 李몄“媛��섎뒗 臾몄젣 諛쒖깮 */
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
