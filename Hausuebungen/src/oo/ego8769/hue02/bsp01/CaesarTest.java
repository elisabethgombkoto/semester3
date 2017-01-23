package oo.ego8769.hue02.bsp01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaesarTest {

	@Test
	public void test1Caesar() {
	Caesar Test= new Caesar(1);
	String getting=Test.encode("aa");
	
		if (getting.equals("bb")){
			System.out.println("Test successfully completed.");}
		else{
			System.out.println("Test1 NOT successfully completed.");}
	
	}
	@Test
	public void test2Caesar() {
	Caesar Test= new Caesar(2);
	String getting=Test.encode("zz");
	
	if (getting.equals("bb")){
	System.out.println("Test successfully completed.");}
	else{
		System.out.println("Test2 NOT successfully completed.");}
	}
	@Test
	public void test3Caesar() {
	Caesar Test= new Caesar(3);
	String getting=Test.encode("Aa");
	
	if (getting.equals("dd")){
	System.out.println("Test successfully completed.");}
	else{
		System.out.println("Test3 NOT successfully completed.");}
	}
	
	@Test
	public void test4Caesar() {
	Caesar Test= new Caesar(2);
	String getting=Test.encode("");
	
	if (getting.equals("")){
	System.out.println("Test successfully completed.");}
	else{
		System.out.println("Test4 NOT successfully completed.");}
	}
	@Test
	public void test5Caesar() {
	Caesar Test= new Caesar((-2));
	String getting=Test.encode("++");
	
	if (getting.equals("++")){
	System.out.println("Test successfully completed.");}
	else{
		System.out.println("Test5 NOT successfully completed.");}
	}
	
}