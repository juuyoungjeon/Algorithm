import java.util.*;
import java.io.*;

public class Main {
	static int N, A, B;
	static class Node implements Comparable<Node>{
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Node o) {
			if(o.y == y) {
				return x - o.x;
			}
			return y - o.y;
		}
		
	}
	static ArrayList<Node> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Node(y, x));
		}
		
		Collections.sort(list);
		
		int ans = 0;
		for(Node p : list) {
			Node p1 = new Node(p.y + B, p.x+A);
			Node p2 = new Node(p.y, p.x+A);
			Node p3 = new Node(p.y + B, p.x);
			
			if(find(p1) && find(p2) && find(p3)) {
				ans++;
			}
			
		}
		System.out.println(ans);
	}
	
	public static boolean find(Node p) {
		int start = 0; int end = N;
		
		while(start + 1 < end) {
			int mid = (start + end) / 2;
			Node now = list.get(mid);
			
			//1. y가 작으면 올려야된다
			//2. y가 더 크면 줄여야 한다
			//3. y가 같다면 x비교
			if(p.y > now.y || (p.y == now.y && p.x >= now.x)) {
				start = mid;
			}else {
				end = mid;
			}
		}
		if(list.get(start).y == p.y && list.get(start).x == p.x) {
			return true;
		}
		return false;
	}

}