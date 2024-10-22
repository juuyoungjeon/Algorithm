import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int ans;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int s = 0;
			int e = N - 1;
			while(s<=e) {
				int mid = (s + e) / 2;
				if(arr[mid] < a) {
					s = mid + 1;
				}else {
					e = mid -1;
				}
			}
			int startIdx = s;
			
			s = 0;
			e = N - 1;
			while(s<=e) {
				int mid = (s+e) /2;
				if(arr[mid] > b) {
					e = mid - 1;
				}else {
					s = mid + 1;
				}
			}
			int endIdx = e;

			
			sb.append(endIdx - startIdx + 1).append("\n");
		}

		System.out.println(sb);
	}

}