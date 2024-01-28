import java.util.*;
import java.io.*;

public class Main {
	static int T, N, K;
	static int[] d;//건물의 기본소요시간
	static ArrayList<ArrayList<Integer>> list;
	static int[] indegree;//앞에 만들어야하는 건물 갯수
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			d = new int[N + 1];
			
			list = new ArrayList<ArrayList<Integer>>();
			
			for(int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());	
			}
			
			indegree = new int[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				d[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				list.get(v1).add(v2);
				
				indegree[v2]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			
			topologicalSort(W);
		}
		
		System.out.println(sb);
				
	}
	
	public static void topologicalSort(int W) {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			result[i] = d[i];
			
			if(indegree[i] == 0	) {
				q.offer(i);
			}
			
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(Integer i : list.get(node)) {
				result[i] = Math.max(result[i], result[node] + d[i]);
				indegree[i]--;
				
				if(indegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		
		sb.append(result[W]).append("\n");
	}

}