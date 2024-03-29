import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
	}
	static int ans;
	static int[] cost;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Node>> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			ans = Integer.MAX_VALUE;
			cost = new int[n + 1];
			for(int i = 1; i <= n; i++) {
				cost[i] = Integer.MAX_VALUE;
			}
			list = new ArrayList<>();
			for(int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}
			for(int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				list.get(b).add(new Node(a, s));
			}
			dijkstra(c);
			
			ans = 0;
			int cnt = 0;
			for(int i = 1; i <= n; i++) {
				if(cost[i] != Integer.MAX_VALUE) {
					cnt++;
					ans = Math.max(ans, cost[i]);
				}
			}
			sb.append(cnt + " " + ans).append("\n");
		}
		System.out.println(sb);
		

	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		cost[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(cost[now.idx] < now.cost) continue;
			
			for(Node next : list.get(now.idx)) {
				if(cost[next.idx] > now.cost + next.cost) {
					cost[next.idx] = now.cost + next.cost;
					
					pq.offer(new Node(next.idx, cost[next.idx]));
				}
			}
		}
	}

}