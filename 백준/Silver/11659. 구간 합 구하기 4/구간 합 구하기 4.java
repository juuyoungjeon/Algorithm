import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N + 1; i++) {
			update(i, Long.parseLong(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long s = sum(a,b);
			sb.append(s).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void update(int i, long diff) {
		while(i < N + 1) {
			tree[i] += diff;
			i += (i & -i);
		}
	}
	private static long sum(int i) {
		long result = 0;
		while(i > 0) {
			result += tree[i];
			i -= (i & -i);
		}
		return result;
	}
	private static long sum(int i, int j) {
		return sum(j) - sum(i - 1);
	}

}