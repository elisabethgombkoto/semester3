package oo.ego8769.sem8.coffeShop;

public class Cafe {
	public static void main(String[] args) {
		Person person = new Person();
		CoffeeCup cup = new CoffeeCup(86); /* use 86 degree for initialisation */

		/*
		 * Version 1
		 */
		assert (cup != null);
		person.drinkV1(cup);
		// We do not know if there was a problem!

		/*
		 * Version 2, use drinkV2
		 */

		/*
		 * Version 3, use drinkV3
		 */

		/*
		 * Version 4, use drinkV4
		 */

		/*
		 * Version 4.1, use drinkV4, offer a refill in any case
		 */
	}
}
