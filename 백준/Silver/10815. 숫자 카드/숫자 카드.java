import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] card;
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
			int s = 0;
			int e = N - 1;
			boolean check = false;
			while(s <= e) {
				int mid = (s + e)/ 2;
				if(arr[mid] > card[i]) {
					e = mid - 1;
				}else if(arr[mid] < card[i]){
					s = mid + 1;
				}else if(arr[mid] == card[i]) {
					check = true;
					break;
				}
			}
			if(check) {
				sb.append(1).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.println(sb);
		
	}

}