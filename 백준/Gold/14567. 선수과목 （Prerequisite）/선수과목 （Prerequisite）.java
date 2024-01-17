import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N + 1];
		ArrayList<Integer> list[] = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			indegree[B]++;
		}
		
		Queue<int []> q = new LinkedList<>();
		int[] res = new int[N];
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(new int[] {i, 1});
			}
		}
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int idx = arr[0];
			int semester = arr[1];
			res[idx - 1] = semester;
			
			for(int i : list[idx]) {
				if(--indegree[i] == 0) {
					q.offer(new int[] {i, semester + 1});
				}
			}
		}
		for(int i = 0; i < N; i++) {
			sb.append(res[i]).append(' ');
		}
		System.out.println(sb);
	}

}