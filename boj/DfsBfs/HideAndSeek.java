package boj.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
	
	static int N,K;
	static int[] map = new int[100001];
	
	static Queue<Integer> q = new LinkedList<>();
	static int[] move(int pos) {
		int[] arr = new int[3];
		arr[0] = pos-1;
		arr[1] = pos+1;
		arr[2] = pos*2;
		return arr;
	}
	
	static void bfs() {
		q.offer(N);
		map[N] = 1;
		while(!q.isEmpty()) {
			int pos = q.poll();
			for(int i=0; i<3; i++) {
				int newPos = move(pos)[i];
				if(newPos<0 || newPos>100000) continue;
				if(map[newPos]==0) {
					q.offer(newPos);
					map[newPos] = map[pos]+1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(map[K]-1);
	}

}
