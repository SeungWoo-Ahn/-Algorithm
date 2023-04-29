package boj.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
	
	static int M,N;
	static StringTokenizer st;
	static int[][] container;
	
	static int[] X = {0,0,-1,1};
	static int[] Y = {-1,1,0,0};
	static Queue<MTomato> q = new LinkedList<>();
	
	static class MTomato {
		int x;
		int y;
		public MTomato(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int bfs() {
		while(!q.isEmpty()) {
			MTomato mTomato = q.poll();
			for(int i=0; i<4; i++) {
				int x = mTomato.x + X[i];
				int y = mTomato.y + Y[i];
				
				if(x<0 || x>=N || y<0 || y>=M) continue;
				
				if(container[x][y] == 0) {
					container[x][y] = container[mTomato.x][mTomato.y] + 1;
					q.offer(new MTomato(x, y));
				}
			}
		}
		
		int max = 0;
		if(checkZero()) return -1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(max < container[i][j]) max = container[i][j];
			}
		}
		
		return max-1;
		
	}
	
	static boolean checkZero() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(container[i][j]==0) return true;
			}
		}
		return false;
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		container = new int[N][M]; 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				container[i][j] = Integer.parseInt(st.nextToken());
				if(container[i][j] == 1) {
					q.offer(new MTomato(i, j));
				}
			}
		}
		
		System.out.println(bfs());
	}

}
