import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static int N;
	static boolean[] visited;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
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
		
		visited = new boolean[N + 1];
		parents = new int[N + 1];
		
		dfs(1);
		for(int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}
	
	public static void dfs(int index) {
		visited[index] = true;
		
		for(int i : list.get(index)) {
			if(!visited[i]) {
				parents[i] = index;
				dfs(i);
			}
		}
	}

}