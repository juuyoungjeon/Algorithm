import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> tree;
	static int[] parents;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		parents = new int[N + 1];
		visited = new boolean[N + 1];
		bfs();
		for(int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
		
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int parent = q.poll();
			
			for(int i : tree.get(parent)) {
				if(!visited[i]) {
					visited[i] = true;
					parents[i] = parent;
					q.add(i);
				}
			}
		}
	}

}