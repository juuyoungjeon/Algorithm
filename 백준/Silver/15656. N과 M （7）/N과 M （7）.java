import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		visited = new boolean[N];
		arr = new int[M];
		dfs(0);
		System.out.println(sb);
		
	}

	private static void dfs(int depth) {
		// TODO Auto-generated method stub
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
//			if(!visited[i]) {
//				visited[i] = true;
				arr[depth] = input[i];
				dfs(depth + 1);
//				visited[i] = false;
//			}
		}
	}

}