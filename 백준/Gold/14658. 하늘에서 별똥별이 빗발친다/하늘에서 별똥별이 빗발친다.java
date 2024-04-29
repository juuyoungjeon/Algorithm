import java.util.*;
import java.io.*;

public class Main {
	static int N,M,L,K;
	static int[][] map;
	static int[] arr;
	static int max;
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Node> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());


		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.add(new Node(a,b));

		}

		for(Node n1 : list) {
			for(Node n2 : list) {
				int cnt = 0;
				for (Node node : list) {
					if (n1.x <= node.x && node.x <= n1.x + L && n2.y <= node.y && node.y <= n2.y + L) {
						cnt++;
					}
					max = Math.max(cnt, max);
				}
			}
		}
		
		System.out.println(K - max);

	}

}