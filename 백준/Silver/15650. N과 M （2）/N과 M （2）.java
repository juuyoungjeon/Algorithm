import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		visited = new boolean[N];
		
		permutation(0,0);
		
		System.out.println(sb);
	}
	
	public static void permutation(int depth, int start) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = i + 1;
				permutation(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}

}