package programmers.DfsBfs;

import java.util.LinkedList;
import java.util.Queue;

public class BfsExample {
	
	static int[][] graph =  {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
	static boolean[] visited = new boolean[graph.length];
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	static void Bfs(int n) {
		q.offer(n); //첫 번째 노드 삽입
		visited[n] = true; //첫 번째 노드 방문처리
		
		while(!q.isEmpty()) { //큐가 빌 때까지
			int x = q.poll(); //큐에서 뽑음
			sb.append(x).append("->");
			
			for(int i : graph[x]) {
				if(!visited[i]) { //연결된 노드 중, 방문하지 않은 노드에 대해
					q.offer(i); //큐에 노드 삽입
					visited[i] = true; //해당 노드 방문처리
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Bfs(1);
		System.out.println(sb);

	}

}
