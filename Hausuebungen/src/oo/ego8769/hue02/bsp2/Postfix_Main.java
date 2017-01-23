package oo.ego8769.hue02.bsp2;

public class Postfix_Main {

	public static void main(String[] args) {
		String s="1234 5 +;";
		Postfix calculation =new Postfix(s);
		calculation.calculate();
		}

}
