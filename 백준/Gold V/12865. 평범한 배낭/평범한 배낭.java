import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] D = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(W[i] > j) {
					D[i][j] = D[i-1][j]; 
				}else {
					D[i][j] = Math.max(D[i-1][j], V[i] + D[i-1][j-W[i]]);
				}
			}
		}
		
		System.out.println(D[N][K]);
	}

}