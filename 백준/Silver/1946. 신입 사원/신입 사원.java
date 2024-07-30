import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static class Node implements Comparable<Node>{
		int a;
		int b;
		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.a - o.a;
		}
	}
	static ArrayList<Node> list;
	//두개 성적 둘다 꼴지면 선발 안함
	//적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.add(new Node(a,b));
			}
			
			Collections.sort(list);
			
			int ans = 1;
			int min = list.get(0).b;
			for(int i = 1; i < N; i++) {
				if(list.get(i).b < min) {
					ans++;
					min = list.get(i).b;
				}
			}
			
			sb.append(ans + "\n");
		}
		
		System.out.println(sb);
	}

}