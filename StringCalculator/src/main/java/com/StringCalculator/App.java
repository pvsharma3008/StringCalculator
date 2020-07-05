package com.StringCalculator;


public class App 
{
    
	public int add(String number) {
		if(strisempty(number)) {
			return 0;
		}else if(number.contains(",")|| number.contains("\n")) {
			String[] num = number.split(",|\n");
			return strtoint(num[0])+ strtoint(num[1]);
		}else {
			return strtoint(number);
		}
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
