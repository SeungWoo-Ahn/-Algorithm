package boj.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrganicCabbage {
	
	static int T,M,N,K;
	static StringTokenizer st;
	static StringBuilder sb;
	static boolean[][] ground;
	static boolean[][] visited;
	
	static int answer;
	
	static void dfs(int startX, int startY) {
		visited[startX][startY] = true;
		
		// 아래, 위, 좌, 우
		int[] X = {0,0,-1,1};
		int[] Y = {-1,1,0,0};
		
		for(int i=0; i<4; i++) {
			int x = startX + X[i];
			int y = startY + Y[i];
			
			if(x<0 || x>=M || y<0 || y>=N) continue;
			
			if(ground[x][y] && !visited[x][y]) dfs(x, y);
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ground = new boolean[M][N];
			visited = new boolean[M][N];
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[x][y] = true;
			}
			
			answer = 0;
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					
					// 배추가 있고, 방문하지 않은 곳인 경우 => 근처 배추들을 전부 방문
					if(ground[j][k] && !visited[j][k]) {
						dfs(j, k);
						answer++; //해당 배추 그룹에 지렁이 한 마리
					}
				}
			}
			
			sb.append(answer).append('\n');
			
		}
		
		System.out.println(sb);

	}

}
