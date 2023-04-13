package programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NonCompletePlayer {
	
	static String solution (String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		
		// 참가자 이름을 key로 한 명당 1씩 더함
		for(String p: participant) {
			map.put(p, map.getOrDefault(p, 0)+1);
		}
		
		// 완료자 이름을 key로 한 명당 1씩 뺌 
		for(String c: completion) {
			map.put(c, map.get(c)-1);
		}
		
		Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
		// map 전체를 순회했을때, value가 0이 아닌 이름이 완주하지 못한 선수이다
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
