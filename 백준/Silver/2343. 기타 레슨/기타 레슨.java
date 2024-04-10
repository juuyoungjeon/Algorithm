import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		int s = 0;
		int e = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			e += arr[i];
			s = Math.max(s, arr[i]);
		}
		
		while(s<=e) {
			int mid = (s+e)/2;
			int cnt = get(mid);
			
			if(cnt > M) {
				s = mid + 1;
			}else {
				e = mid - 1;
			}
		}
		
		System.out.println(s);
	}
	public static int get(int mid) {
		int sum = 0;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(sum + arr[i] > mid) {
				sum = 0;
				cnt++;
			}
			sum += arr[i];
		}
		if(sum != 0) cnt++;
		return cnt;
	}

}