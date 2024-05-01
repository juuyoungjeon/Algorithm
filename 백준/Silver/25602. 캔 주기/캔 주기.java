import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] A;
	static int[][] R, M;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		R = new int[K][N];
		M = new int[K][N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0);
		
		System.out.println(max);
		
	}
	public static void dfs(int depth, int Rang, int Mary) {
		if(depth == K) {
			max = Math.max(max, Rang + Mary);
			return;
		}
//		for (int i = 0; i < N; i++) {
//			if (A[i] == 0) {
//				continue;
//			}
//			A[i]--;
//			dfs(depth+1, Rang + R[depth][i], Mary);
//			dfs(depth+1, Rang, Mary + M[depth][i]);
//			for (int j = 0; j < N; j++) {
//				if (A[j] == 0) {
//					
//				}
//			}
//		}
		for(int i = 0; i < N; i++) {
			int newRang = Rang;
			int newMary = Mary;
			if(A[i] > 0) {
				A[i]--;
				newRang += R[depth][i];
				for(int j = 0; j < N; j++) {
					if(A[j]>0) {
						A[j]--;
						newMary += M[depth][j];
						dfs(depth + 1, newRang, newMary);
						newMary -= M[depth][j];
						A[j]++;
					}
				}
				newRang -= R[depth][i];
                A[i]++;
			}
		}
	}

}