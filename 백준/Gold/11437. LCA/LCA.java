import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] parent;
	static int[] depth;
	static ArrayList<ArrayList<Integer>> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		depth = new int[N + 1];
		
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
		
		init(1,1,0);
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(LCA(a,b)).append("\n");
		}
		
		System.out.println(sb);
	}
	public static void init(int current, int height, int p) {
		depth[current] = height;
		parent[current] = p;
		for(int next : list.get(current)) {
			if(next != p) {
				init(next, height + 1, current);
			}
		}
		
	}
	public static int LCA(int a, int b) {
		int ah = depth[a];
		int bh = depth[b];
		while(ah > bh) {
			a = parent[a];
			ah--;
		}
		while(ah < bh) {
			b = parent[b];
			bh--;
		}
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}

}