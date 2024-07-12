import java.util.*;
import java.io.*;

public class Main {
	static class Node{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	static ArrayList<ArrayList<Node>> list;
	static ArrayList<Node> test;
	static int[] arr;
	static boolean[] visited;
	static int ans;
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visited = new boolean[N];
		test = new ArrayList<>();
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			test.add(new Node(i, arr[i]));
		}
		
		num = new int[2];
		
//		solve(0);
		
		int s = 0;
		int e = N - 1;
		while(s<=e) {
			int k = sum(s,e);
			max = Math.max(max, k);
			if(arr[s] < arr[e]) {
				s++;
			}else {
				e--;
			}
		}
		System.out.println(max);
		
	}
	static int sum;
	public static int sum(int x, int y) {
		sum = (y - x - 1) * Math.min(arr[x], arr[y]);
		return sum;
	}
	static int between;
	static int[] num;
	static int max = Integer.MIN_VALUE;
	public static void solve(int depth) {
		if(depth == 2) {
			ans = (num[1] - num[0] - 1) * Math.min(arr[num[0]], arr[num[1]]);
			max = Math.max(ans, max);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				num[depth] = i;
				solve(depth + 1);
				visited[i] = false;
			}
		}
	}

}