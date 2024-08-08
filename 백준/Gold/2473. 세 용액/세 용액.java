import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long[] arr;
	static int[] best = new int[3];
	static int start, mid, end;
	static long min = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N - 2; i++) {
			start = i;
			mid = i + 1;
			end = N - 1;
			while(mid < end) {
				long sum = arr[start] + arr[mid] + arr[end];
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					best[0] = start;
					best[1] = mid;
					best[2] = end;
				}
				if(sum == 0) {
					break;
				}else if(sum > 0) {
					end--;
				}else {
					mid++;
				}
			}
		}
		
		System.out.println(arr[best[0]] + " " + arr[best[1]] + " "  + arr[best[2]]);
	}

}