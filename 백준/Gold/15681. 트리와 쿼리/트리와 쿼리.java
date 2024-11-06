import java.util.*;
import java.io.*;

public class Main {
	static int N, R, Q;
	static ArrayList<ArrayList<Integer>> list;
	static int[] size;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		size = new int[N+1];
		for(int i = 1; i <= N; i++) {
			size[i] = 1;
		}
		dfs(R,0);
		for(int i = 0; i < Q; i++) {
			sb.append(size[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb);
	}
	public static void dfs(int cur, int prev) {
		for(int next : list.get(cur)) {
			if(next == prev) continue;
			dfs(next, cur);
			size[cur] += size[next];
		}
	}

}