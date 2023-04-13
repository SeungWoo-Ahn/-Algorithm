package programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NonCompletePlayer {
	
	static String solution (String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		
		// ������ �̸��� key�� �� ��� 1�� ����
		for(String p: participant) {
			map.put(p, map.getOrDefault(p, 0)+1);
		}
		
		// �Ϸ��� �̸��� key�� �� ��� 1�� �� 
		for(String c: completion) {
			map.put(c, map.get(c)-1);
		}
		
		Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
		// map ��ü�� ��ȸ������, value�� 0�� �ƴ� �̸��� �������� ���� �����̴�
		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			if(entry.getValue() != 0) {
				answer = entry.getKey();
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};	
		String[] completion = {"eden", "kiki"};		
		System.out.println(solution(participant, completion));
	}

}
