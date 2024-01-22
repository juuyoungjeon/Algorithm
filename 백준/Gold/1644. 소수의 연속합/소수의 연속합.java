import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static ArrayList<Integer> prime = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		getPrime(n);
		
		int left = 0;
		int right = 0;
		int ans = 0;
		int sum = 2;
		int size = prime.size();
		
		while(left < size && right < size) {
			if(sum == n) {
				ans++;
				sum -= prime.get(left);
				left++;
			}
			else if(sum > n) {
				sum -= prime.get(left);
				left++;
			}else {
				right++;
				if(right >= size) break;
				sum+= prime.get(right);
			}
		}
		System.out.println(ans);
	}
	static void getPrime(int n) {
		int tmp[] = new int[n+1];
		int rootN = (int)Math.sqrt(n);
		for(int i = 2;  i <= n; i++) {
			tmp[i] = i;
		}
		
		for(int i = 2; i <= rootN; i++) {
			if(tmp[i] != 0) {
				for(int j = i+i; j <= n; j+= i) {
					tmp[j] = 0;
				}
			}
		}
		for(int i = 2; i <= n; i++) {
			if(tmp[i] != 0) {
				prime.add(tmp[i]);
			}
		}
	}
}