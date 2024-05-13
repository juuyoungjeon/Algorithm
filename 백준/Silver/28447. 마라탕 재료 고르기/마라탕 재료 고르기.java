import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	static int ans = Integer.MIN_VALUE;
	static int sum;
	static int[] comb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		comb = new int[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(K == 0) {
			System.out.println(0);
		}else {
			dfs(0,0);
			System.out.println(ans);
		}
	}
	public static void dfs(int depth, int start) {
		if(depth == K) {
			int[] tmp = new int[2];
			sum = 0;
			check(0,0,tmp);
			ans = Math.max(ans, sum);
			return;
		}
		for(int i = start; i < N; i++) {
			comb[depth] = i;
			dfs(depth + 1, i + 1);
		}
		
	}
	public static void check(int depth, int start, int[] tmp) {
		if(depth == 2) {
			sum += map[tmp[0]][tmp[1]];
			return;
		}
		for(int i = start; i < K; i++) {
			tmp[depth] = comb[i];
			check(depth + 1, i + 1, tmp);
		}
	}

}