import java.util.*;
import java.io.*;

public class Main {
	static int K;
	static long sum;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			K = Integer.parseInt(br.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < K; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			sum = 0;
			while(pq.size() > 1) {
				long x = pq.poll();
				long y = pq.poll();
				sum += x + y;
				pq.add(x+y);
			}
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		
	}
}