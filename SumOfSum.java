package kr.co.plask.common.constants;

import java.util.Scanner;

public class SumOfSum {
	
	private Scanner	scanner	=	new Scanner( System.in );
	
	/*
	 * 1 + 2.... + n 까지 합계 구하는 메서드
	 **/
	public int sum( int n ) {
		int	total	=	0;
		for( int i = 1; i <= n; i++ ) {
			total	+=	i;
		}
		
		return total;
	}
	
	/*
	 * sum(1) + sum(2).... + sum(n)의 합계 구하는 메서드
	 **/
	public int sos( int n ) {
		int	total	=	0;
		for( int i = 1; i <= n; i++ ) {
			total	+=	this.sum( i );
		}
		
		return total;
	}
	
	public int inputCaseCnt() {
		int	caseCnt	=	Integer.parseInt( this.scanner.nextLine() );
		return caseCnt;
	}
	
	public int inputNumber() {
		int	input	=	Integer.parseInt( scanner.nextLine() );
		return input;
	}
	
	public void start() {
		int	caseCnt	=	this.inputCaseCnt();
		int	number	=	0;
		int	result	=	0;
		
		while( caseCnt-- > 0 ) {
			number	=	this.inputNumber();
			result	=	this.sos( number );
			
			System.out.println( result );	
		}
	}
	
	public static void main(String[] args) {
		new SumOfSum().start();
	}
	
}
