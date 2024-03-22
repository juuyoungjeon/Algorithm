import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static boolean[] visited;
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		arr = new int[N];
		cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(0, 500);
		
		System.out.println(cnt);
		
		
	}
	public static void solve(int depth, int sum) {
		if(depth == N) {
			if(sum >= 500) {
				cnt++;
			}
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i] && sum >= 500) {
				visited[i] = true;
				solve(depth + 1, sum + arr[i] - K);
				visited[i] = false;
			}
		}
	}

}