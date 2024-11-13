import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(com == 0) {
				union(a, b);
			}else if(com == 1) {
				sb.append((isSameParent(a, b) ? "YES" : "NO") + "\n");
			}else {
				continue;
			}
		}
		
		System.out.println(sb);
	}
	public static int find(int x) {
		if(x == parent[x])
			return x;
		
		return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) {
			return true;
		}
		
		return false;
	}

}