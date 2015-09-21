package algo;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	
	private List<T> stack;
	
	public void push(T el) {
		if(stack == null) {
			stack = new ArrayList<T>();
		}
		stack.add(el);
	}
	
	public T pop() {
		T el = null;
		int lastIdx;
		if(stack != null && stack.size() > 0) {
			lastIdx = stack.size()-1;
			el = stack.get(lastIdx);
			stack.remove(lastIdx);
		}
		return el;
	}
	
	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		Integer last;
		s.push(10);
		s.push(20);
		last = s.pop();
		System.out.println("Last: " + last);
		last = s.pop();
		System.out.println("Last: " + last);
		s.push(45);
		last = s.pop();
		System.out.println("Last: " + last);	
		last = s.pop();
		System.out.println("Last: " + last);
	}

}
