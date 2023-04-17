package programmers;

import java.util.HashMap;

public class PhoneBookList {
	
	static boolean solution(String[] phone_book) {
		
		HashMap<String, Integer> map = new HashMap<>();
		// map에 key로 모든 번호를 저장한다
		for(int i=0; i<phone_book.length; i++) {
			map.put(phone_book[i], i);
		}
		
		// 각 번호의 0~j-1번째 글자가 map에 저장됐는지 확인한다
		for(int i=0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book[i].length(); j++) {
				// 접두사로 사용되는 단어가 하나라도 있으면 false를 반환한다
				if(map.containsKey(phone_book[i].substring(0,j))) return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		String[] input = {"12","123","1235","567","88"};
		System.out.println(solution(input));
	}

}
