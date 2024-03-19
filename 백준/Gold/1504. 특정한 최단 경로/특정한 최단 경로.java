import java.util.*;
import java.io.*;

public class Main {

	static int N, E;
	static ArrayList<ArrayList<Node>> a;
	static int[] dist;
	static boolean[] visited;
	static final int INF = 200000000;
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		a = new ArrayList<>();
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		Arrays.fill(dist, INF);
		
		for(int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			a.get(start).add(new Node(end, weight));
			a.get(end).add(new Node(start, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);
		
		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);
		
		int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);
		
		System.out.println(ans);
	}
	private static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(visited, false);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			
			if(!visited[cur]) {
				visited[cur] = true;
				
				for(Node node : a.get(cur)) {
					if(!visited[node.end] && dist[node.end] > dist[cur] + node.weight) {
						dist[node.end] = dist[cur] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
		return dist[end];
	}

}