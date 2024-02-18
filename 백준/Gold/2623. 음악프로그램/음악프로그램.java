import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}
		
		indegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int before = Integer.parseInt(st.nextToken());
			for (int j = 1; j < num; j++) {
				int singer = Integer.parseInt(st.nextToken());
				list.get(before).add(singer);
				indegree[singer]++;
				
				before = singer;
			}
		}
		
		String ans = topologicalSort();
		
		System.out.println(ans);
	}
	
	public static String topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int now = q.poll();
			result.add(now);
			
			for (int next : list.get(now)) {
				indegree[next]--;
				
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		if (result.size() != N) {
			return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + "\n");
		}
		
		return sb.toString();
	}

}