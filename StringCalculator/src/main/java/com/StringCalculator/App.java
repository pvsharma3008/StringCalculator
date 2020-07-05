package com.StringCalculator;


public class App 
{
    
	public int add(String number) {
		if(strisempty(number)) {
			return 0;
		}
		return strtoint(number) ;
	}
	
	private boolean strisempty(String num) {
		return num.isEmpty();		
	}
	private int strtoint(String num) {
		return Integer.parseInt(num);
	}
	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    
}
