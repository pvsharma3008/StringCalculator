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
			List<Integer> l = arrayToList(num);
			return sumation(l);
		}else {
			return strtoint(number);
		}
	}
	private int sumation(List<Integer> l) {
		int sum =0;
		for(int i:l)
			sum = sum+i;
		return sum;
	}
	private  List<Integer> arrayToList(String[] number) {
		List<Integer> list = new ArrayList<>();
		Arrays.stream(number).map(e -> strtoint(e)).forEach(e -> list.add(e));
		return list;
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
