package oo.ego8769.hue04.bsp1;

import java.util.ArrayList;
import java.util.Date;





public class Person {

	private Name _name; // hier werden variable namen mit datentyp definieren
	private Gender _gender;
	private Date _birthsDay;
	private MarriedCouples _marriedCouple;
	

	public Person(Name name, Gender gender, Date birthsday) {// hier komme die
																// Werte von den
																// Variablen //
																// variablen
		_name = name;
		_gender = gender;
		_birthsDay = birthsday;
	}

	public void changeSurName(Person person) {// TODO finish me
		if (isFemale()) {
			_name.set_lastName(person._name.get_lastName());
		}
	}

	public void changeBackToUnmarriedName() {// TODO check me!!!
												// Finish me!!!
		if (isFemale()) {
			if (isFemale()) {// if woman change to unmarried name
				_name.set_lastName(_name.get_unmarriedName());
			}
		}
	}

	public boolean isFemale() {
		if (_gender.equals(Gender.female))
			return true;
		{
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public int getAge() {
		long ageInMillis = new Date().getTime() - getBirthDate().getTime();

		Date age = new Date(ageInMillis);

		return age.getYear();
	}

	private Date getBirthDate() {
		return _birthsDay;
	}

	public boolean isUnMarried() {
		return _marriedCouple==null;
	}

	public void set_marriedCouple(MarriedCouples marriedCouple) {
		_marriedCouple = marriedCouple;
	}
	
		
	
	public MarriedCouples getMarriedCouple() {
		return _marriedCouple;
	}
	

}
