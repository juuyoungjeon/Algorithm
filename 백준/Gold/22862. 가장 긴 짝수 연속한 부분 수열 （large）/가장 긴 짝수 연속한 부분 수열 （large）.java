import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num % 2 == 0;
		}
		
		int maxLen = 0;
		int l = 0;
		int r = 0;
		int cnt = 0;
		
		while(r < N) {
			if(cnt < K) {
				if(!arr[r]) {//홀수이면
					cnt++;
				}
				r++;
				maxLen = Math.max(r - l - cnt, maxLen);
			}else if(arr[r]) {//짝수이면
				r++;
				maxLen = Math.max(r - l - cnt, maxLen);
			}else {
				if(!arr[l]) {
					cnt--;
				}
				l++;
			}
		}
		
		System.out.println(maxLen);
	}

}