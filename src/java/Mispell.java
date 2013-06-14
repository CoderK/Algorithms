package java;
import java.util.Scanner;

public class Mispell {
	
	
	public static void main(String[] args) {
		 Scanner	scanner	=	new Scanner( System.in );
		 int	caseCnt	=	Integer.parseInt( scanner.nextLine() );
		 
		 
		 String		input	=	null;
		 String[]	temps	=	null;
		 
		 int	destIdx		=	0;
		 String	word		=	null;
		 
		 String[]	results	=	new String[ caseCnt ];
		 
		 for( int i = 0; i < caseCnt; i++ ) {
			 input	=	scanner.nextLine();
			 temps	=	input.split( " " );
			 
			 destIdx	=	Integer.parseInt( temps[ 0 ] ) - 1;
			 word		=	temps[ 1 ];
			 results[ i ]	=	word.substring( 0, destIdx ) + word.substring( ( destIdx + 1), word.length() );
		 }
		 
		 for( int j = 0; j < caseCnt; j++ ) {
			 System.out.println(  ( j + 1 ) + " " + results[ j ]);
		 }
	}

}
