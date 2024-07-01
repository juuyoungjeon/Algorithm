import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int ans;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
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
		
		visited = new boolean[N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		dfs(1);
		System.out.println(ans);
		
	}
	public static void dfs(int start) {
		visited[start] = true;
		for(int a : list.get(start)) {
			if(!visited[a]) {
				visited[a] = true;
				ans++;
				dfs(a);
			}
		}
	}

}