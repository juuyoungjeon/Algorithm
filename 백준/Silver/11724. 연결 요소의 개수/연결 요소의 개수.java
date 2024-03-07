import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<Integer>[] adj;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	adj = new ArrayList[n+1];
	visited = new boolean[n+1];
	int v1,v2,ans = 0;
	
	for(int i = 1; i < n+1; i++) {
		adj[i] = new ArrayList<Integer>();
	}
	for(int i = 0; i < m; i++) {
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		adj[v1].add(v2);
		adj[v2].add(v1);
	}
	for(int i = 1; i < n+1; i++) {
		if(!visited[i]) {
			dfs(i);
			ans++;
		}
	}
	System.out.println(ans);

	}
	
	static void dfs(int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		for(int i : adj[v]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}

}
