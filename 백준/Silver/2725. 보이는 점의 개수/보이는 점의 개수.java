import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(br.readLine());
		int[] arr = new int[1002];
		
		arr[1] = 3;
		for(int i = 2; i <= 1000; i++) {
			int cnt = 0;
			for(int j = 1; j < i; j++) {
				if(gcd(i,j) == 1) {
					cnt++;
				}
				arr[i] = arr[i-1] + 2 * cnt;
			}
		}
		for(int i = 0; i < C; i++) {
			int a = Integer.parseInt(br.readLine());
			//소수? 기울기가 없어야됨?
			//(아래꺼 갯수 + 1) *2 + 1
			sb.append(arr[a]).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static int gcd(int a, int b) {
		int tmp;
		while(b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}

}