package boj.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumbersSum2 {
	
	static int N,M;
	static int answer = 0;
	static int[] prefixSum;
	static StringTokenizer st;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		prefixSum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=N; i>=1; i--) {
			for(int j=i-1; j>=0; j--) {
				if(prefixSum[i]-prefixSum[j] == M) 
					answer++;
			} 
		}
		
		System.out.println(answer);

	}

}
