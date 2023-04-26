package boj.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkNodeCount {
	
	static int N,M;
	static StringTokenizer st;
	static boolean[][] graph;
	static boolean[] visited;
	static int answer = 0;
	
	static void dfs(int node) {
		
		if(visited[node]) return;
		
		visited[node] = true;
		
		for(int i=1; i<=N; i++) {
			if(graph[node][i]&&!visited[i]) {
				dfs(i);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = true;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		
		System.out.println(answer);	

	}

}
