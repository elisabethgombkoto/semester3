package oo.ego8769.sem8.coffeShop;

public class Person {
	private static final int TOO_COLD = 65;
	private static final int TOO_HOT = 85;

	/*
	 * Version 1: Print message on the screen
	 */
	public void drinkV1(CoffeeCup cup) {
		int temperature = cup.getTemperature();
		if (temperature <= TOO_COLD) {
			System.out.println("Coffee is too cold!");
			return;
		} else if (temperature >= TOO_HOT) {
			System.out.println("Coffee is too warm!");
			return;
		}

		while (!cup.isEmpty()) {
			cup.takeASip();
			System.out.println("Ahhh. Tasty!");
		}
	}

	// /* Version , Use Exception
	// */
	// public void drinkV2(CoffeeCup cup) throws Exception {
	// }

	// /* Version 3, Use user defined exception TemperatureException
	// */
	// public void drinkV3(CoffeeCup cup) throws TemperatureException {
	// }

	// /* Version 4, User defined exception TooHotException, TooColdException
	// * allowing specific reactions
	// */
	// public void drinkV4(CoffeeCup cup) throws TooHotException,
	// TooColdException {
	// }
}
