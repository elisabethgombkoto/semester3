/*
 * Alle Dateien in ./Expr  und Compileren mit:
 *
 * javac -d . Expr/Token.java
 * javac -d . Expr/Expr.java
 * javac -d . Expr/JExpr.java
 *
 */

package oo.ego8769.hue09.Expr;

/**
 * Hier sind alle Implementierungen hinterlegt
 *
 * misc abstract classes and their useless subclasses
 */

abstract class Token {
	public abstract int priority();

	public abstract double eval(Stack params);
}

abstract class Function extends Token {
	@Override
	public abstract double eval(Stack params);
}

abstract class Operator extends Token {

}

abstract class UnOperator extends Operator {

}

abstract class BinOperator extends Operator {

}

class Literal extends Token {

	public String value;

	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		return 0; // Raise exception!
	}

	Literal(String s) {
		value = s;
	}

	@Override
	public String toString() {
		return value;
	}

}

class Assignment extends Token {

	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		return 0; // Raise exception!
	}

	@Override
	public String toString() {
		return "=";
	}

}

class BracketClose extends Token {

	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		return 0; // Raise exception!
	}

	@Override
	public String toString() {
		return ")";
	}

}

class BracketOpen extends Token {

	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		return 0; // Raise exception!
	}

	@Override
	public String toString() {
		return "(";
	}

}

class Variable extends Token {
	private String name;
	private double val;

	Variable(String s, double f) {
		name = s;
		val = f;
	}

	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		return val;
	}

	@Override
	public String toString() {
		return name;
	}
}

class Number extends Token {

	@Override
	public int priority() {
		return 0;
	}

	private double val;

	@Override
	public String toString() {
		return Double.toString(val);
	}

	Number(double n) {
		val = n;
	}

	Number(float n) {
		val = n;
	}

	Number(int n) {
		val = n;
	}

	@Override
	public double eval(Stack params) {
		return val;
	}
}

class Add extends BinOperator {
	@Override
	public int priority() {
		return 2;
	}

	@Override
	public String toString() {
		return "+";
	}

	@Override
	public double eval(Stack params) {
		double d = params.pop().eval(params);
		if (params.peek() == null)
			return d; // startsWith("+")
		else
			return d + params.pop().eval(params);
	}
}

class Sub extends BinOperator {
	@Override
	public int priority() {
		return 2;
	}

	@Override
	public String toString() {
		return "-";
	}

	@Override
	public double eval(Stack params) {
		double min = params.pop().eval(params);
		return params.pop().eval(params) - min;
	}
}

class Mul extends BinOperator {
	@Override
	public int priority() {
		return 4;
	}

	@Override
	public String toString() {
		return "*";
	}

	@Override
	public double eval(Stack params) {
		return (params.pop().eval(params) * params.pop().eval(params));
	}
}

class Div extends BinOperator {
	@Override
	public int priority() {
		return 4;
	}

	@Override
	public String toString() {
		return "/";
	}

	@Override
	public double eval(Stack params) {
		Token t;
		t = params.pop();
		if (t == null) {
			return Double.NaN;
		}
		double div = t.eval(params);
		t = params.pop();
		if (t == null) {
			return div; // Fehler...
		}
		return (t.eval(params) / div);
	}
}

class Mod extends BinOperator {
	@Override
	public int priority() {
		return 4;
	}

	@Override
	public String toString() {
		return "%";
	}

	@Override
	public double eval(Stack params) {
		Token t;
		t = params.pop();
		if (t == null) {
			return Double.NaN;
		}
		double div = t.eval(params);
		t = params.pop();
		if (t == null || div == 0) {
			return Double.NaN; // Fehler...
		}

		return (((long) t.eval(params) % (long) div));
		// return java.lang.Math.IEEEremainder(t.eval(params), div);

	}
}

class Pow extends BinOperator {
	@Override
	public int priority() {
		return 8;
	}

	@Override
	public String toString() {
		return "^";
	}

	@Override
	public double eval(Stack params) {
		double pow = params.pop().eval(params);
		return java.lang.Math.pow(params.pop().eval(params), pow);
	}
}

class Sin extends Function {
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		double f = params.pop().eval(params);
		return java.lang.Math.sin(f);
	}
}

class Cos extends Function {
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		double f = params.pop().eval(params);
		return java.lang.Math.cos(f);
	}
}

class Tan extends Function {
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		double f = params.pop().eval(params);
		return java.lang.Math.tan(f);
	}
}

class Asin extends Function {
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		double f = params.pop().eval(params);
		return java.lang.Math.asin(f);
	}
}

class Acos extends Function {
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		double f = params.pop().eval(params);
		return java.lang.Math.acos(f);
	}
}

class Atan extends Function {
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		double f = params.pop().eval(params);
		return java.lang.Math.atan(f);
	}
}

class Log extends Function {
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		double f = params.pop().eval(params);
		return java.lang.Math.log(f);
	}
}

class Exp extends Function {
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		double f = params.pop().eval(params);
		return java.lang.Math.exp(f);
	}
}

class Sqrt extends Function {
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		double f = params.pop().eval(params);
		return java.lang.Math.sqrt(f);
	}
}

class Abs extends Function {
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public double eval(Stack params) {
		double f = params.pop().eval(params);
		return java.lang.Math.abs(f);
	}
}

class Random extends Variable {
	Random() {
		super("random", 0);
	}

	@Override
	public double eval(Stack params) {
		return java.lang.Math.random();
	}
}

class Min extends BinOperator {
	@Override
	public int priority() {
		return 10;
	}

	@Override
	public double eval(Stack params) {
		Token f1 = params.pop();
		Token f2 = params.pop();
		if (f1 == null || f2 == null)
			return Double.NaN;
		return java.lang.Math.min(f1.eval(params), f2.eval(params));
	}
}

class Max extends BinOperator {
	@Override
	public int priority() {
		return 10;
	}

	@Override
	public double eval(Stack params) {
		Token f1 = params.pop();
		Token f2 = params.pop();
		if (f1 == null || f2 == null)
			return Double.NaN;
		return java.lang.Math.max(f1.eval(params), f2.eval(params));
	}
}
