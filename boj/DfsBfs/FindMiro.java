package boj.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindMiro {
	
	static int N,M;
	static StringTokenizer st;
	static int[][] miro;
	static boolean[][] visited;
	
	static Queue<Node> q = new LinkedList<>();
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int startX, int startY) {
		q.offer(new Node(startX, startY)); //���� ��� ����
		visited[startY][startX] = true; //���� ���� �湮ó��
		
		while(!q.isEmpty()) { //ť�� �� ������
			Node node = q.poll();
			
			for(int i=0; i<4; i++) { //���� �¿� �˻�
				int x = node.x + X[i];
				int y =	node.y + Y[i];
				
				if(x<=0 || x>M || y<=0 || y>N) continue; //���� ����� ������
				
				if(miro[y][x]==1 && !visited[y][x]) { //�� �� �ְ� �湮 ���̸�, ť�� ����, �湮ó��, �ش� ��ǥ�� �ִܰŸ� ����
					q.offer(new Node(x, y));
					
					visited[y][x] = true;
					miro[y][x] = miro[node.y][node.x] +1;

					if(visited[N][M]==true) return; //��ǥ ��ǥ ���޽� ����
				}
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String[] each = br.readLine().split("");
			for(int j=1; j<=M; j++) {
				miro[i][j] = Integer.parseInt(each[j-1]);
			}
		}
		
		bfs(1, 1);
		
		System.out.println(miro[N][M]);

	}

}
