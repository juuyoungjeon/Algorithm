import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int mp, mf, ms, mv;
	static int[] p, f, s, v, c;
	static int min = Integer.MAX_VALUE;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] ans;
	static int[] selected;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());

		p = new int[N];
		f = new int[N];
		s = new int[N];
		v = new int[N];
		c = new int[N];

		ans = new int[N];
		selected = new int[N];

		Arrays.fill(ans, -1);
		Arrays.fill(selected, -1);
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			f[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0,0,0,0,0);

		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		sb.append(min).append("\n");
		for(int i = 0; i < N; i++) {
			if(ans[i] != -1) {
				sb.append(ans[i] + 1).append(" ");
			}
		}
		System.out.println(sb);

	}
	public static void dfs(int depth, int protein, int fat, int carbon, int vitamin, int cost) {
		if(protein >= mp && fat >= mf && carbon >= ms && vitamin >= mv && cost < min) {
			for(int i = 0; i < N; i++) {
				ans[i] = selected[i];
			}
			min = cost;
//			min = Math.min(min, cost);
			return;
		}
		if(depth == N) {
			return;
		}
		selected[depth] = depth;
		dfs(depth + 1, protein + p[depth], fat + f[depth], carbon + s[depth], vitamin + v[depth], cost + c[depth]);
		selected[depth] = -1;
		dfs(depth + 1, protein, fat, carbon, vitamin, cost);
	}

}