package com.StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App 
{
    
	public int add(String number) {		
		if(strisempty(number)) {
			return 0;
		}else if(number.startsWith("//")) {
			String[] headerAndNumberSequence = number.split("\n", 2);
			String delimiter = parseDelimiter(headerAndNumberSequence[0]);
			Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(number);
			m.find();
			m.matches();
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
				throw new IllegalArgumentException("negatives not allowed: " + number);
			return strtoint(number);
		}
	}

	private String parseDelimiter(String header) {
		String delimiter = header.substring(2);
		if (delimiter.startsWith("[")) {
			delimiter = delimiter.substring(1, delimiter.length() - 1);
		}
		return Stream.of(delimiter.split("]\\["))
				.map(Pattern::quote)
				.collect(Collectors.joining("|"));
	}

	private int sumation(List<Integer> l) {
		int sum =0;
		String negtive = "";
		for(int i:l) {
			if(i<0)
				negtive += i;
			if(i>1000)
				continue;
			sum = sum+i;
			}
		if(!negtive.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed: " + negtive);
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
