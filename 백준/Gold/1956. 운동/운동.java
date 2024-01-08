import java.util.*;
import java.io.*;

public class Main {
	static int v, e;
	static int cnt = 0;
	static int[][] map;
	static int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		map = new int[v+1][v+1];
		
		for(int i = 1; i < v + 1; i++) {
			for(int j = 1; j < v + 1; j++) {
				if(i != j) {
					map[i][j] = INF;
				}
			}
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			map[start][end] = val;
		}
		
		for(int middle = 1; middle <= v; middle++) {
			for(int start = 1; start <= v; start++) {
				for(int end = 1; end <= v; end++) {
					if(start == end) continue;
					map[start][end] = Math.min(map[start][middle] + map[middle][end], map[start][end]);
				}
			}
		}
		
		int ans = INF;
		for(int i = 1; i <= v; i++) {
			for(int j = 1; j <= v; j++) {
				if(i == j) {
					continue;
				}
				
				if(map[i][j] != INF && map[j][i] != INF) {
					ans = Math.min(ans, map[i][j] + map[j][i]);
				}
			}
		}
		
		sb.append(ans = (ans == INF) ? -1 : ans);
		
		System.out.println(sb);
	}

}