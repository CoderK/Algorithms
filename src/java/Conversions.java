package java;
import java.util.HashMap;
import java.util.Scanner;

public class Conversions {
	
	/*
	 * http://algospot.com/judge/problem/read/CONVERT
	 **/
	
	 public static void main(String[] args) {
		
		 Scanner	scanner	=	new Scanner( System.in );
		 int	caseCnt	=	Integer.parseInt( scanner.nextLine() );
		 
		 HashMap<String, String> convertMap	=	new HashMap<String, String>();
		 convertMap.put( "kg", "2.2046 lb" );
		 convertMap.put( "l", "0.2642 g" );
		 convertMap.put( "lb", "0.4536 kg" );
		 convertMap.put( "g", "3.7854 l" );
		 
		 String		input		=	null;
		 String[]	temps		=	null;
		 String[]	conTemps	=	null;
		 double		value	=	0;
		 String		unit	=	null;
		 
		 String[]	inputArray	=	new String[ caseCnt ];
		 
		 for( int i = 0; i < inputArray.length; i++ ) {
			 input	=	scanner.nextLine();
			 inputArray[ i ]	=	input;
		 }
		 
		 for( int i = 0; i < inputArray.length; i++ ) {
			 temps	=	inputArray[ i ].split( " " );
			 value	=	Double.parseDouble( temps[ 0 ] );
			 unit	=	temps[ 1 ];
			 
			 conTemps	=	convertMap.get( unit ).split( " " );
			 
			 System.out.format( "%d %.4f %s\n", ( i + 1 ), value * Double.parseDouble( conTemps[ 0 ] ), conTemps[ 1 ] );
		 }
	}

}
