import java.util.*;
import java.io.*;

public class Main {
	static int N, M, R;
	static int[][] map;
	static int[] arr;
	static int sum;
	static int ans;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		map = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i==j) continue;
				map[i][j] = INF;
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = c;
			map[b][a] = c;
		}
		for(int j = 1; j <= N; j++) {
			for(int i = 1; i <= N; i++) {
				for(int k = 1; k <= N; k++) {
					if(map[i][k] > map[i][j] + map[j][k]) {
						map[i][k] = map[i][j] + map[j][k];
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			sum = 0;
			for(int j = 1; j <= N; j++) {
				if(map[i][j] <= M) {
					sum += arr[j];
				}
			}
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}

}