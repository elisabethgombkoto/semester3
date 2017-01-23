package oo.ego8769.hue04.bsp1;

public class MarriedCouples {

	private Person _wife;
	private Person _husband;
	private String _groundsForDivorce;
	private MaritalStatus _maritalStatus;
	private Person _witnessWife;
	private Person _witnessHusband;
	
	public MarriedCouples(Person wife, Person husband, Person witnessWife, Person witnessHusband){
		_wife=wife;
		_husband=husband;
		_witnessWife= witnessWife;
		_witnessHusband= witnessHusband;
		_maritalStatus=MaritalStatus.married;
		
	}

	public Person get_wife() {
		return _wife;
	}

	public Person get_husband() {
		return _husband;
	}

	public String get_groundsForDivorce() {
		return _groundsForDivorce;
	}

	public void set_groundsForDivorce(String groundsForDivorce) {
		_groundsForDivorce = groundsForDivorce;
	}

	public MaritalStatus get_maritalStatus() {
		return _maritalStatus;
	}

	public void set_maritalStatus(MaritalStatus maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	public Person get_witnessWife() {
		return _witnessWife;
	}
	public Person get_witnessHusband() {
		return _witnessHusband;
	}	
}
