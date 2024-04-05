import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] X, arr;
	static long[] prefixSum;
	static int Q;
	static int L,R;
	static StringBuilder sb = new StringBuilder();
	static HashMap<Integer, Integer> hm = new HashMap<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		prefixSum = new long[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= K; i++) {
			int a = Integer.parseInt(st.nextToken());
			hm.put(a, hm.getOrDefault(a, 0) + 1);
		}
		for(Map.Entry<Integer, Integer> entrySet : hm.entrySet()) {
			int jump = entrySet.getKey();
			int cnt = entrySet.getValue();
			something(jump, cnt);
		}
		for(int j = 1; j <= N; j++) {
			prefixSum[j] = prefixSum[j-1] + arr[j];
//				sb.append(j +" : " + prefixSum[j]+ " ");
		}
//			sb.append("\n");
		
		
		Q = Integer.parseInt(br.readLine());
		for(int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			sb.append(prefixSum[R+1] - prefixSum[L]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void something(int jump, int cnt) {
		int i = 1;
		while(i <= N) {
			arr[i] += cnt;
			i += jump;
		}
	}

}