import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		visited = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int start) {
		if(visited[start]) return;
		
		visited[start] = true;
		
		for(int next : list.get(start)) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}

}