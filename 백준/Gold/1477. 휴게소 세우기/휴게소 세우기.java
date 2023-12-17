import java.util.*;
import java.io.*;

public class Main {
	static int N, M, L;
	static int low, high;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		arr = new int[N + 2];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[0] = 0;
		arr[N + 1] = L;
		Arrays.sort(arr);

		binarySearch();
		System.out.println(low);

	}
	public static void binarySearch() {
		low = 1;
		high = L - 1;

		while(low <= high) {
			int mid = (low + high) / 2;
			int sum = 0;

			for(int i = 1; i < N + 2; i++) {
				sum += (arr[i] - arr[i - 1] - 1) / mid;
			}	
			if(sum > M) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}

		}
	}

}