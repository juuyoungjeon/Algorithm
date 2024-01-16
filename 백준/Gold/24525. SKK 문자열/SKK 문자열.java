import java.util.*;
import java.io.*;

public class Main {
	static int SIZE = 100_000;
	static int MOD = 1_000_000;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int[] arr = new int[str.length() + 1];
		boolean b = false;
		int[] sCnt = new int[100001];
		int[] kCnt = new int[100001];
		int[] min = new int[300010];
		Arrays.fill(min, MOD);
		min[SIZE] = 0;
		for(int i = 1; i <= str.length(); i++) {
			arr[i] = arr[i-1];
			sCnt[i] = sCnt[i-1];
			kCnt[i] = kCnt[i-1];
			if(str.charAt(i-1) == 'S') {
				arr[i] += 2;
				sCnt[i]++;
			}else if(str.charAt(i - 1) == 'K') {
				arr[i] -= 1;
				kCnt[i]++;
			}
			min[SIZE + arr[i]] = Math.min(min[SIZE + arr[i]], i);
		}
		int res = -1;
		for(int i = 1; i <= str.length(); i++) {
			int left = min[SIZE + arr[i]];
			int size = i - left;
			int k = kCnt[i] - kCnt[left];
			int s = sCnt[i] - sCnt[left];
			if(k != 0 && s != 0) {
				res = Math.max(res, size);
			}
		}
		System.out.println(res);
	}

}