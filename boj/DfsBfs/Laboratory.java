package boj.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory {
	
	static int N,M;
	static StringTokenizer st;
	static int[][] map;
	
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	static int maxZone=0;
	
	static void dfs(int wallCnt) {
		
		//벽 3개를 세우면 BFS 실행
		if(wallCnt==3) {
			bfs();
			return;
		}
		
		//전체 탐색으로 벽 세우기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(wallCnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static Queue<Virus> q;
	static class Virus {
		int x;
		int y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs() {
		q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) {
					q.offer(new Virus(i, j));
				}
			}
		}
		
		//기존 map을 유지하기 위한 복사본
		int[][] cloneMap = new int[N][M];
		for(int i=0; i<N; i++) {
			cloneMap[i] = map[i].clone();
		}
		
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			
			for(int i=0; i<4; i++) {
				int x = virus.x + X[i];
				int y = virus.y + Y[i];
				
				if(x<0 || x>=N || y<0 || y>=M) continue;
				
				if(cloneMap[x][y]==0) {
					q.offer(new Virus(x, y));
					cloneMap[x][y] = 2;
				}
			}
		}
		
		int safeCnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M ; j++) {
				if(cloneMap[i][j]==0) safeCnt++;
			}
		}
		
		if(safeCnt > maxZone) {
			maxZone = safeCnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
	
		System.out.println(maxZone);
	}

}
