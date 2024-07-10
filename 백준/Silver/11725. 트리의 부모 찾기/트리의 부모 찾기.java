import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] parents;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		visited = new boolean[N+1];
		parents = new int[N+1];
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		dfs(1);
		for(int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	public static void dfs(int idx) {
		visited[idx] = true;
		
		for(int i : list.get(idx)) {
			if(!visited[i]) {
				visited[i] = true;
				parents[i] = idx;
				dfs(i);
			}
		}
	}

}