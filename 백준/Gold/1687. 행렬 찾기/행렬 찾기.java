import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int max;
	static int[] height;
	static int[] left, right;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		height = new int[M+1];
		right = new int[M+1];
		left = new int[M+1];
		
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j-1) - '0';
			}
		}
		
		for(int i = 1; i <= M; i++) {
			right[i] = M;
		}
		
		for(int i = 1; i <= N; i++) {
			int curLeft = 1; int curRight = M;
			
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == 0) {
					height[j]++;
					left[j] = Math.max(curLeft, left[j]);
				}else {
					height[j] = 0;
					left[j] = 1;
					curLeft = j + 1;
				}
			}
			
			for(int j = M; j >= 1; j--) {
				if(map[i][j] == 0) {
					right[j] = Math.min(right[j], curRight);
				}else {
					right[j] = M;
					curRight = j - 1;
				}
			}
			
			for(int j = 1; j <= M; j++) {
				max = Math.max(max, (right[j] - left[j] + 1) * height[j]);
			}
		}
		
		System.out.println(max);
	}
}