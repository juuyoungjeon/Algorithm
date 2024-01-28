import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static int cnt;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static HashSet<String> set;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		set = new HashSet<String>();
		arr = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String s = new String();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, s);
			}
		}
		
		System.out.println(set.size());
	}
	public static void dfs(int x, int y, int depth, String s) {
		if(depth == 6) {
			set.add(s);
			return;
		}
		
		for(int i = 0 ; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= 5 || nextY >= 5) {
				continue;
			}
			dfs(nextX, nextY, depth+1, s+arr[x][y]);
		}
	}

}