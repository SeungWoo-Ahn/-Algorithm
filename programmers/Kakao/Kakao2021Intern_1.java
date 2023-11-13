package programmers.Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kakao2021Intern_1 {
	
	static String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static List<String> wordArray = new ArrayList<>(Arrays.asList(words));
	static StringBuilder sb = new StringBuilder();
	
	static int solution(String s) {
		String tempStr = "";
		char[] charArr = s.toCharArray();
		for(int i=0; i<charArr.length; i++) {
			if(charArr[i] >= '0' && charArr[i] <= '9') {
				sb.append(charArr[i]);
			} else {
				tempStr += charArr[i];
				if(wordArray.contains(tempStr)) {
					sb.append(wordArray.indexOf(tempStr));
					tempStr = "";
				}
			}
		}
		return Integer.valueOf(sb.toString());
	}
	
//	(1µî Á¤´ä)
//	static int solution(String s) {
//        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        for(int i = 0; i < strArr.length; i++) {
//            s = s.replaceAll(strArr[i], Integer.toString(i));
//        }
//        return Integer.parseInt(s);
//    }

	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
	}

}
