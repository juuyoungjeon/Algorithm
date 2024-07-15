import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static int ans;
	static int[] arr;
	static int[] color;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N+1];
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(b).add(a);
			list.get(a).add(b);
		}

		color = new int[N+1];

		if(color[1] == 1) {
			ans = 1;
		}

		ans = dfs(1, 0);

		//		for(int i = 1; i <= N; i++) {
		//			System.out.print(color[i] + " ");
		//		}
		//		System.out.println();

		System.out.println(ans);


	}
	public static int dfs(int now, int parent) {
		int ans = arr[now] == arr[parent]? 0 : 1;
		for(int next : list.get(now)) {
			if(next == parent) continue;
			ans += dfs(next, now);
		}
		return ans;
	}

}