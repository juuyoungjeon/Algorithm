import java.util.*;
import java.io.*;

public class Main {
	static int H,W;
	static int[] arr;
	static int maxHeight;
	static int sum;
	static int idx, check;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		arr = new int[W];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] >= check) {
				check = arr[i];
				idx = i;
			}
		}

		maxHeight = arr[0];
		for(int i = 1; i < idx; i++) {
			if(maxHeight < arr[i]) {
				maxHeight = arr[i];
			}else {
					sum += maxHeight - arr[i]; 
			}
		}

		maxHeight = arr[W-1];
		for(int i = W-2; i > idx; i--) {
			if(maxHeight < arr[i]) {
				maxHeight = arr[i];
			}else {
					sum += maxHeight-arr[i];
			}
		}
		System.out.println(sum);
	}

}