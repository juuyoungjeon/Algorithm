import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int delete, ans;
	static int[] parents;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		visited = new boolean[N];
		int root = -1;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			
			if(p == -1) {
				root = i;
			}else {
				graph.get(i).add(p);
				graph.get(p).add(i);
			}
		}
		
		delete = Integer.parseInt(br.readLine());
		
		if(delete == root) {
			System.out.println(0);
			return;
		}else dfs(root);
		System.out.println(ans);
		
	}
	
	static void dfs(int v) {
		visited[v] = true;
		int nodes = 0;
		for(int cur : graph.get(v)) {
			if(cur != delete && !visited[cur]) {
				nodes++;
				dfs(cur);
			}
		}
		
		if(nodes == 0) {
			ans++;
		}
		
	}
}