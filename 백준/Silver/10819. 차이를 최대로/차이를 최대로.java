import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr, res;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		res = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(0);
		System.out.println(max);
	}
	static int sum;
	public static void solve(int depth) {
		if(depth == N) {
			sum = 0;
			for(int i = 0; i < N - 1; i++) {
				sum += Math.abs(res[i] - res[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				res[depth] = arr[i];
				solve(depth + 1);
				visited[i] = false;
			}
		}
	}

}