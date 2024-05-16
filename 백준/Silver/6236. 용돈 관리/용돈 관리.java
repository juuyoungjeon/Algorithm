import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int K;
	static int max;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		int s = max;
		int e = 10_000 * 100_000;

		while(s<=e) {
			int mid = (s + e) / 2;
			int sum = 0;
			if(M >= withdraw(mid)) {
				ans = mid;
				e = mid - 1;
			}else {
				s = mid + 1;
			}
		}
		
		System.out.println(ans);
	}

	public static int withdraw(int amount) {
		int cnt = 1;
		int money = amount;

		for(int i : arr) {
			money -= i;
			if(money < 0) {
				cnt++;
				money = amount - i;
			}
		}
		return cnt;
	}

}