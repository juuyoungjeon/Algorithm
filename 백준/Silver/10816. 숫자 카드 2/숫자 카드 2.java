import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] card;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		M = Integer.parseInt(br.readLine());

		card = new int[M];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < M; i++) {
			sb.append(binarySearch(card[i]) + " ");
		}

		System.out.println(sb);
	}
	public static int binarySearch(int num) {
		//lower_bound
		int s = 0;
		int e = N - 1;
		int l = e + 1;
		while(s <= e) {
			int mid = (s + e) / 2;
			if(arr[mid] >= num) {
				l = mid;
				e = mid - 1;
			}else {
				s = mid + 1;
			}
		}
		
		//upper_bound
		s = 0;
		e = N - 1;
		int r = e + 1;
		while(s <= e) {
			int mid = (s+e) / 2;
			if(arr[mid] > num) {
				r = mid;
				e = mid - 1;
			}else {
				s = mid + 1;
			}
		}
		
		return r - l;
	}

}