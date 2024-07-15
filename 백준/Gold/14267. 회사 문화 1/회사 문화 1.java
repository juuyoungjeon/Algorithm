import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static ArrayList<ArrayList<Integer>> list;
	static int ans;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		arr = new int[n+1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a != -1) {
				list.get(a).add(i);
			}
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a] += b;
		}
		
		dfs(1);
		for(int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void dfs(int idx) {
		for(int next : list.get(idx)) {
			arr[next] += arr[idx];
			dfs(next);
		}
	}
	

}