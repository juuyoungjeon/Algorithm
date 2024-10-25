import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static int start,end;
	static int ans = -1;
	static int cnt;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
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
		
		dfs(start, 0);
		
		System.out.println(ans);
		
	}
	public static void dfs(int num, int cnt) {
		if(num == end) {
			ans = cnt;
			return;
		}
		
		visited[num] = true;
		
		for(int i : list.get(num)) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1);
			}
		}
		
		
	}

}