import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static int[] indegree;
	static int[] time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		indegree = new int[N + 1];
		time = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			time[i] = Integer.parseInt(st.nextToken());
			
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				list.get(tmp).add(i);
				
				indegree[i]++;
			}
		}
		
		System.out.println(topological());
	}
	
	public static int topological() {
		Queue<Integer> q = new LinkedList<>();
		
		int[] result = new int[N+1];
		for (int i = 1; i <= N; i++) {
			result[i] = time[i];
			
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : list.get(now)) {
				indegree[next]--;
				
				result[next] = Math.max(result[next], result[now] + time[next]);
				
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		int ans = 0;
		
		for(int i = 1; i <= N; i++) {
			ans = Math.max(ans, result[i]);
		}
		
		return ans;
	}

}