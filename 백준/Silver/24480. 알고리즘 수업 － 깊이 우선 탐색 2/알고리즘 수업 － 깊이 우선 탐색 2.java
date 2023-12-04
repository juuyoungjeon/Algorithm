import java.util.*;
import java.io.*;

public class Main {
	static int N, M, R, cnt;
	static ArrayList<ArrayList<Integer>> list;
	static int[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //vertex
		M = Integer.parseInt(st.nextToken()); //edge
		R = Integer.parseInt(st.nextToken()); //startVer
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		check = new int[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1; i < list.size(); i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		
		cnt = 1;
		dfs(R);
		
		for(int i = 1; i < check.length; i++) {
			sb.append(check[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int node) {
		check[node] = cnt;
		
		for(int i = 0; i < list.get(node).size(); i++) {
			int newNode = list.get(node).get(i);
			if(check[newNode] == 0) {
				cnt++;
				dfs(newNode);
			}
			
		}
	}

}