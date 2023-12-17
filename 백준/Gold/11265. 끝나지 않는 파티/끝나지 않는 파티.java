import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int middle = 1; middle < N + 1; middle++) {
			for(int start = 1; start < N + 1; start++) {
				for(int end = 1; end < N + 1; end++) {
					map[start][end] = Math.min(map[start][end], map[start][middle] + map[middle][end]);
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(map[A][B] <= C) {
				sb.append("Enjoy other party").append("\n");
			}else {
				sb.append("Stay here").append("\n");
			}
		}
		System.out.println(sb);
		
	}

}