package programmers.Hash;

import java.util.HashMap;

public class PhoneBookList {
	
	static boolean solution(String[] phone_book) {
		
		HashMap<String, Integer> map = new HashMap<>();
		// map�� key�� ��� ��ȣ�� �����Ѵ�
		for(int i=0; i<phone_book.length; i++) {
			map.put(phone_book[i], i);
		}
		
		// �� ��ȣ�� 0~j-1��° ���ڰ� map�� ����ƴ��� Ȯ���Ѵ�
		for(int i=0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book[i].length(); j++) {
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
