package boj.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntervalSum4 {
	
	static int N,M;
	static int[] arr;
	static int[] prefixSum;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		prefixSum = new int[N+1];
		for(int i=1; i<=N; i++) {
			prefixSum[i] = prefixSum[i-1] + arr[i];
		}
		
		sb = new StringBuilder();
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			sb.append(prefixSum[to]-prefixSum[from-1]).append('\n');
		}
		
		System.out.println(sb);
	}

}
