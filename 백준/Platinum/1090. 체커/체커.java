import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Node> list = new ArrayList<>();
	static int[] ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		ans = new int[N];
		
		Arrays.fill(ans, Integer.MAX_VALUE);
		
		for(int[] x : map) {
			for(int[] y : map) {
				int[] costs = new int[N];
				for(int i = 0; i < N; i++) {
					costs[i] = Math.abs(x[0] - map[i][0]) + Math.abs(y[1] - map[i][1]);
				}
				
				Arrays.sort(costs);
				int cost = 0;
				for(int i = 0; i < N; i++) {
					cost += costs[i];
					ans[i] = Math.min(cost, ans[i]);
				}
			}
		}
		
		for(int i : ans) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}

}