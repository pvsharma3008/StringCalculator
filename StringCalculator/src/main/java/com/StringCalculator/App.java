package com.StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App 
{
    
	public int add(String number) {		
		if(strisempty(number)) {
			return 0;
		}else if(number.startsWith("//")) {
			
			Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(number);
			m.find();
			m.matches();
			String delimiter = m.group(1);
			String num = m.group(2);
			String[] s = splitedarray(num,delimiter);
			List<Integer> l = arrayToList(s);
			return sumation(l);
		}	
		else if(number.contains(",")|| number.contains("\n")) {
			String[] num = splitedarray(number,",|\n");
			List<Integer> l = arrayToList(num);
			return sumation(l);
		}else {
			if(strtoint(number)<0)
				throw new IllegalArgumentException("negative number: " + number);
			return strtoint(number);
		}
	}

	private int sumation(List<Integer> l) {
		int sum =0;
		String negtive = "";
		for(int i:l) {
			if(i<0)
				negtive += i;
			sum = sum+i;
			}
		if(!negtive.isEmpty()) {
			throw new IllegalArgumentException("negative number: " + negtive);
		}
		return sum;
	}
	private  List<Integer> arrayToList(String[] number) {
		List<Integer> list = new ArrayList<>();
		Arrays.stream(number).map(e -> strtoint(e)).forEach(e -> list.add(e));
		return list;
	}
	private String[] splitedarray(String num, String delimiter) {
		return num.split(delimiter);
		
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
