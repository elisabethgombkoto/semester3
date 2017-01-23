/**
 * 
 */
package oo.ego8769.hue04.bsp1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * @author Elisabeth
 *
 */
public class NameTest {
	private SimpleDateFormat _df = new SimpleDateFormat("dd.MM.yyyy");
	private Date _bdate = new Date();// TODO lösen

	@Test
	public void CreatePersonTest() {
		Date _bdate = new Date();
		try {
			_bdate = _df.parse("2.5.1975");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Person person1 = new Person(new Name("Miki", "Mouse", ""), Gender.male, _bdate);

	}

	@Test
	public void MarryTestWrongAge() {
		Date _bdate = new Date();
		try {
			_bdate = _df.parse("2.5.1990");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Person person1 = new Person(new Name("Miki", "Mouse", ""), Gender.male, _bdate);
		try {
			_bdate = _df.parse("4.5.1999");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Person person2 = new Person(new Name("Mini", "Mousey", ""), Gender.female, _bdate);
		try {
			_bdate = _df.parse("4.5.1985");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Person person3 = new Person(new Name("Daisy", "Ducky", ""), Gender.female, _bdate);
		try {
			_bdate = _df.parse("1.5.1985");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Person person4 = new Person(new Name("Donald", "Duck", ""), Gender.male, _bdate);
		RegisterOffice ro = new RegisterOffice();
		assertEquals(false, ro.marry(person4, person4, person2, person1));

	}

	@Test
	public void MarryTestWithMySelf() {
		// TODO Date _bdate = new Date(); in jedem Test hinzufügen
		Date _bdate = new Date();
		try {
			_bdate = _df.parse("2.5.1985");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person person1 = new Person(new Name("Miki", "Mouse", ""), Gender.male, _bdate);
		try {
			_bdate = _df.parse("4.5.19");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person person2 = new Person(new Name("Mini", "Mousey", ""), Gender.female, _bdate);
		Person person3 = new Person(new Name("Daisy", "Ducky", ""), Gender.female, _bdate);
		Person person4 = new Person(new Name("Donald", "Duck", ""), Gender.male, _bdate);
		RegisterOffice ro = new RegisterOffice();
		assertEquals(false, ro.marry(person4, person4, person2, person1));

	}

	@Test
	public void MarryTestWithMarriedPerson() {
		try {
			_bdate = _df.parse("2.5.1985");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person person1 = new Person(new Name("Miki", "Mouse", ""), Gender.male, _bdate);
		try {
			_bdate = _df.parse("4.5.1984");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person person2 = new Person(new Name("Mini", "Mousey", ""), Gender.female, _bdate);
		Person person3 = new Person(new Name("Daisy", "Ducky", ""), Gender.female, _bdate);
		Person person4 = new Person(new Name("Donald", "Duck", ""), Gender.male, _bdate);
		RegisterOffice ro = new RegisterOffice();
		RegisterOffice ra = new RegisterOffice();
		ra.marry(person2, person4, person3, person1);
		assertEquals(false, ro.marry(person2, person1, person3, person4));

	}

	@Test
	public void DivorceTestOk() {
		try {
			_bdate = _df.parse("2.5.1985");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person person1 = new Person(new Name("Mini", "Mousey", "Mousey"), Gender.female, _bdate);
		Person person2 = new Person(new Name("Miki", "Mouse", ""), Gender.male, _bdate);
		Person person3 = new Person(new Name("Daisy", "Ducky", "Ducky"), Gender.female, _bdate);
		Person person4 = new Person(new Name("Donald", "Duck", ""), Gender.male, _bdate);

		MarriedCouples mo = new MarriedCouples(person2, person1, person3, person4);
		MarriedCouples ma = new MarriedCouples(person3, person4, person2, person1);

		RegisterOffice ro = new RegisterOffice(ma);
		assertEquals(true, ro.divorce(person3, person4, "sdsaff"));

	}

	@Test
	public void DivorceTestWrongCouple() {
		try {
			_bdate = _df.parse("2.5.1985");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person person1 = new Person(new Name("Mini", "Mousey", "Mousey"), Gender.female, _bdate);
		Person person2 = new Person(new Name("Miki", "Mouse", ""), Gender.male, _bdate);
		Person person3 = new Person(new Name("Daisy", "Ducky", "Ducky"), Gender.female, _bdate);
		Person person4 = new Person(new Name("Donald", "Duck", ""), Gender.male, _bdate);

		MarriedCouples mo = new MarriedCouples(person2, person1, person3, person4);
		MarriedCouples ma = new MarriedCouples(person3, person4, person2, person1);

		RegisterOffice ro = new RegisterOffice(ma);
		assertEquals(true, ro.divorce(person2, person1, "sdsaff"));

	}

	@Test
	public void DivorceTestWithMySelf() {
		try {
			_bdate = _df.parse("2.5.1985");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person person1 = new Person(new Name("Mini", "Mousey", "Mousey"), Gender.female, _bdate);
		Person person2 = new Person(new Name("Miki", "Mouse", ""), Gender.male, _bdate);
		Person person3 = new Person(new Name("Daisy", "Ducky", "Ducky"), Gender.female, _bdate);
		Person person4 = new Person(new Name("Donald", "Duck", ""), Gender.male, _bdate);

		MarriedCouples mo = new MarriedCouples(person2, person1, person3, person4);
		MarriedCouples ma = new MarriedCouples(person3, person4, person2, person1);

		RegisterOffice ro = new RegisterOffice(ma);
		assertEquals(false, ro.divorce(person2, person2, "sdsaff"));

	}

	private void assertEquals(boolean b, Object divorce) {
		// TODO Auto-generated method stub

	}
}