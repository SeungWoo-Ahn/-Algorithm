package programmers.Heap;

import java.util.PriorityQueue;

public class MoreSpicy {
	
	static int solution(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		// 모든 맵기를 힙에 저장합니다 => 정렬됨
		for(int i : scoville) {
			heap.add(i);
		}
		
		// peek가 K보다 작은 동안 반복합니다
		while(heap.peek()<K) {
			// 힙 크기가 1이면 찾지 못한다고 판단합니다
			if(heap.size()==1) return -1;
			
			// (가장 덜 맵기 + 2x두번째로 덜 맵기)를 힙에 다시 추가합니다
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
