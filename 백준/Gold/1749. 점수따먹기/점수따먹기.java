import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][] prefixSum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		prefixSum = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + arr[i][j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				for(int k = i; k > 0; k--) {
					for(int l = j; l > 0; l--) {
						max = Math.max(prefixSum[i][j] - prefixSum[k-1][j] - prefixSum[i][l-1] + prefixSum[k-1][l-1], max);
					}
				}
			}
		}
		
		System.out.println(max);
	}

}