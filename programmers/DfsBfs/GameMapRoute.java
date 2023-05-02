package programmers.DfsBfs;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapRoute {
	
	static boolean[][] visited;
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	static class Square {
		int x;
		int y;
		public Square(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int solution(int [][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		visited = new boolean[n][m]; //방문여부 기록을 위해
		
		Queue<Square> q = new LinkedList<>();
		
		//현재 위치 추가
		maps[0][0] = 1;
		q.offer(new Square(0, 0));
		
		while(!q.isEmpty()) {
			Square s = q.poll();
			for(int i=0; i<4; i++) {//상하좌우 모두 탐색
				int x = s.x + X[i];
				int y = s.y + Y[i];
				
				if(x<0 || x>=n || y<0 || y>=m) continue;
				
				if(maps[x][y]==1 && !visited[x][y]) { //벽이 아니고 방문전이면
					maps[x][y] = maps[s.x][s.y] + 1; //이전 최단거리에 +1
					visited[x][y] = true; //방문 처리
					q.offer(new Square(x, y));
				}
			}
		}
		
		if(maps[n-1][m-1]==0) return -1; //타겟 위치가 0이라면 벽에 막혀 못간것
		
		return maps[n-1][m-1]; // 타겟 위치의 최단거리 반환
	}

	public static void main(String[] args) {
		int[][] input = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(input));
	}

}
