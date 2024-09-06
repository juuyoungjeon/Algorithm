import java.util.*;
import java.io.*;

public class Main {

	/*
	 * 두 그룹으로 나눈다.
	 * 그룹내 학생들은 학번이 연속이다. 그룹엔 최소 한명
	 * 두 그룹의 무게 합의 차 E
	 * 최솟값이 여러개면 무게합이 가장큰 두 그룹학생들한테 스테이크를 줌
	 * 
	 * 변수는 학번
	 * 
	 * 누적합
	 * 
	 * 합해서 두그룹 차를 구한다음 가장 작으면 두그룹의 합
	 * */
	static int N;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int mid = 1; mid <= N - 1; mid++) {
			int s = mid;
			int e = mid + 1;
			
			while(s >= 1 && e <= N) {
				int sum1 = arr[mid] - arr[s - 1];
				int sum2 = arr[e] - arr[mid];
				
				if(min > Math.abs(sum1 - sum2)) {
					min = Math.abs(sum1 - sum2);
					ans = sum1 + sum2;
				}else if(min == Math.abs(sum1 - sum2) && ans < (sum1 + sum2)) {
					min = Math.abs(sum1 - sum2);
					ans = sum1 + sum2;
				}
				
				if(sum1 > sum2) {
					e++;
				}else {
					s--;
				}
			}
		}
		
		
		System.out.println(ans);
	}

}