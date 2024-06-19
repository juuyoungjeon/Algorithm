import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] parent;
	static int[] cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		parent = new int[1000001];
		cnt = new int[1000001];
		
		for(int i = 1; i <= 1000000; i++) {
			parent[i] = i;
			cnt[i] = 1;
		}
		for(int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			if(arr[0].equals("I")) {
//				int a = Math.min(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
//				int b = Math.max(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
				int a = Integer.parseInt(arr[1]);
				int b = Integer.parseInt(arr[2]);
				union(a,b);
			}else {
				sb.append(cnt[find(Integer.parseInt(arr[1]))]).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	public static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) {
			return;
		}
		
		cnt[a] += cnt[b];
		parent[parent[b]] = a;
	}

}