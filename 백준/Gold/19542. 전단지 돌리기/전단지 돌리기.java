import java.util.*;
import java.io.*;

public class Main {
	static int N, S, D, cnt;
	static int[] depth;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		depth = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(S, -1);
		System.out.println(cnt*2);
	}
	public static int dfs(int idx, int pa) {
		for(int next : list[idx]) {
			if(next != pa) {
				depth[idx] = Math.max(depth[idx], dfs(next, idx) + 1);
			}
		}
		
		if(idx != S && depth[idx] >= D) {
			cnt++;
		}
		return depth[idx];
	}

}