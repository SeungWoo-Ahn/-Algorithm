package boj.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InteralSum5 {
	
	static int N,M;
	static int table[][];
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		table = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				table[i][j] = table[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		sb = new StringBuilder();
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int i=x1; i<=x2; i++) {
				sum += (table[i][y2]-table[i][y1-1]);
			}
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);

	}

}
