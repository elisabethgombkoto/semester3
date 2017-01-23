package oo.ego8769.hue02.bsp03;

import java.util.ArrayList;
import java.util.List;

public class password{
	
	
public static void createCodewords1(int nummber_student, int code_length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nummber_student; i++) {
		for (int j = 0; j < code_length; j++) {
	
			sb.append((char) ('a' + 26 * Math.random()));
		}
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
		}
	}	

public static void createCodewords2(int nummber_student, int code_length) {
		
List<String> list = new ArrayList<String>();
StringBuilder sb = new StringBuilder();
		
	for (int i = 0; i < nummber_student; i++) {
		for (int j = 0; j < code_length; j++) {
		sb.append((char) ('a' + 26 * Math.random()));
		}
		if (list.contains(sb.toString())) {
		i--;
		} else {
		System.out.println(sb.toString());
		sb.delete(0, sb.length());
		}
	}
}
}

