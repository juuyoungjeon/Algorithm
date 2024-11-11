import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		
		for(int i = 1; i < N + 1; i++) {
			arr[i][i] = 1;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			
			arr[a][b] = 1;//a>b
			arr[b][a] = -1;//b>a
		}
		
		for(int k = 1; k < N + 1; k++) {
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
					if(arr[i][k] == -1 && arr[k][j] == -1) {
						arr[i][j] = -1;
					}
				}
			}
		}
		
		for(int i = 1; i < N + 1; i++) {
			int cnt = 0;
			for(int j = 1; j < N + 1; j++) {
				if(arr[i][j] != 0) {
					cnt++;
				}
			}
			sb.append((N-cnt)+"\n");
		}
		
		System.out.println(sb);
		
	}
	/*
	 * 1 2
	 * 2 3
	 * 3 4
	 * 5 4
	 * 6 5
	 * 
	 * 
	 * 1 2 3 4
	 * 
	 * 6 5 4
	 * */

}