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
		// ť�� �켱����/�ε����� �����մϴ�
		for(int i=0; i<priorities.length; i++) {
			q.offer(new Doc(i,priorities[i]));
		}
		
		
		while(!q.isEmpty()) {
			
			int head = q.peek().value;
			boolean find = false;
			
			// ť�� peek���� �� ū �켱������ �ִ��� Ȯ���մϴ�
			for(Doc d : q) {
				if(d.value > head) {
					find = true;
					break;
				}
			}
			
			// �� ū �켱������ �ִٸ�, peek�� �̾� �ǵڷ� �����ϴ�
			if(find) {
				q.offer(q.poll());
			}
			// peek�� ���� ���� �켱�������, �̰� ã�� ��ġ���ٸ� ��ȯ�մϴ�
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
