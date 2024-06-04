import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] arr;
	static int ans;
	static int[] sensor;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		sensor = new int[N - 1];
		for(int i = 0; i < N - 1; i++) {
			sensor[i] = arr[i+1] - arr[i];
		}
		
		Arrays.sort(sensor);
		
		for(int i = 0; i < N - K; i++) {
			ans += sensor[i];
		}
		
		System.out.println(ans);
		
	}

}