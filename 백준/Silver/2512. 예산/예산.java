import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int s = 0;
		int e = arr[N-1];
		while(s<=e) {
			int sum = 0;
			int mid = (s + e) / 2;
			for(int i = 0; i < N; i++) {
				if(arr[i] > mid) {
					sum += mid;
				}else {
					sum += arr[i];
				}
			}
			if(sum <= M) {
				s = mid + 1;
			}else if(sum > M) {
				e = mid - 1;
			}
		}
		
		System.out.println(e);
	}
	

}