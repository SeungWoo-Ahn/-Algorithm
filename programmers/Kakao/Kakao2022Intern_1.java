package programmers.Kakao;

public class Kakao2022Intern_1 {
	
	/**
	 * 지표
	 * 1번: R, T
	 * 2번: C, F
	 * 3번: J, M
	 * 4번: A, N
	 */
	static int[] table = new int[26];
	static String solution(String[] survey, int[] choices) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < survey.length; i++) {
			int choice = choices[i];
			int score = Math.abs(choice - 4);
			if(choice < 4) {
				table[getTableIndex(survey[i].charAt(0))] = table[getTableIndex(survey[i].charAt(0))] + score;
			} else {
				table[getTableIndex(survey[i].charAt(1))] = table[getTableIndex(survey[i].charAt(1))] + score;
			}
		}
		sb
		.append(selectType('R', 'T'))
		.append(selectType('C', 'F'))
		.append(selectType('J', 'M'))
		.append(selectType('A', 'N'));
		return sb.toString();
	}
	
	static int getTableIndex(char c) {
		return c - 'A';
	}
	
	static char selectType(char t1, char t2) {
		return table[getTableIndex(t1)] >= table[getTableIndex(t2)] ? t1 : t2;
	}

	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};	
		System.out.println(solution(survey, choices));
	}

}
