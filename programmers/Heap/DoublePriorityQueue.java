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
				// ���� ť�� ��� �����մϴ�
				case "I" :
					pq.add(num);
					reverse_pq.add(num);
					break;
				case "D" :
					if(pq.size() > 0) {
						// ������ ť���� �ִ��� ������ ť���� �����մϴ�
						if(num == 1) {
							int max = reverse_pq.poll();
							pq.remove(max);
						}
						// ť���� �ּҰ��� ������ ������ ť���� �����մϴ�
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
		System.out.println("�ɸ� �ð�: "+(afterTime - beforeTime));
		
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
			
			// ���� �߰��ϰ� �����մϴ�
			if(op.equals("I")) {
				arr.add(num);
				Collections.sort(arr);
			}
			// num�� ���� �ִ밪 Ȥ�� �ּڰ��� �����մϴ�
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
		System.out.println("�ɸ� �ð�: "+(afterTime - beforeTime));
		
		return answer;
	}

	public static void main(String[] args) {
		String[] input = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] output = solution(input);
		int[] output2 = solution2(input);
		System.out.println("�ִ�: "+output[0]+" �ּڰ�: "+output[1]);
		System.out.println("�ִ�: "+output2[0]+" �ּڰ�: "+output2[1]);
	}

}
