import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static class Node implements Comparable<Node>{
		int end;
		int val;
		public Node(int end, int val) {
			this.end = end;
			this.val = val;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return val - o.val;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b,c));
		}
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(A, 0));
		dist[A] = 0;
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			if(dist[B] < curNode.val) {
				continue;
			}
			for(int i = 0; i < list.get(curNode.end).size(); i++) {
				Node next = list.get(curNode.end).get(i);
				if(dist[next.end] > curNode.val + next.val) {
					dist[next.end] = curNode.val + next.val;
					pq.offer(new Node(next.end, dist[next.end]));
				}
			}
		}
		
		System.out.println(dist[B]);
		
	}

}