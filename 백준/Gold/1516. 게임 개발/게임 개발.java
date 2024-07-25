import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] time;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> list;
	static int[] sum;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		sum = new int[N+1];
		indegree = new int[N+1];
		time = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int k = Integer.parseInt(st.nextToken());
				if(k == -1) {
					break;
				}
				list.get(k).add(i);
				indegree[i]++;
			}
		}
		
		topologicalSort();
		
		for(int i = 1; i <= N; i++) {
			System.out.println(time[i] + sum[i]);
		}
	}
	public static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : list.get(now)) {
				indegree[next]--;
				
				sum[next] = Math.max(sum[next], sum[now] + time[now]);
				
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}

}