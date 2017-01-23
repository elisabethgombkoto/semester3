package oo.ego8769.hue04.bsp2;

import oo.ego8769.hue04.bsp1.Person;

public class Account {

	private int _accountNummber;
	private Person _person;
	private static int _interestTrade;
	private int _accountBalance;

	public Account(Person person, int accountNummber, int accountBalance, int interrestTrade) {
		_person = person;
		_accountNummber = accountNummber;
		_accountBalance = accountBalance;
		_interestTrade = interrestTrade;
	}

	public void toDrawMoney() {
		// if Client.classIsLegal()&&

	}

	public int getAccountNummber() {
		return getAccountNummber();
	}

	public void setAccountNummber(int accountNummber) {
		this._accountNummber = accountNummber;
	}

}
