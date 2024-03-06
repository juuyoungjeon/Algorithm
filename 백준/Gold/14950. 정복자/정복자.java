//프림알고리즘

import java.util.*;
import java.io.*;

public class Main {
	static int n,m,t;
	static int cnt, ans;
	static class Node implements Comparable<Node>{
		int next;
		int cost;
		public Node(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	static ArrayList<ArrayList<Node>> list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		visited = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		
		solve(1);
		
		System.out.println(ans);
	}
	
	public static void solve(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
//		visited[start] = true;
		
		cnt = 0;
		ans = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!visited[now.next]) {
				visited[now.next] = true;
				ans += now.cost;
				cnt++;
				
				if(cnt > 2) {
					ans += t*(cnt - 2);
				}
				
				for(Node next : list.get(now.next)) {
					if(!visited[next.next]) {
						pq.add(next);
					}
				}
			}
		}
	}

}