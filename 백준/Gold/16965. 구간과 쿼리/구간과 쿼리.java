import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] visited;
	static ArrayList<Node> list;
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		list.add(new Node(0,0));
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				list.add(new Node(b, c));
			}else {
				visited = new int[n + 1];
				sb.append(dfs(b, c)).append("\n");
			}
		}
		System.out.println(sb);
	}
	public static int dfs(int start, int target) {
		visited[start] = 1;
		if(start == target) {
			return 1;
		}
		int tmp = 0;
		for(int i = 1; i < list.size(); i++) {
			if(visited[i] == 1) {
				continue;
			}
			if((list.get(i).x < list.get(start).x && list.get(start).x < list.get(i).y) || (list.get(i).x < list.get(start).y && list.get(start).y < list.get(i).y)) {
				tmp = tmp | dfs(i, target);
			}
		}
		return tmp;
	}

}