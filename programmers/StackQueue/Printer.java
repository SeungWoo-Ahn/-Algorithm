package programmers.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

class Doc {
	int idx;
	int value;
	
	public Doc(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}
}

public class Printer {
	
	static int solution(int[] priorities, int location) {
		int answer = 0;
		
		Queue<Doc> q = new LinkedList<>();
		// 큐에 우선순위/인덱스를 저장합니다
		for(int i=0; i<priorities.length; i++) {
			q.offer(new Doc(i,priorities[i]));
		}
		
		
		while(!q.isEmpty()) {
			
			int head = q.peek().value;
			boolean find = false;
			
			// 큐에 peek보다 더 큰 우선순위가 있는지 확인합니다
			for(Doc d : q) {
				if(d.value > head) {
					find = true;
					break;
				}
			}
			
			// 더 큰 우선순위가 있다면, peek를 뽑아 맨뒤로 보냅니다
			if(find) {
				q.offer(q.poll());
			}
			// peek가 가장 높은 우선순위라면, 뽑고 찾는 위치었다면 반환합니다
			else {
				Doc d = q.poll();
				answer++;
				if(d.idx == location) return answer;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.print(solution(priorities, location));

	}

}
