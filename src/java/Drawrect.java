package java;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Drawrect {
	
	/*
	 * http://algospot.com/judge/problem/read/DRAWRECT
	 * 
	 * refactoring ? ?, ?? main? ? ???? ??. ? 
	 **/
	
	public static void main(String[] args) {
		Scanner		scanner	=	new Scanner( System.in );
		int			caseCnt	=	Integer.parseInt( scanner.nextLine() );
		String[]	result	=	new String[ caseCnt ];
		
		for( int i = 0; i < caseCnt; i++ ) {
			String		inputPoint	=	null;
			String[]	temps		=	null;
			String		x			=	null;
			String		y			=	null;
			
			HashMap<String, Integer> pointsX	=	new HashMap<String, Integer>();
			HashMap<String, Integer> pointsY	=	new HashMap<String, Integer>();
			
			for( int j = 0; j < 3; j++ ) {
				inputPoint	=	scanner.nextLine();
				temps		=	inputPoint.split( " " );
				
				x	=	temps[ 0 ];
				y	=	temps[ 1 ];
				
				/* ?? ??. ???? ?? */
				if( pointsX.get( x ) == null ) {
					pointsX.put( x, 1 );
				} else {
					pointsX.put( x, pointsX.get( x ) + 1 ); 
				}
				
				if( pointsY.get( y ) == null ) {
					pointsY.put( y, 1 );
				} else {
					pointsY.put( y, pointsY.get( y ) + 1 );
				}
			}
			
			String	key		=	null;
			StringBuffer	resBuff	=	new StringBuffer();

			/* ?? ??. ???? ?? */
			Iterator<String> 	it	=	pointsX.keySet().iterator();
			while( it.hasNext() ) {
				key		=	it.next();
				
				if( pointsX.get( key ) < 2 ) {
					resBuff.append( key ).append( " " );
				}
			}
			
			it	=	pointsY.keySet().iterator();
			while( it.hasNext() ) {
				key		=	it.next();
				
				if( pointsY.get( key ) < 2 ) {
					resBuff.append( key ).append( " " );
				}
			}
			
			result[ i ] = resBuff.toString().substring( 0, resBuff.length() - 1 );
		}
		
		/* ??? ?? */
		for( String s : result ) {
			System.out.println( s );
		}
	}
}
