import java.util.*;
import java.io.*;

public class Main {
	static int N, ans;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			ans = Math.max(ans, arr[i]*(N-i));
		}
		System.out.println(ans);
	}

}