package com.StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App 
{
    
	public int add(String number) {
		if(strisempty(number)) {
			return 0;
		}else if(number.contains(",")|| number.contains("\n")) {
			String[] num = number.split(",|\n");
			List<Integer> l = new ArrayList<>();
			int sum=0;
			Arrays.stream(num).map(e -> Integer.parseInt(e)).forEach(e -> l.add(e) );
			for(int i:l)
				sum = sum+i;
			return sum;
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
