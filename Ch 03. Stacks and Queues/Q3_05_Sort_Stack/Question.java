package Q3_05_Sort_Stack;

import java.util.Stack;

import CtCILibrary.AssortedMethods;

public class Question {
	public static Stack<Integer> mergesort(Stack<Integer> inStack) {
		if (inStack.size() <= 1) {
			return inStack;
		}

		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		int count = 0;
		while (inStack.size() != 0) {
			count++;
			if (count % 2 == 0) {
				left.push(inStack.pop());
			} else {
				right.push(inStack.pop());
			}
		}

		left = mergesort(left);
		right = mergesort(right);

		while (left.size() > 0 || right.size() > 0) {
			if (left.size() == 0) {
				inStack.push(right.pop());
			} else if (right.size() == 0) {
				inStack.push(left.pop());
			} else if (right.peek().compareTo(left.peek()) <= 0) {
				inStack.push(left.pop());
			} else {
				inStack.push(right.pop());
			}
		}

		Stack<Integer> reverseStack = new Stack<Integer>();
		while (inStack.size() > 0) {
			reverseStack.push(inStack.pop());
		}

		return reverseStack;
	}
	
	public static void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			/* Insert each element in s in sorted order into r. */
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		
		/* Copy the elements back. */
		while (!r.isEmpty()) {
			s.push(r.pop());
		}
	}

	public static void zhengStackSort(Stack<Integer> s) {
		Stack<Integer> t = new Stack<>();
		int temp;
		while(!s.isEmpty()) {
			temp = s.pop();
			while(!t.isEmpty() && temp < t.peek()) {
				s.push(t.pop());
			}
			t.push(temp);
            // This part is redundant.
			while(!s.isEmpty() && s.peek() > t.peek()) {
				t.push(s.pop());
			}
		}
		while(!t.isEmpty()) {
			s.push(t.pop());
		}
	}

    // Logic can be improved from original solution.
    // May not need to pop the item from source stack to temp
	public static void zhengStackSort2(Stack<Integer> s) {
        Stack<Integer> t = new Stack<>();
        int temp;
        while(!s.isEmpty()) {
            if (t.isEmpty() || s.peek() > t.peek()) {
                t.push(s.pop());
            } else {
                temp = s.pop();
                while(!t.isEmpty() && temp < t.peek()) {
                    s.push(t.pop());
                }
                t.push(temp);
            }
        }
        while(!t.isEmpty()) {
            s.push(t.pop());
        }
    }
		
	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			int r = AssortedMethods.randomIntInRange(0,  1000);
			s.push(r);
		}
		
		zhengStackSort2(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}
