import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 0x3f3f3f3f;
    static int n, m, ans = INF;
    static int[][] matrix = new int[1001][1001];
    static int[][][] d = new int[1001][1001][4];
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int[][] arr2d : d) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, INF);
            }
        }

        for (int i = 1; i <= m; i++) {
            ans = Math.min(ans, dp(0, i, 0));
        }
        System.out.println(ans);
    }

    static int dp(int r, int c, int dir) {
        if (1 > c || c > m) return INF;
        if (r == n) return matrix[r][c];
        if (d[r][c][dir] != INF) return d[r][c][dir];

        for (int i = 1; i <= 3; i++) {
            if (i == dir) continue;
            d[r][c][dir] = Math.min(d[r][c][dir], matrix[r][c] + dp(r + 1, c + dc[i], i));
        }
        return d[r][c][dir];
    }
	
//	static int N, M;
//	static int[][] map;
//	static int[][][] dp;
//	static int[] dx = {1,1,1};
//	static int[] dy = {-1,0,1};
//	static int min = Integer.MAX_VALUE;
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		map = new int[N][M];
//		
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 0; j < M; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		dp = new int[1001][1001][4];
//		for(int[][] arr2 : dp) {
//			for(int[] arr : arr2) {
//				Arrays.fill(arr, Integer.MAX_VALUE);
//			}
//		}
//		
//		for(int i = 0; i < M; i++) {
//			min = Math.min(min, recur(0,i,0));
//		}
//		
//		System.out.println(min);
//	}
//	public static int recur(int x, int y, int dir) {
//		if(x == N - 1) {
//			return dp[x][y][dir];
//		}
//		if(dp[x][y][dir] != Integer.MAX_VALUE) {
//			return dp[x][y][dir];
//		}
////		if(x < 0 || y < 0 || x >= N || y >= M) {
////			return Integer.MAX_VALUE;
////		}
//		
//		int ret = dp[x][y][dir];
//		
//		for(int i = 0; i < 3; i++) {
//			int nx = x + dx[i];
//			int ny = y + dy[i];
//			
//			if(dir == i) continue;
//			if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1) continue;
//			ret = Math.min(recur(nx, ny, i) + map[x][y], ret);
//		}
//		
//		dp[x][y][dir] = ret;
//		
//		return dp[x][y][dir];
//	}

}