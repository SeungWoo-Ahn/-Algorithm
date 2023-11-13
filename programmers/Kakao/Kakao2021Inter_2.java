package programmers.Kakao;

import java.util.LinkedList;
import java.util.Queue;

public class Kakao2021Inter_2 {
	
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int placeSize = 5;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static int[] solution(String[][] places) {
        int[] answer = new int[placeSize];
        for(int i = 0; i < placeSize; i++) {
        	answer[i] = isCorrect(places[i]);
        }
        return answer;
    }
	
	static int isCorrect(String[] place) {
		for(int i = 0; i < placeSize; i++) {
			for(int j = 0; j < placeSize; j++) {
				if(place[i].charAt(j) == 'P') {
					if(!bfs(i, j, place)) {
						return 0;
					}
				}
			}
		}
		return 1;
	}
	
	static boolean bfs(int x, int y, String[] currentPlace) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[placeSize][placeSize];
		q.offer(new Node(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				int manhattan = Math.abs(x - nx) + Math.abs(y - ny);
				
				if(nx < 0 || ny < 0 || nx >= placeSize || ny >= placeSize) {
					continue;
				}
				if(visited[nx][ny] || manhattan > 2) {
					continue;
				}
				
				visited[nx][ny] = true;
				if(currentPlace[nx].charAt(ny) == 'X') {
					continue;
				} else if(currentPlace[nx].charAt(ny) == 'P') {
					return false;
				} else {
					q.offer(new Node(nx, ny));
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[][] example = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
			};
		for(int i : solution(example)) {
			System.out.print(i + ",");
		}
	}

}
