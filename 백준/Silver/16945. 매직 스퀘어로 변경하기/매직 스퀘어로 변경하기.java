import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[] visited;
	static int ans = 30;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[3][3];

		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		visited = new boolean[10];
		
		dfs(0,0);
		System.out.println(ans);
		
		
	}
	public static void dfs(int depth, int cost) {
		if(depth == 9 && sum()) {
			ans = Math.min(ans, cost);
			return;
		}
		int x = depth / 3;
		int y = depth % 3;
		
		for(int num = 1; num <= 9; num++) {
			if(!visited[num]) {
				int tmp = map[x][y];
				visited[num] = true;
				map[x][y] = num;
				dfs(depth + 1, cost + Math.abs(tmp - num));
				visited[num] = false;
				map[x][y] = tmp;
			}
		}
	}
	public static boolean sum() {
		int row1 = 0;
		int row2 = 0;
		int row3 = 0;
		int col1 = 0;
		int col2 = 0;
		int col3 = 0;
		int cross1 = map[0][0] + map[1][1] + map[2][2];
		int cross2 = map[0][2] + map[1][1] + map[2][0];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 0) {
					row1 += map[i][j];
				}else if(i == 1) {
					row2 += map[i][j];
				}else if(i == 2) {
					row3 += map[i][j];
				}
				if(j == 0) {
					col1 += map[i][j];
				}else if(j == 1) {
					col2 += map[i][j];
				}else if(j == 2) {
					col3 += map[i][j];
				}
			}
		}
		
		if(row1 == row2 && row2 == row3 && row3 == col1 && col1 == col2 && col2 == col3 && col3 == cross1 && cross1 == cross2) {
			return true;
		}
		return false;
	}

}