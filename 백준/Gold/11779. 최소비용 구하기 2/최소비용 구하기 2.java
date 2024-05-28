import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] dist;
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
	static int ans = Integer.MAX_VALUE;
	static int start, end;
	static int[] preCity;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		preCity = new int[n+1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(s).add(new Node(e, c));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		System.out.println(dist[end]); // 최단거리
		
		//경로 역주척
		int cnt = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		while(preCity[end] != 0) {
			cnt += 1;
			stack.push(preCity[end]);
			end = preCity[end];
		}
		System.out.println(cnt+1);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	public static void dijkstra(int start) {
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.idx;
			if(dist[cur] < curNode.cost) {
				continue;
			}
//			for(int i = 0; i < list.get(curNode.idx).size(); i++) {
//				Node next = list.get(curNode.idx).get(i);
				for(Node next : list.get(cur)) {
				if(dist[next.idx] > dist[cur] + next.cost) {
					dist[next.idx] = dist[cur] + next.cost;
					preCity[next.idx] = cur;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
	}

}