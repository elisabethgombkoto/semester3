package oo.ego8769.hue02.bsp2;

import static org.junit.Assert.*;

import org.junit.Test;

import oo.ego8769.hue02.bsp01.Caesar;

public class Postfix_MainTest {

	//returns 1239
		@Test
		public void testSchoolAdd() {
			String string = "1234 5 + ;";
			Postfix calculation = new Postfix(string);
			int nummber=calculation.calculate();
			if (nummber==(1239)){
				System.out.println("Test successfully completed.");}
			else{
				System.out.println("Test1 NOT successfully completed.");}
		}
		// returns 55
		@Test
		public void testWrongString() {
			String string = "55 77 ;";
			Postfix calculation = new Postfix(string);
			int nummber=calculation.calculate();
			if (nummber==(55)){
				System.out.println("Test successfully completed.");}
			else{
				System.out.println("Test1 NOT successfully completed.");}
		}
		// returns 1059
		@Test
		public void testSchoolSub() {
			String string = "1234 175 - ;";
			Postfix calculation = new Postfix(string);
			int nummber=calculation.calculate();
			if (nummber==(1059)){
				System.out.println("Test successfully completed.");}
			else{
				System.out.println("Test1 NOT successfully completed.");}
		}
		// returns 6170
		@Test
		public void testSchoolMult() {
			String string = "1234 5 * ;";
			Postfix calculation = new Postfix(string);
			int nummber=calculation.calculate();
			if (nummber==(6170)){
				System.out.println("Test successfully completed.");}
			else{
				System.out.println("Test1 NOT successfully completed.");}
		}
		// returns 246
		@Test
		public void testSchoolDiv() {
			String string = "1234 5 / ;";
			Postfix calculation = new Postfix(string);
			int nummber=calculation.calculate();
			if (nummber==(246)){
				System.out.println("Test successfully completed.");}
			else{
				System.out.println("Test1 NOT successfully completed.");}
		}
}
