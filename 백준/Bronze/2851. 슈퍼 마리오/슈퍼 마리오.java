import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10];
		int[] sumArr1 = new int[10];
		int[] sumArr2 = new int[10];
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			sumArr1[i] = Math.abs(100 - sum);
			sumArr2[i] = sum;
			min = Math.min(min, sumArr1[i]);
		}
		
//		int cnt = 0;
		int idx = 0;
		//Arrays.sort(sumArr1);
		for(int i = 0; i < 10; i++) {
			if(min == sumArr1[i]) {
//				cnt++;
				idx = i;
			}

		}
		
//		System.out.println(idx);
//		System.out.println(cnt);
//		System.out.println(sumArr1[idx]);
		System.out.println(sumArr2[idx]);
		
		
	}

}