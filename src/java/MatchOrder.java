package java;
import java.util.Arrays;
import java.util.Scanner;

public class MatchOrder {
	
	private Scanner scanner	=	new Scanner(System.in);
	
	public void matchOrder() {
		int caseCnt	=	Integer.parseInt(scanner.nextLine());
		int n = 0;
		
		int[] otherTeam	=	null;
		int[] ourTeam	=	null;
		
		Scanner	tokenizer	=	null;
		int	result	=	0;
		
		while( caseCnt-- > 0 ) {
			n 	= Integer.parseInt(scanner.nextLine());

			tokenizer	=	new Scanner( scanner.nextLine() );
			otherTeam 	=	this.parseTeamRating(tokenizer, n);
			
			tokenizer	=	new Scanner( scanner.nextLine() );
			ourTeam		=	this.parseTeamRating(tokenizer, n);
			
			Arrays.sort(otherTeam);
			Arrays.sort(ourTeam);

			result = this.maxWinningCount(otherTeam, ourTeam);
			System.out.println( result );
		}
	}
	
	public int maxWinningCount( int[] otherTeam, int[] ourTeam ) {
		final int N = otherTeam.length;
		int ourIdx = 0;
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			
			while( ourIdx < N ) {
				if( otherTeam[i] <= ourTeam[ourIdx++] ) {
					result++;
					break;
				}
			}
		}
		
		return result;
	}
	
	private int[] parseTeamRating(Scanner tokenizer, int n) {
		int[] teamRating = new int[n];
		int idx = 0;
		while( tokenizer.hasNext() ) {
			teamRating[idx++] =	Integer.parseInt( tokenizer.next() );
		}
		
		return teamRating;
	}
	
	public static void main(String[] args) {
		MatchOrder mo	=	new MatchOrder();
		mo.matchOrder();
	}
	
	
}
