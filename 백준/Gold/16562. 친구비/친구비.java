import java.util.*;
import java.io.*;

public class Main {
	static int n, m, k;
	static boolean[] visited;
	static int[] cost, parent;
	static int v,w;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		visited = new boolean[n + 1];
		cost = new int[n + 1];
		parent = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			if(v > w) {
				union(w, v);
			}else {
				union(v, w);
			}
		}
		
		long cnt = 0;
		for(int i = 1; i <= n; i++) {
			int idx = find(i);
			
			if(!visited[idx]) {
				cnt += cost[idx];
				visited[idx] = true;
			}
			
			visited[i] = true;
		}
		
		System.out.println(cnt> k? "Oh no" : cnt);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(cost[a] > cost[b]) {
			parent[a] = b;
		}else {
			parent[b] = a;
		}
	}
	public static int find(int a) {
		if(a == parent[a]) {
			return a;
		}else {
			return parent[a] = find(parent[a]);
		}
	}

}