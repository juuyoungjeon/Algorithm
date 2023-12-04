import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int tc = 1; tc <= M; tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		visited = new boolean[N + 1];
		visited[1] = true;
		dfs(1, 0);
		
		int ans = 0;
		for(int i = 2; i < visited.length; i++) {
			if(visited[i]) ans++;
		}
		System.out.println(ans);
		
	}
	public static void dfs(int point, int cnt) {
		if(cnt == 2) {
			return;
		}
		for(int i : list.get(point)) {
			visited[i] = true;
			dfs(i, cnt+1);
		}
	}

}