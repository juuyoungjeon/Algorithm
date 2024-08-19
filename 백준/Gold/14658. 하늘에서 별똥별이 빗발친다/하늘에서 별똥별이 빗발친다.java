import java.util.*;
import java.io.*;

public class Main {
	static int N,M,L,K;
	static int[][] map;
	static int max = Integer.MIN_VALUE;
	static int cnt;
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Node> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
//		map = new int[N+1][M+1];
		list = new ArrayList<>();
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
//			map[x][y] = 1;
			list.add(new Node(x, y));
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= M; j++) {
		for(Node n1 : list) {
			for(Node n2 : list) {
				cnt = 0;
				for(Node node : list) {
					if(n1.x <= node.x && node.x <= n1.x + L
							&& n2.y <= node.y && node.y <= n2.y + L) {
						cnt++;
					}
					max = Math.max(max, cnt);
				}
			}
		}
		
		System.out.println(K - max);
	}

}