package programmers.DfsBfs;

import java.util.LinkedList;
import java.util.Queue;

public class BfsExample {
	
	static int[][] graph =  {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
	static boolean[] visited = new boolean[graph.length];
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	static void Bfs(int n) {
		q.offer(n); //ù ��° ��� ����
		visited[n] = true; //ù ��° ��� �湮ó��
		
		while(!q.isEmpty()) { //ť�� �� ������
			int x = q.poll(); //ť���� ����
			sb.append(x).append("->");
			
			for(int i : graph[x]) {
				if(!visited[i]) { //����� ��� ��, �湮���� ���� ��忡 ����
					q.offer(i); //ť�� ��� ����
					visited[i] = true; //�ش� ��� �湮ó��
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Bfs(1);
		System.out.println(sb);

	}

}
