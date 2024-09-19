import java.util.*;
import java.io.*;

public class Main {
	static int K;
	static int[] arr;
	static boolean[] visited;
	static int[] res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			
			if(K == 0) break;
			
			arr = new int[K];
			res = new int[K];
			visited = new boolean[K];
			
			for(int i = 0; i < K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			solve(0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	public static void solve(int depth, int start) {
		if(depth == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < K; i++) {
			if(!visited[i]) {
				visited[i] = true;
				res[depth] = arr[i];
				solve(depth + 1, i+1);
				visited[i] = false;
			}
			
//			res[depth] = arr[i];
//			solve(depth + 1, i + 1);
		}
	}

}