package boj.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsAndBfs {
	
	static StringTokenizer st;
	static int n,m,v;
	static int[][] graph;
	static boolean[] visited;
	static StringBuilder sb,sb2;
	
	static void dfs(int v) {
		visited[v] = true;
		sb.append(v+" ");
		
		for(int i=1; i<=n; i++) {
			if(graph[v][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static Queue<Integer> q;
	
	static void bfs(int v) {
		q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		sb2.append(v+" ");
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=1; i<graph.length; i++) {
				if(graph[temp][i]==1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					sb2.append(i+" ");
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		graph = new int[1001][1001];
		visited = new boolean[1001];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		dfs(v);
		visited = new boolean[1001];
		bfs(v);
		sb.append('\n').append(sb2);
		
		System.out.println(sb.toString());

	}

}
