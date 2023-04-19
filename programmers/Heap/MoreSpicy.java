package programmers.Heap;

import java.util.PriorityQueue;

public class MoreSpicy {
	
	static int solution(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		// ��� �ʱ⸦ ���� �����մϴ� => ���ĵ�
		for(int i : scoville) {
			heap.add(i);
		}
		
		// peek�� K���� ���� ���� �ݺ��մϴ�
		while(heap.peek()<K) {
			// �� ũ�Ⱑ 1�̸� ã�� ���Ѵٰ� �Ǵ��մϴ�
			if(heap.size()==1) return -1;
			
			// (���� �� �ʱ� + 2x�ι�°�� �� �ʱ�)�� ���� �ٽ� �߰��մϴ�
			heap.add(heap.poll() + heap.poll()*2);
			answer++;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}

}
