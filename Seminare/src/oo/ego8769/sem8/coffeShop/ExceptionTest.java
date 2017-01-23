package oo.ego8769.sem8.coffeShop;

public class ExceptionTest {
	public void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	public static void main(String[] args) throws Exception {
		ExceptionTest lex = new ExceptionTest();
		try {
			lex.f();
		} finally {
			throw new UnImportantException();
		}
	}
}

class VeryImportantException extends Exception {
	@Override
	public String toString() {
		return "A very important exception";
	}
};

class UnImportantException extends Exception {
	@Override
	public String toString() {
		return "A really unimportant exception";
	}
}
