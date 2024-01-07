import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static class Node implements Comparable<Node>{
		int end;
		int val;
		public Node(int end, int val) {
			this.end = end;
			this.val = val;
		}
		//오름차순
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return val - o.val;
		}
	}
	static long ans;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		
		for(int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int w = Integer.parseInt(st.nextToken());
				list.get(i).add(new Node(j, w));
			}
		}
		
		prim();
		System.out.println(ans);
	}
	
	public static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0));
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.end]) continue;
			
			visited[now.end] = true;
			
			ans += now.val;
			cnt++;
			
			for(Node next : list.get(now.end)) {
				if(!visited[next.end]) {
					pq.add(next);
				}
			}
			
			if(cnt == N) break;
		}
	}

}