package java;
import java.util.HashMap;
import java.util.Scanner;

public class URIDecoding {
	
	/*
	 * http://algospot.com/judge/problem/read/URI
	 **/
	
	public static void main(String[] args) {
		Scanner	scanner	=	new Scanner( System.in );
		int		caseCnt	=	Integer.parseInt( scanner.nextLine() );

		String[]	result	=	new String[ caseCnt ];
		String		input	=	null;
		
		String	oldChar	=	null;
		String	newChar	=	null;
		
		HashMap<String, String> asciiChars	=	new HashMap<String, String>();
		asciiChars.put( "%20", " " );
		asciiChars.put( "%21", "!" );
		asciiChars.put( "%24", "$" );
		asciiChars.put( "%25", "%" );
		asciiChars.put( "%28", "(" );
		asciiChars.put( "%29", ")" );
		asciiChars.put( "%2a", "*" );
		
		StringBuffer	sb	=	null;
		
		for( int i = 0; i < caseCnt; i++ ) {
			input	=	scanner.nextLine();
			sb		=	new StringBuffer();
			
			for( int j = 0; j < input.length(); j++ ) {
				if( input.charAt( j ) == '%' && j < input.length() - 2 ) {
					oldChar		=	input.substring( j, j + 3 );
					newChar		=	asciiChars.get( oldChar );
					
					if( newChar != null ) {
						sb.append( newChar );
						j =	j + 2;
					}
				} else {
					sb.append( input.charAt( j ) );
				}
			}
			result[ i ]	=	sb.toString();
		}
		
		for( String s : result ) {
			System.out.println( s );
		}
	}
		
}
