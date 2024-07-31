import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static class Node implements Comparable<Node> {
		int start;
		int end;
		int cost;
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static ArrayList<Node> list;
	static int[] parents;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
			
		
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new Node(a,b,c));
		}
		
		Collections.sort(list);
		for(Node node : list) {
			//사이클이 발생하는 간선은 제외
			if(find(node.start) != find(node.end)) {
				ans += node.cost;
				union(node.start, node.end);
			}
		}
		System.out.println(ans);
		
		
	}
	
	public static int find(int x) {
		if(parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			parents[y] = x;
		}
	}

}