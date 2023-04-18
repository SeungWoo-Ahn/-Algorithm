package programmers.StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDev {
	
	static int calcDay(int progress, int speed) {
		double remain = (100-progress)/(double) speed;
		if(remain%1==0.0) return (int)remain;
		else return (int)remain +1;
	}
	
	static int[] solution(int[] progresses,int[] speeds) {
		int[] answer = {};
		
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		
		for(int i=0; i<progresses.length; i++) {
			int day = calcDay(progresses[i], speeds[i]);
			
			// ť�� �ִ밪(�� ��)�� day���� ������ ���ݱ��� �����ߴ� day�� ������ result�� �����մϴ�
			if(!queue.isEmpty() && queue.peek()<day) {
				result.add(queue.size());
				queue.clear();
			}
			
			// ť�� �������� day�� �����մϴ�
			queue.offer(day);
		}
		
		// ���������� ���� day�� ������ �����մϴ�
		result.add(queue.size());
		
		int size = result.size();
		answer = new int[size];
		for(int i=0; i<size; i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] answer = solution(progresses, speeds);
		for(int i:answer) {
			System.out.print(i+" ");
		}

	}

}
