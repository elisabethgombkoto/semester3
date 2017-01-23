package oo.ego8769.hue02.bsp2;

public class Postfix {
	private int length=5;
	private Postfix_stack stack =new Postfix_stack(length);
	private String s="";
		
	public Postfix(String str){
		s=str;
	}
	
	public int calculate(){
		get_values();
		return calculation();
		
	}

	private void get_values() {
		
	int new_nummber=0;
	char operator=' ';
	String temp="";
	StringBuilder zahl_op= new StringBuilder(s.length());
	int backcounter=0;
	
	for(int i = 0;i<s.length();++i){
		if (s.charAt(i)!=' '){
			temp=zahl_op.toString();
			zahl_op.insert((i-backcounter),s.charAt(i));
			}else if(s.charAt(i)== ' '){
				temp=zahl_op.toString();
				if((temp.charAt(0)>= '0') &&(temp.charAt(0)<= '9')){
					new_nummber=Integer.parseInt(temp);
					stack.push(new_nummber);
					backcounter=i+1;
					new_nummber = 0;
					zahl_op=new StringBuilder(s.length());
				}else if (temp.charAt(0)!='+'||temp.charAt(0)!='-'||temp.charAt(0)!='*'||temp.charAt(0)!='/'){
						operator=temp.charAt(0);
					stack.push(operator);
					backcounter=i+1;
					operator= ' ';
					zahl_op=new StringBuilder(s.length());
				}
			}else if (s.charAt(i)==';'){
				return;
			}
		}
	}
	
private int calculation(){
	Integer value1 = null; 
	Integer value2 = null;
	Object object = null;
	char operand = ' '; 
		while (stack.isEmpty() == false){ 
				object = stack.pop(); 
				
					if (object.equals('+') || object.equals('-') || object.equals('*') || object.equals('/')){ // checking if it's an operand
						operand = (char) object;
					} else if (value2 == null) { 
						value2 = (Integer) object;
					} else { 
						value1 = (Integer) object;
					}
				}
				value1 = do_calculation(value1, value2, operand); 
				return value1;
			}
			// calculates the given problem
			private int do_calculation(int value1, int value2, int op){
				if (op == '+'){ // addition
					value1 += value2;
				} else if (op == '-'){ // subtraction
					value1 -= value2;
				} else if (op == '*'){ // multiplication
					value1 *= value2;
				} else if (op == '/'){ // division
					value1 /= value2;
				}
				return value1;
			}
}
		
