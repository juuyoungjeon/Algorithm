import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] size;
	static long cnt;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		size = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(size);

		for(int i = 0; i < N - 1; i++) {
			cnt += binarySearch(i) - i;			
		}

		System.out.println(cnt);
	}
	public static int binarySearch(int start) {
		int s = start + 1;
		int e = N - 1;
		ans = start;
		
		if(size[start] * 10 < size[start+1] * 9) {
			return start;
		}
		while(s<=e) {
			int mid = (s+e)/2;
			if(size[start] * 10>= size[mid] *9) {
				ans = mid;
				s = mid + 1;
			}else {
				e = mid - 1;
			}
		}
		return ans;
	}
}