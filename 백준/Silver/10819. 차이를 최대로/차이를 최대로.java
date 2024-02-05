import java.util.*;
import java.io.*;

public class Main {
	static int[] arr, result;
	static boolean[] visited;
	static int N, ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visited = new boolean[N];
		result = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		System.out.println(ans);
	}
	public static void dfs(int depth) {
		if(depth == N) {
			int sum = 0;
			for(int i = 0; i < N - 1; i++) {
				sum += Math.abs(result[i] - result[i + 1]);
			}
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

}