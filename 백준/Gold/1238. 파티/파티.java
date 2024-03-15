import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int idx;
		int time;
		public Node(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
		}
	}
	static int n,m,x;
	static boolean[] visited;
	static int min;
	static int ans;
	static int[] dist;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static ArrayList<ArrayList<Node>> reverse = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//n 학생, m 도로, x 파티
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			reverse.add(new ArrayList<>());
		}
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b,c));
			reverse.get(b).add(new Node(a,c));
		}
		
		int[] dist1 = dijkstra(list);
		int[] dist2 = dijkstra(reverse);
		
		ans = 0;
		for(int i = 1; i <= n; i++) {
			ans = Math.max(ans, dist1[i] + dist2[i]);
		}
		
		System.out.println(ans);
	}
	public static int[] dijkstra(ArrayList<ArrayList<Node>> a) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x,0));
		
		visited = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[x] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!visited[now.idx]) {
				visited[now.idx] = true;
				
				for(Node node : a.get(now.idx)) {
					if(!visited[node.idx] && dist[node.idx] > dist[now.idx] + node.time) {
						dist[node.idx] = dist[now.idx] + node.time;
						pq.add(new Node(node.idx, dist[node.idx]));
					}
				}
			}
		}
		return dist;
	}

}