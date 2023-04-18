package programmers.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
	
	static int[] solution(int[] prices) {
		int len = prices.length;
		int[] answer = new int[len];
		
		Queue<Integer> q = new LinkedList<>();
		// 주식 가격들을 큐에 넣습니다
		for(int i=0; i<len; i++) {
			q.offer(prices[i]);
		}
		
		int idx = 0;
		// 맨 앞을 뽑고, 가격이 떨어질때까지 카운팅 후 저장합니다
		while(!q.isEmpty()) {
			int head = q.poll();
			int cnt = 0;
			for(int i: q) {
				cnt++;
				if(head > i) break;
			}
			answer[idx] = cnt;
			idx++;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 2, 3};
		int[] output = solution(input);
		for(int i: output) {
			System.out.print(i+" ");
		}

	}

}
