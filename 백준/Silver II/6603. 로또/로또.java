import java.util.*;
import java.io.*;

public class Main {
	static int K;
	static int[] S, arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			
			if(K == 0) break;
			
			S = new int[K];
			
			for(int i = 0; i < K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			visited = new boolean[K];
			arr = new int[6];
			sb = new StringBuilder();
			dfs(0, 0);
			System.out.println(sb);
			
		}
		
		
	}
	
	public static void dfs(int depth, int start) {
		if(depth == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i < K; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = S[i];
				dfs(depth + 1, i);
				visited[i] = false;
			}
		}
	}

}