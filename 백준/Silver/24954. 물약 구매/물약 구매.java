import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr; //물약 가격
	static class Node{
		int idx;
		int cost;
		public Node(int idx, int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
	static ArrayList<ArrayList<Node>> list;
	static boolean[] visited;
	static int cnt;
	static int ans = Integer.MAX_VALUE;
	static int[] copy;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		copy = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for(int i = 1; i <= N; i++) {
			int t = Integer.parseInt(br.readLine());
			while(t-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				list.get(i).add(new Node(a, b));
			}
		}
		
		visited = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, arr[i], 1, arr);
			visited[i] = false;
		}

		System.out.println(ans);
	}
	public static void dfs(int start, int sum, int depth, int[] origin) {
		if(depth == N) {
			ans = Math.min(ans, sum);
			return;
		}

		int[] copy = Arrays.copyOf(origin, N+1);
		
		for(Node n : list.get(start)) {
			copy[n.idx] -= n.cost;
			if(copy[n.idx] <= 0) copy[n.idx] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			if(!visited[k]) {
				visited[k] = true;
				dfs(k, sum + copy[k], depth + 1, copy);
				visited[k] =false;
			}
		}

	
	}
}