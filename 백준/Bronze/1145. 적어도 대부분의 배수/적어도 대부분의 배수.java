import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[5];
		
		for(int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 1;
		int cnt = 0;
		
		while(true) {
			for(int i = 0; i < 5; i++) {
				if(ans % arr[i] == 0) {
					cnt++;
				}
			}
			if(cnt >= 3) {
				System.out.println(ans);
				return;
			}
			cnt = 0;
			ans++;
		}
	}

}