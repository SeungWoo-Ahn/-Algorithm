package boj.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class NumberingEstate {
	
	static int N;
	static boolean[][] map;
	static boolean[][] visited;
	static int cnt=0;
	
	static ArrayList<Integer> cntArr = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	
	static void dfs(int startX, int startY) {
		visited[startX][startY] = true;
		cnt++;
		
		for(int i=0; i<4; i++) {//�����¿� Ž��
			int x = startX + X[i];
			int y = startY + Y[i];
			
			if(x<0 || x>=N || y<0 || y>=N) continue;//������ ����� ������
			
			if(map[x][y] && !visited[x][y]) dfs(x, y);//���� �ְ� �湮���̸� ���
			
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = line[j].equals("1");
			}
		}
		/////////////////�Է�
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]&&map[i][j]) { //������ ��� Ž���ϸ� ���� �ְ� �湮���̸� DFS
					dfs(i, j);
					cntArr.add(cnt);
					cnt = 0;
				}
			}
		}
		////////////////DFS
		
		
		Collections.sort(cntArr);
		int size = cntArr.size();
		sb.append(size).append('\n');
		for(int i=0; i<size; i++) {
			sb.append(cntArr.get(i)).append('\n');
		}

		System.out.println(sb);
		
	}

}
