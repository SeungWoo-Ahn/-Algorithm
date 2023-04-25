package boj.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus {
	
	static int n,m; // 컴퓨터의 개수, 연결된 컴퓨터 수
	static StringTokenizer st;
	static int[][] network;
	static boolean[] visited;
	
	static int answer= 0;
	
	static void dfs(int c){
		visited[c] = true;
		
		for(int i=1; i<=n; i++) {
			if(network[c][i]==1 && !visited[i]) {
				answer++;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		network = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());

			network[a][b] = network[b][a] = 1;
		}
		
		dfs(1);
		System.out.println(answer);
		
	}

}
