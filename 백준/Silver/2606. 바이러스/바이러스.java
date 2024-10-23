import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}
		visited = new boolean[N+1];

		solve(1);

		System.out.println(ans);
	}
	public static void solve(int depth) {
		visited[depth] = true;
		for(int a : list.get(depth)) {
			if(!visited[a]) {
				visited[a] = true;
				ans++;
				solve(a);
			}
		}
	}

}