package oo.ego8769.hue04.bsp1.angepasst.an.feedback;

import java.util.Date;

import oo.ego8769.hue04.bsp1.Gender;
import oo.ego8769.hue04.bsp1.MaritalStatus;
import oo.ego8769.hue04.bsp1.MarriedCouples;
import oo.ego8769.hue04.bsp1.Name;

public class Person {

	private Name _name;
	private Date _bDate;
	private Gender _gender;
	private MaritalStatus _maritalStatus;
	private Person _couple;

	public Person(Name name, Date bDate, Gender gender) {
		this._name = name;
		this._bDate = bDate;
		this._gender = gender;
		this._maritalStatus = MaritalStatus.unmarried;

	}

	public boolean changeSurName(Person husband) {
		if (isFemale() == true && !husband.isFemale()) {
			this.get_name().set_lastName(husband.get_name().get_lastName());
			return true;

		}
		return false;
	}

	public boolean changeBackSurName() {
		if (isFemale() == true) {
			Name name = this.get_name();
			name.set_lastName(name.get_unmarriedName());
			return true;
		}
		return false;

	}

	public int getAge() {
		long ageInMillis = new Date().getTime() - get_bDate().getTime();

		Date age = new Date(ageInMillis);

		return age.getYear();
	}

	public boolean isLegalAge() {
		if (getAge() >= 18) {
			return true;
		}
		return false;

	}

	public boolean canMarry(Person futurePartner) {
		if (this.isLegalAge() && futurePartner.isLegalAge() && this.get_gender() != futurePartner.get_gender()) {
			return true;// TODO prüfen ob ich oder futurPartner unmarried
		}
		return false;

	}

	public boolean marry(Person futurePartner, Person wittness, Person wittnessFuturePartner) {
		if (wittness != null && wittness.isLegalAge() && wittnessFuturePartner != null
				&& wittnessFuturePartner.isLegalAge() && this.canMarry(futurePartner)) {
			this.set_maritalStatus(MaritalStatus.married);
			futurePartner.set_maritalStatus(MaritalStatus.married);
			this.changeSurName(futurePartner);
			futurePartner.changeSurName(this);
			this.set_couple(futurePartner);
			futurePartner.set_couple(this);
			return true;
		}
		return false;

	}

	public boolean isFemale() {
		if (this.get_gender().equals(Gender.female)) {
			return true;
		}
		return false;
	}

	public boolean canDivorce(Person exPartner) {
		return false;
	}

	public boolean divorce(String reson) {
		return false;
	}

	public MaritalStatus get_maritalStatus() {
		return _maritalStatus;
	}

	public void set_maritalStatus(MaritalStatus _maritalStatus) {
		this._maritalStatus = _maritalStatus;
	}

	public MarriedCouples get_couple() {
		return null; // _couple;
	}

	public void set_couple(Person _couple) {
		this._couple = _couple;
	}

	public Name get_name() {
		return _name;
	}

	public Date get_bDate() {
		return _bDate;
	}

	public Gender get_gender() {
		return _gender;
	}

}
