package programmers;

import java.util.Stack;

public class TransformBracket {
	
	static String dfs(String w) {
		
		// 빈 문자열인 경우
		if(w.length()==0) {
			return "";
		}
		
		// u와 v 분리
		String u = "";
		String v = "";
		int left = 0;
		int right = 0;
		
		for(int i=0; i<w.length(); i++) {
			if(w.charAt(i)=='(') left++;
			else right++;
			u += w.charAt(i);
			if(left == right) {
				v = w.substring(i+1);
				break;
			}
		}
		
		if(isCorrect(u)) {
			return u += dfs(v);
		}
		else {
			String temp = "(";
			temp += dfs(v);
			temp += ")";
			u = u.substring(1,u.length()-1);
			for(int i=0; i<u.length(); i++) {
				if(u.charAt(i)=='(') temp += ')';
				else temp += '(';
			}
			return temp;
		}
	}
	
	static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == '(') stack.push('(');
			else {
				if(stack.isEmpty() || stack.peek() == ')') {
					return false;
				}
				else stack.pop();
			}
		}
		
		return true;
	}
	
	

	public static void main(String[] args) {
		String input = "()))((()";
		System.out.println(dfs(input));
	}

}
