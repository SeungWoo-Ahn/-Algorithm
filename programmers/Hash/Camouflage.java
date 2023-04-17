package programmers.Hash;

import java.util.HashMap;
import java.util.Iterator;

public class Camouflage {
	
	static int solution(String[][] clothes) {
		int answer = 1;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		// 옷 종류를 key로 해서 가지수를 저장합니다
		for(int i=0; i<clothes.length; i++) {
			String key = clothes[i][1];
			if(!map.containsKey(key)) {
				map.put(key, 1);
			}
			else {
				map.put(key, map.get(key)+1);
			}
		}
		
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			answer *= map.get(key)+1;
		}
		
		return answer-1;
	}

	public static void main(String[] args) {
		String[][] input = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(input));
	}

}
