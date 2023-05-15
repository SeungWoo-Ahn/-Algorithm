package boj.DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedGreenColorWeakness {
	
	static int N;
	static String[][] grid;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new String[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String[] each = br.readLine().split("");
			for(int j=0; j<N; j++) {
				grid[i][j] = each[j];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(grid[i][j]+'\t');
			}
			System.out.println();
		}
	}

}
