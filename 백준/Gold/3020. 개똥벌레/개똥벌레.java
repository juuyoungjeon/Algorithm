import java.util.*;
import java.io.*;

public class Main {
	static int N, H;
	//홀수는 석순, 짝수는 종유석
	//장애물을 부시면서 갈 때 최소 값, 구간 몇개?
	static int[] arr, first, second;
	static int[] check;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		first = new int[H+2];
		second = new int[H+2];
		for(int i = 1; i <= N/2; i++) {
			int a = Integer.parseInt(br.readLine());
			int b = H - Integer.parseInt(br.readLine()) + 1;
			first[a]++;
			second[b]++;
		}
		
		for(int i = 1; i <= H; i++) {
			first[i] += first[i-1];
		}
		for(int i = H; i>=1; i--) {
			second[i] += second[i+1];
		}
		
		int min = N;
		int cnt = 0;
		for(int i = 1; i < H + 1; i++) {
			int dif = (first[H] - first[i-1]) + (second[1] - second[i+1]);
			if(dif < min) {
				min = dif;
				cnt = 1;
			}else if(dif == min) cnt++;
		}
		
		System.out.println(min + " " + cnt);
//		arr = new int[N];
//		for(int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		
//		check = new int[H + 1];
//		
//		for(int i = 0; i < N; i++) {
//			for(int j = 1; j <= H; j++) {
//				if(i % 2 == 0) {
//					if(arr[i] >= j) {
//						check[j]++;
//					}
//				}else {
//					if(arr[i] >= H - j + 1) {
//						check[j]++;
//					}
//				}
//			}
//		}
		
		//	*			  *				*
		//arr[0] arr[1] arr[2] arr[3] arr[4] arr[5]
		//	1		3		4	  2		2		4
	
	}

}