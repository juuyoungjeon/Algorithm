import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			for(int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}
			
			visited = new boolean[N+1];
			parent = new int[N+1];
			
			for(int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				parent[b] = a;
				
//				list.get(a).add(b);
//				list.get(b).add(a);
			}
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			solve(x, y);
		}
		System.out.println(sb);
	}
	
	public static void solve(int x, int y) {
		while(x > 0) {
			visited[x] = true;
			x = parent[x];
		}
		
		while(y > 0) {
			if(visited[y]) {
				sb.append(y + "\n");
				break;
			}
			y = parent[y];
		}
	}
	

}