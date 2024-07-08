import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] time;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		time = new int[100001];
		parent = new int[100001];
		
		solve();
		Stack<Integer> s = new Stack<>();
		s.push(K);
		
		int idx = K;
		
		while(idx != N) {
			s.push(parent[idx]);
			idx = parent[idx];
		}
		
		sb.append(time[K] - 1 + "\n");
		
		while(!s.isEmpty()) {
			sb.append(s.pop() + " ");
		}
		
		System.out.println(sb);
	}
	public static void solve() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		time[N] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == K) return;
			for(int i = 0; i < 3; i++) {
				int nx = 0;
				if(i == 0) {
					nx = now - 1;
				}else if(i == 1) {
					nx = now + 1;
				}else {
					nx = now * 2;
				}

				if(nx < 0 || nx > 100000) continue;

				if(time[nx] == 0) {
					q.add(nx);
					time[nx] = time[now] + 1;
					parent[nx] = now;
				}
			}
		}
	}

}