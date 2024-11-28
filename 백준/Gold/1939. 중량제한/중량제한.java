import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static ArrayList<Integer> weight;
	static ArrayList<ArrayList<Node>> list;
	static class Node{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	static int ans;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int start, end;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		weight = new ArrayList<>();
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		int left = 0;
		int right = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b,c));
			list.get(b).add(new Node(a,c));
			right = Math.max(right, c);
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		while(left<=right) {
			int mid = (left + right) / 2;
			ans = -1;
			visited = new boolean[N+1];
			dfs(start, mid);
			if(ans != -1) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}
	public static void dfs(int cur, int limit) {
		if(cur == end) {
			ans = cur;
			return;
		}
		
		visited[cur] = true;
		
		for(Node node : list.get(cur)) {
			if(!visited[node.idx] && limit <= node.cost) {
				dfs(node.idx, limit);
			}
		}
		
	}

}
/*
 * 거리를 찾으면서 최솟값을 리스트에 담는다
 * 
 * 이중에서 가장 큰 값을 찾는다
 * 
 * 
 */