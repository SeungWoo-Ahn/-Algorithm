package programmers.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
	
	static int[] solution2(String[] operations) {
		
		long beforeTime = System.currentTimeMillis();
		
		int[] answer = new int[2];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<operations.length; i++) {
			String[] s = operations[i].split(" ");
			String op = s[0];
			int num = Integer.parseInt(s[1]);
			
			switch(op) {
				// 양쪽 큐에 모두 저장합니다
				case "I" :
					pq.add(num);
					reverse_pq.add(num);
					break;
				case "D" :
					if(pq.size() > 0) {
						// 역방향 큐에서 최댓값을 가져와 큐에서 제거합니다
						if(num == 1) {
							int max = reverse_pq.poll();
							pq.remove(max);
						}
						// 큐에서 최소값을 가져와 역방향 큐에서 제거합니다
						else {
							int min = pq.poll();
							reverse_pq.remove(min);
						}
					}
					break;
			}
		}
		
		if(pq.size()>=2) {
			answer[0] = reverse_pq.poll();
			answer[1] = pq.poll();
		}
		
		long afterTime = System.currentTimeMillis();
		System.out.println("걸린 시간: "+(afterTime - beforeTime));
		
		return answer;
	}
	
	static int[] solution(String[] operations) {
		
		long beforeTime = System.currentTimeMillis();
		
		int[] answer = new int[2];
		
		List<Integer> arr = new ArrayList<>();
		for(int i=0; i<operations.length; i++) {
			String[] s = operations[i].split(" ");
			String op = s[0];
			int num = Integer.parseInt(s[1]);
			
			// 값을 추가하고 정렬합니다
			if(op.equals("I")) {
				arr.add(num);
				Collections.sort(arr);
			}
			// num에 따라 최대값 혹은 최솟값을 제거합니다
			else {
				if(arr.size()==0) continue;
				if(num == 1) arr.remove(arr.size()-1);
				else arr.remove(0);
			}
		}
		
		int size = arr.size();
		if(size!=0) {
			answer[0] = arr.get(size-1);
			answer[1] = arr.get(0);
		}
		
		long afterTime = System.currentTimeMillis();
		System.out.println("걸린 시간: "+(afterTime - beforeTime));
		
		return answer;
	}

	public static void main(String[] args) {
		String[] input = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] output = solution(input);
		int[] output2 = solution2(input);
		System.out.println("최댓값: "+output[0]+" 최솟값: "+output[1]);
		System.out.println("최댓값: "+output2[0]+" 최솟값: "+output2[1]);
	}

}
