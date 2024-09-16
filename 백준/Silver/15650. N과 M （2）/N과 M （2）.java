import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] res;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		res = new int[M];
		visited = new boolean[N];
		
		solve(0, 0);
		
		System.out.println(sb);
		
	}
	public static void solve(int depth, int start) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				res[depth] = i + 1;
				solve(depth + 1, i);
				visited[i] = false;
			}
		}
	}

}