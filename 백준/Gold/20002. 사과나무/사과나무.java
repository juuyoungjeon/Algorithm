import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] prefixSum = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i][j];
			}
		}
		
		int sum = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			for(int j = i; j <= N; j++) {
				for(int k = i; k <= N; k++) {
					sum = Math.max(sum, prefixSum[j][k] - prefixSum[j-i][k] - prefixSum[j][k-i] + prefixSum[j-i][k-i]);
				}
			}
		}
		System.out.println(sum);
	}

}