import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		visited = new boolean[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 0; i < N; i++) {
			if(cnt == 0) {
				dfs(i, 1);
			}
		}
		
		System.out.println(cnt);
		
	}
	public static void dfs(int idx, int depth) {
		if(depth == 5) {
			cnt = 1;
			return;
		}
		visited[idx] = true;
		for(int next : list.get(idx)) {
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, depth + 1);
			}
		}
		visited[idx] = false;
	}

}