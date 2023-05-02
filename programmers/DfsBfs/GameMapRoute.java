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
		visited = new boolean[n][m]; //�湮���� ����� ����
		
		Queue<Square> q = new LinkedList<>();
		
		//���� ��ġ �߰�
		maps[0][0] = 1;
		q.offer(new Square(0, 0));
		
		while(!q.isEmpty()) {
			Square s = q.poll();
			for(int i=0; i<4; i++) {//�����¿� ��� Ž��
				int x = s.x + X[i];
				int y = s.y + Y[i];
				
				if(x<0 || x>=n || y<0 || y>=m) continue;
				
				if(maps[x][y]==1 && !visited[x][y]) { //���� �ƴϰ� �湮���̸�
					maps[x][y] = maps[s.x][s.y] + 1; //���� �ִܰŸ��� +1
					visited[x][y] = true; //�湮 ó��
					q.offer(new Square(x, y));
				}
			}
		}
		
		if(maps[n-1][m-1]==0) return -1; //Ÿ�� ��ġ�� 0�̶�� ���� ���� ������
		
		return maps[n-1][m-1]; // Ÿ�� ��ġ�� �ִܰŸ� ��ȯ
	}

	public static void main(String[] args) {
		int[][] input = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(input));
	}

}
