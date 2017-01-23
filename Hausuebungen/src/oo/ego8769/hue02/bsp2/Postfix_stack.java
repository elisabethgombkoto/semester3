package oo.ego8769.hue02.bsp2;
import java.util.ArrayList;

public class Postfix_stack {
	private int postfix_stack_pointer = 0; // integer to point at the stack
	private int postix_stack_length = 0; // length of the stack
	private ArrayList<Object> postfix_stack = new ArrayList<Object>(postix_stack_length); // initializes the Stack
	
	public Postfix_stack(int length){
		postix_stack_length = length;
	}
	// checks if the Stack is empty
	public boolean isEmpty(){
		return postfix_stack.isEmpty();
	}
	// pushes an object on top of the stack
	public void push(Object obj){
		postfix_stack.add(obj);
		postfix_stack_pointer++;
	}
	// pops the top element of the stack
	public Object pop(){
		postfix_stack_pointer--;
		Object element = postfix_stack.get(postfix_stack_pointer);
		postfix_stack.remove(postfix_stack_pointer);
		return element;
	}
	// returns the top element of the stack
	public Object top(){
		postfix_stack_pointer--;
		Object element = postfix_stack.get(postfix_stack_pointer);
		postfix_stack_pointer++;
		return element;
	}
	
	
}
