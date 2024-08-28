import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = N - 1;
		int bs = 0;
		int be = 0;
		long min = Integer.MAX_VALUE;
		while(s < e) {
			long sum = arr[s] + arr[e];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				bs = s;
				be = e;
			}
			
			if(sum >= 0) {
				e--;
			}else {
				s++;
			}
		}
		
		System.out.println(arr[bs] + " " + arr[be]);
		
		
	}

}