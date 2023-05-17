package boj.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubTotal {
	
	static int N,M;
	static int[] arr;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = N+1;
		
		while(start<=N && end <=N) {
			if(sum >= M && answer > end-start) answer = end-start;
			
			if(sum < M) sum += arr[end++];
			else sum -= arr[start++];
		}

		if(answer==N+1) answer = 0;
		System.out.println(answer);
	}

}
