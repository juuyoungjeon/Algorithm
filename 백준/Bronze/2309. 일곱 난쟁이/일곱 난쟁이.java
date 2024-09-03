import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static int sum;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		int n = sum - 100;
		int s = 0;
		int e = 8;
		
		while(s<e) {
			if(arr[s] + arr[e] == n) {
				arr[s] = 0;
				arr[e] = 0;
				break;
			}
			if(arr[s] + arr[e] < n) {
				s++;
			}else {
				e--;
			}
		}
		
		Arrays.sort(arr);
		
		for(int i = 2; i < 9; i++) {
			System.out.println(arr[i]);
		}
		
		
	}

}