import java.util.*;
import java.io.*;

public class Main {
	static int N, M, R;
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static ArrayList<ArrayList<Node>> list;
	static int[] arr;
	static boolean[] visited;
	static int sum;
	static int ans;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		
		dist = new int[N+1];
		for(int i = 1; i <= N; i++) {
			
			bfs(i);
			ans = Math.max(sum, ans);
		}
		
		System.out.println(ans);
	}
	public static void bfs(int idx) {
		sum = 0;
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(idx, 0));
		dist[idx] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(dist[now.idx] < now.cost) continue;
			
			for(Node next : list.get(now.idx)) {
//			for(int i = 0; i < list.get(now.idx).size(); i++) {
//				Node next = list.get(now.idx).get(i);
			
				if(dist[next.idx] > dist[now.idx] + next.cost) {
					dist[next.idx] = dist[now.idx] + next.cost;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(dist[i] <= M) {
				sum += arr[i];
			}
		}
	}

}