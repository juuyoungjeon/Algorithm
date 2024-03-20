import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visited = new boolean[100000 * 20 + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			visited[arr[i]] = true;
		}
		
		solve(0,0);
		
		for(int i = 0; i < 100000*20 + 1; i++) {
			if(!visited[i]) {
				System.out.println(i);
				break;
			}

		}
		
	}
	public static void solve(int depth, int sum) {
		if(depth == N) {
			visited[sum] = true;
			return;
		}
		solve(depth + 1, sum + arr[depth]);
		solve(depth + 1, sum);
	}

}