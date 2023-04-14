package programmers;

import java.util.Stack;

public class RemovePair {

	static int solution(String s)
    {
        char[] input = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<input.length; i++) {
        	char each = input[i];
        	if(stack.isEmpty()) stack.push(each);
        	else {
        		if(stack.peek()==each) stack.pop();
        		else stack.push(each);
        	}
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
	}

}
