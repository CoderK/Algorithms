package java;
import java.util.Scanner;

public class Endians {
	
	public static void main(String[] args) {
		Scanner	scanner	=	new Scanner( System.in );
		int	caseCnt	=	Integer.parseInt( scanner.nextLine() );
		
		long[]	result	=	new long[ caseCnt ];
		
		for( int k = 0; k < result.length; k++ ) {
			long val	=	Long.parseLong( scanner.nextLine() );
			StringBuffer	little	=	new StringBuffer();
			
			for( int i = 31; i >= 0; i-- ) {
				little.append( ( val >> i ) & 1 );
				
				if( ( i % 8 ) == 0 ) {
					little.append( " " );
				}
			}
			
			
			String[] 		temps	=	little.toString().split( " " );
			StringBuffer	big	=	new StringBuffer();			
			
			for( int j = temps.length - 1; j >= 0; j-- ) {
				big.append( temps[ j ] );
			}
			
			result[ k ] =	Long.parseLong( big.toString(), 2 );
		}
		
		for( long val : result ) {
			System.out.println( val );
		}
	}	

}
