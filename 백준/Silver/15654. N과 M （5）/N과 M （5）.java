import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;
	public static int[] arr1, arr2;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr1 = new int[N];
		arr2 = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		dfs(0);
		System.out.println(sb);
	}
	private static void dfs (int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr2[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr2[depth] = arr1[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}

}