import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] A,B;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		B = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		arr = new long[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = B[i] - A[i];
		}
		
		for(int i = 1; i <= N; i++) {
			arr[i] = arr[i] + arr[i-1];
		}
		
		long res = 0;
		long cnt = 0;
		
		HashMap<Long, Long> hm = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			if(arr[i] == 0) {
				res++;
			}
			
			if(hm.containsKey(arr[i] - 0)) {
				cnt = hm.get(arr[i] - 0);
			}else {
				cnt = 0;
			}
			
			res += cnt;
			
			long a = 1;
			
			if(hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
			}else {
				hm.put(arr[i], a);
			}
		}
		
		System.out.println(res);
		
	}

}